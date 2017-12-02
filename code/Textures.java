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
		private static BufferedImage blueGutterEast;
		private static BufferedImage blueGutterWest;
		private static BufferedImage blueRidgeEast;
		private static BufferedImage blueRidgeWest;
		private static BufferedImage blueRoofEast;
		private static BufferedImage blueRoofWest;
		private static BufferedImage fenceEast;
		private static BufferedImage fenceNorth;
		private static BufferedImage fenceNorthEast;
		private static BufferedImage fenceNorthWest;
		private static BufferedImage fenceSouth;
		private static BufferedImage fenceSouthEast;
		private static BufferedImage fenceSouthWest;
		private static BufferedImage fenceWest;
		private static BufferedImage grass;
		private static BufferedImage lamp;
		private static BufferedImage magentaFlower;
		private static BufferedImage pavement;
		private static BufferedImage pavementCornerNorthEast;
		private static BufferedImage pavementCornerNorthWest;
		private static BufferedImage pavementCornerSouthEast;
		private static BufferedImage pavementCornerSouthWest;
		private static BufferedImage pavementEast;
		private static BufferedImage pavementNorth;
		private static BufferedImage pavementNorthEast;
		private static BufferedImage pavementNorthWest;
		private static BufferedImage pavementSouth;
		private static BufferedImage pavementSouthEast;
		private static BufferedImage pavementSouthWest;
		private static BufferedImage pavementWest;
		private static BufferedImage purpleFlower;
		private static BufferedImage redGutterEast;
		private static BufferedImage redGutterWest;
		private static BufferedImage redRidgeEast;
		private static BufferedImage redRidgeWest;
		private static BufferedImage redRoofEast;
		private static BufferedImage redRoofWest;
		private static BufferedImage tiles;
		private static BufferedImage water;
		private static BufferedImage yellowFlower;

		static {
			BufferedImage tileset = getTexture("img/overworld/overworld_tileset.png");

			asphalt = getTile(tileset, 3, 2);
			blueGutterEast = getTile(tileset, 5, 7);
			blueGutterWest = getTile(tileset, 0, 7);
			blueRidgeEast = getTile(tileset, 3, 7);
			blueRidgeWest = getTile(tileset, 2, 7);
			blueRoofEast = getTile(tileset, 4, 7);
			blueRoofWest = getTile(tileset, 1, 7);
			fenceEast = getTile(tileset, 2, 10);
			fenceNorth = getTile(tileset, 1, 9);
			fenceNorthEast = getTile(tileset, 2, 9);
			fenceNorthWest = getTile(tileset, 0, 9);
			fenceSouth = getTile(tileset, 1,11);
			fenceSouthEast = getTile(tileset, 2, 11);
			fenceSouthWest = getTile(tileset, 0, 11);
			fenceWest = getTile(tileset, 0, 10);
			grass = getTile(tileset, 1, 1);
			lamp = getTile(tileset, 1, 10);
			magentaFlower = getTile(tileset, 5, 2);
			pavement = getTile(tileset, 5, 0);
			pavementCornerNorthEast = getTile(tileset, 0, 2);
			pavementCornerNorthWest = getTile(tileset, 2, 2);
			pavementCornerSouthEast = getTile(tileset, 0, 0);
			pavementCornerSouthWest = getTile(tileset, 2, 0);
			pavementEast = getTile(tileset, 0, 1);
			pavementNorth = getTile(tileset, 1, 2);
			pavementNorthEast = getTile(tileset, 4, 0);
			pavementNorthWest = getTile(tileset, 3, 0);
			pavementSouth = getTile(tileset, 1, 0);
			pavementSouthEast = getTile(tileset, 4, 1);
			pavementSouthWest = getTile(tileset, 3, 1);
			pavementWest = getTile(tileset, 2, 1);
			purpleFlower = getTile(tileset, 5, 1);
			redGutterEast = getTile(tileset, 5, 4);
			redGutterWest = getTile(tileset, 0, 4);
			redRidgeEast = getTile(tileset, 3, 4);
			redRidgeWest = getTile(tileset, 2, 4);
			redRoofEast = getTile(tileset, 4, 4);
			redRoofWest = getTile(tileset, 1, 4);
			tiles = getTile(tileset, 6, 11);
			yellowFlower = getTile(tileset, 4, 2);
			water = getTile(tileset, 5, 11);
		}

		private static BufferedImage getTile(BufferedImage tileset, int x, int y) {
			return tileset.getSubimage(32 * x, 32 * y, 32, 32);
		}

		public static BufferedImage getAsphalt() {
			return asphalt;
		}

		public static BufferedImage getBlueGutterEast() {
			return blueGutterEast;
		}

		public static BufferedImage getBlueGutterWest() {
			return blueGutterWest;
		}

		public static BufferedImage getBlueRidgeEast() {
			return blueRidgeEast;
		}

		public static BufferedImage getBlueRidgeWest() {
			return blueRidgeWest;
		}

		public static BufferedImage getBlueRoofEast() {
			return blueRoofEast;
		}

		public static BufferedImage getBlueRoofWest() {
			return blueRoofWest;
		}

		public static BufferedImage getFenceEast() {
			return fenceEast;
		}

		public static BufferedImage getFenceNorth() {
			return fenceNorth;
		}

		public static BufferedImage getFenceNorthEast() {
			return fenceNorthEast;
		}

		public static BufferedImage getFenceNorthWest() {
			return fenceNorthWest;
		}

		public static BufferedImage getFenceSouth() {
			return fenceSouth;
		}

		public static BufferedImage getFenceSouthEast() {
			return fenceSouthEast;
		}

		public static BufferedImage getFenceSouthWest() {
			return fenceSouthWest;
		}

		public static BufferedImage getFenceWest() {
			return fenceWest;
		}

		public static BufferedImage getGrass() {
			return grass;
		}

		public static BufferedImage getLamp() {
			return lamp;
		}

		public static BufferedImage getMagentaFlower() {
			return magentaFlower;
		}

		public static BufferedImage getPavement() {
			return pavement;
		}

		public static BufferedImage getPavementCornerNorthEast() {
			return pavementCornerNorthEast;
		}

		public static BufferedImage getPavementCornerNorthWest() {
			return pavementCornerNorthWest;
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

		public static BufferedImage getPavementNorthEast() {
			return pavementNorthEast;
		}

		public static BufferedImage getPavementNorthWest() {
			return pavementNorthWest;
		}

		public static BufferedImage getPavementSouth() {
			return pavementSouth;
		}

		public static BufferedImage getPavementSouthEast() {
			return pavementSouthEast;
		}

		public static BufferedImage getPavementSouthWest() {
			return pavementSouthWest;
		}

		public static BufferedImage getPavementWest() {
			return pavementWest;
		}

		public static BufferedImage getPurpleFlower() {
			return purpleFlower;
		}

		public static BufferedImage getRedGutterEast() {
			return redGutterEast;
		}

		public static BufferedImage getRedGutterWest() {
			return redGutterWest;
		}

		public static BufferedImage getRedRidgeEast() {
			return redRidgeEast;
		}

		public static BufferedImage getRedRidgeWest() {
			return redRidgeWest;
		}

		public static BufferedImage getRedRoofEast() {
			return redRoofEast;
		}

		public static BufferedImage getRedRoofWest() {
			return redRoofWest;
		}

		public static BufferedImage getTiles() {
			return tiles;
		}

		public static BufferedImage getWater() {
			return water;
		}

		public static BufferedImage getYellowFlower() {
			return yellowFlower;
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
