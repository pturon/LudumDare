package code.views;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import code.Tilemap;
import code.entities.Actor;
import code.entities.Milkman;

public abstract class Scene extends View {
	protected Milkman milkman;
	protected List<Actor> actors = new ArrayList<>();
	protected Tilemap terrain;

	public Scene(String pathToTerrainMap, Class<? extends Scene> parentClass) {
		terrain = new Tilemap(pathToTerrainMap, parentClass);
	}

	public List<Actor> getActors() {
		return actors;
	}

	public Milkman getMilkman() {
		return milkman;
	}

	public boolean isPixelSolid(int pixelX, int pixelY) {
		return terrain.getMaterialAt(pixelX, pixelY).isSolid();
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			Milkman.setLeftPressed(true);
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			Milkman.setRightPressed(true);
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			Milkman.setUpPressed(true);
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			Milkman.setDownPressed(true);
			break;
		default:
			break;
		}
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			Milkman.setLeftPressed(false);
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			Milkman.setRightPressed(false);
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			Milkman.setUpPressed(false);
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			Milkman.setDownPressed(false);
			break;
		default:
			break;
		}
	}

	public void step() {
		//copy list to avoid concurrent-modification-exception
		Actor[] threadSafeActors = actors.toArray(new Actor[0]);
		for(Actor actor : threadSafeActors) {
			actor.step();
		}
	}
}
