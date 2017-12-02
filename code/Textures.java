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

	public static class Terrain {
		private Terrain() {
			//no instance allowed
		}

		private static BufferedImage asphalt;
		private static BufferedImage flowers;
		private static BufferedImage grass;
		private static BufferedImage pavementCornerSouthEast;
		private static BufferedImage pavementCornerSouthWest;
		private static BufferedImage pavementEast;
		private static BufferedImage pavementNorth;
		private static BufferedImage pavementNorthWest;
		private static BufferedImage pavementSouth;
		private static BufferedImage pavementWest;

		static {
			BufferedImage tileset = getTexture("img/overworld/overworld_tileset.png");

			asphalt = getTile(tileset, 3, 2);
			flowers = getTile(tileset, 4, 2);
			grass = getTile(tileset, 1, 1);
			pavementCornerSouthEast = getTile(tileset, 0, 0);
			pavementCornerSouthWest = getTile(tileset, 2, 0);
			pavementEast = getTile(tileset, 0, 1);
			pavementNorth = getTile(tileset, 1, 2);
			pavementNorthWest = getTile(tileset, 3, 0);
			pavementSouth = getTile(tileset, 1, 0);
			pavementWest = getTile(tileset, 2, 1);
		}

		private static BufferedImage getTile(BufferedImage tileset, int x, int y) {
			return tileset.getSubimage(32 * x, 32 * y, 32, 32);
		}

		public static BufferedImage getAsphalt() {
			return asphalt;
		}

		public static BufferedImage getFlowers() {
			return flowers;
		}

		public static BufferedImage getGrass() {
			return grass;
		}

		public static BufferedImage getPavementCornerSouthEast() {
			return pavementCornerSouthEast;
		}

		public static BufferedImage getPavementCornerSouthWest() {
			return pavementCornerSouthWest;
		}

		public static BufferedImage getPavementEast() {
			return pavementEast;
		}

		public static BufferedImage getPavementNorth() {
			return pavementNorth;
		}

		public static BufferedImage getPavementNorthWest() {
			return pavementNorthWest;
		}

		public static BufferedImage getPavementSouth() {
			return pavementSouth;
		}

		public static BufferedImage getPavementWest() {
			return pavementWest;
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
