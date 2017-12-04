package code;

import code.views.View;

/**
 * The Clock ticks in evenly time-intervalls to generate smooth animations.
 * In each tick the clock calls the step()-method of the active view.
 */
public class Clock {
	private static View currentView;

	private static final int STEPS_PER_SECOND = 128;
	private static long delay = 1000000000 / STEPS_PER_SECOND;
	private static long lastStep = System.nanoTime();
	private static long currentTime = System.nanoTime();
	private static boolean paused = false;

	private Clock() {
		//no instance allowed
	}

	/**
	 * Static constructor, which creates the clock.
	 */
	static {
		Thread thread = new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						currentTime = System.nanoTime();
						if(currentTime - lastStep > delay) {
							if(currentView != null && !paused) {
								currentView.step();
							}
							lastStep = lastStep + delay;
						}

						Thread.sleep(1);
					} catch(InterruptedException exception) {
						Thread.currentThread().interrupt();
					}
				}
			}
		};
		thread.setName("Clock");
		thread.start();
	}

	public static int getStepsPerSecond() {
		return STEPS_PER_SECOND;
	}

	public static void pause() {
		paused = true;
	}

	public static void unpause() {
		paused = false;
	}

	public static boolean isPaused() {
		return paused;
	}

	/**
	 * Sets the view whose step()-method is called.
	 * @param view The view whose step()-method is called.
	 */
	public static void setCurrentView(View view) {
		if(view != null) {
			currentView = view;
		}
	}
}
