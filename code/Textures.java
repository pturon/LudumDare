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
			private static BufferedImage[][][] walking = new BufferedImage[4][4][9];

			private Milkman() {
				//no instance allowed
			}

			static {
				BufferedImage milkmanSpritesheet = getTexture("img/milkman/milkman_spritesheet.png");
				for(int direction = 0; direction < 4; direction++) {
					for(int frame = 0; frame < 4; frame++) {
						for(int bottles = 0; bottles < 6; bottles++) {
							walking[direction][frame][bottles] = milkmanSpritesheet.getSubimage(bottles * 128 + frame * 32, direction * 32, 32, 32);
						}
						walking[direction][frame][8] = walking[direction][frame][5];
						walking[direction][frame][7] = walking[direction][frame][5];
						walking[direction][frame][6] = walking[direction][frame][4];
						walking[direction][frame][5] = walking[direction][frame][4];
						walking[direction][frame][4] = walking[direction][frame][3];
					}
				}
			}

			public static BufferedImage getWalkCycle(int direction, int frame, int bottles) {
				return walking[direction % 4][frame % 4][bottles % 9];
			}
		}
	}
}
