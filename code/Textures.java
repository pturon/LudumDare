package code;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Textures {
	private Textures() {
		//no instance allowed
	}

	private static BufferedImage getTexture(String path) {
		try {
			return ImageIO.read(ClassLoader.getSystemClassLoader().getResource(path));
		} catch (Exception exception) {
			return null;
		}
	}

	public static class Sprites {
		private Sprites() {
			//no instance allowed
		}

		public static class Milkman {
			private static BufferedImage[][] walking = new BufferedImage[4][4];

			private Milkman() {
				//no instance allowed
			}

			static {
				BufferedImage milkmanSpritesheet = getTexture("img/milkman/milkman_spritesheet.png");
				for(int direction = 0; direction < 4; direction++) {
					for(int frame = 0; frame < 4; frame++) {
						walking[direction][frame] = milkmanSpritesheet.getSubimage(frame * 32, direction * 32, 32, 32);
					}
				}
			}

			public static BufferedImage getWalkCycle(int direction, int frame) {
				return walking[direction % 4][frame % 4];
			}
		}
	}
}
