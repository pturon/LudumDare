package code;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import code.views.Menu;
import code.views.View;

public class MainFrame extends Frame {
	private static MainFrame instance = null;

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private JPanel panel;
	private transient View currentView = new Menu(1);

	private boolean debugging = false;

	public static void main(String[] args) {
		GraphicsThread graphicsThread = MainFrame.getInstance().new GraphicsThread();
		graphicsThread.setName("Graphics");
		graphicsThread.start();
	}

	private MainFrame() {
		setResizable(false);
		setTitle("Milk Hunt");

	    //Icon
	    URL imgIcon = ClassLoader.getSystemClassLoader().getResource("Icon.png");
	    setIconImage(new ImageIcon(imgIcon).getImage());

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});

	    //set position to the center of the screen
	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((d.width - WIDTH) / 2, (d.height - HEIGHT) / 2);

  		panel = new JPanel() {
  			@Override
			public void paint(Graphics g) {
				if(currentView != null)g.drawImage(currentView.getImage(debugging), 0, 0, null);
			}
		};
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(panel);

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				//not used at the moment
			}

			@Override
			public void keyPressed(KeyEvent keyEvent) {
				if(currentView != null) {
					currentView.onKeyPressed(keyEvent);
				}
				if(keyEvent.getKeyCode() == KeyEvent.VK_F3) {
					debugging = !debugging;
				}
			}

			@Override
			public void keyReleased(KeyEvent keyEvent) {
				if(currentView != null)currentView.onKeyReleased(keyEvent);
			}
		});

		panel.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent mouseEvent) {
				if(currentView != null) {
					currentView.onMouseMoved(mouseEvent);
				}	
			}

			@Override
			public void mouseMoved(MouseEvent mouseEvent) {
				if(currentView != null) {
					currentView.onMouseMoved(mouseEvent);
				}				
			}
			
		});
		
		panel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				//not used at the moment
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent) {
				//not used at the moment
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent) {
				//not used at the moment
			}

			@Override
			public void mousePressed(MouseEvent mouseEvent) {
				if(currentView != null) {
					currentView.onMousePressed(mouseEvent);
				}	
			}

			@Override
			public void mouseReleased(MouseEvent mouseEvent) {
				if(currentView != null) {
					currentView.onMouseReleased(mouseEvent);
				}	
			}
			
		});
		
		Clock.setCurrentView(currentView);

		pack();
		setVisible(true);
		AudioManager.enable();
	}

	private class GraphicsThread extends Thread implements Runnable {
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1);
				} catch(Exception e) {
					Thread.currentThread().interrupt();
				}
				panel.repaint();
			}
		}
	}

	public static synchronized MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}

	public void setCurrentView(View view){
		this.currentView = view;
		Clock.setCurrentView(currentView);
	}
}
