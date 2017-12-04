package code;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioManager {
	private static boolean enabled = true;

	private static Clip background;
	private static Clip bottle;
	private static Clip cow;

	private AudioManager() {
		//no instance allowed
	}

	static {
		//load main-theme
		try {
	        URL backgroundUrl = ClassLoader.getSystemClassLoader().getResource("sound/milkhunt.wav");
	        AudioInputStream backgroundStream = AudioSystem.getAudioInputStream(backgroundUrl);
	        background = AudioSystem.getClip();
	        background.open(backgroundStream);
		} catch(Exception exception) {
			exception.printStackTrace();
		}

		//load bottle-soundeffect
		try {
	        URL bottleUrl = ClassLoader.getSystemClassLoader().getResource("sound/bottle_sound.wav");
	        AudioInputStream bottleStream = AudioSystem.getAudioInputStream(bottleUrl);
	        bottle = AudioSystem.getClip();
	        bottle.open(bottleStream);
		} catch(Exception exception) {
			exception.printStackTrace();
		}

		//load cow-soundeffect
		try {
	        URL cowUrl = ClassLoader.getSystemClassLoader().getResource("sound/cow.wav");
	        AudioInputStream cowStream = AudioSystem.getAudioInputStream(cowUrl);
	        cow = AudioSystem.getClip();
	        cow.open(cowStream);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void enable() {
		enabled = true;
		background.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public static void disable() {
		enabled = false;
		background.stop();
	}

	public static void playBottleSound() {
		if(enabled) {
			bottle.setFramePosition(0);
			bottle.start();
		}
	}

	public static void playCowSound() {
		if(enabled) {
			cow.setFramePosition(0);
			cow.start();
		}
	}
}
