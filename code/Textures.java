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
		private static BufferedImage bridgeHorizontalNorth;
		private static BufferedImage bridgeHorizontalNorthEast;
		private static BufferedImage bridgeHorizontalNorthWest;
		private static BufferedImage bridgeHorizontalSouth;
		private static BufferedImage bridgeHorizontalSouthEast;
		private static BufferedImage bridgeHorizontalSouthWest;
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
		private static BufferedImage roofBlueHorizontalNorth;
		private static BufferedImage roofBlueHorizontalNorthChimney;
		private static BufferedImage roofBlueHorizontalNorthEastGutter;
		private static BufferedImage roofBlueHorizontalNorthEastRidge;
		private static BufferedImage roofBlueHorizontalNorthGutter;
		private static BufferedImage roofBlueHorizontalNorthRidge;
		private static BufferedImage roofBlueHorizontalNorthWestGutter;
		private static BufferedImage roofBlueHorizontalNorthWestRidge;
		private static BufferedImage roofBlueHorizontalNorthWindow;
		private static BufferedImage roofBlueHorizontalSouth;
		private static BufferedImage roofBlueHorizontalSouthChimney;
		private static BufferedImage roofBlueHorizontalSouthEastGutter;
		private static BufferedImage roofBlueHorizontalSouthEastRidge;
		private static BufferedImage roofBlueHorizontalSouthGutter;
		private static BufferedImage roofBlueHorizontalSouthRidge;
		private static BufferedImage roofBlueHorizontalSouthWestGutter;
		private static BufferedImage roofBlueHorizontalSouthWestRidge;
		private static BufferedImage roofBlueHorizontalSouthWindow;
		private static BufferedImage roofBlueVerticalEast;
		private static BufferedImage roofBlueVerticalEastChimney;
		private static BufferedImage roofBlueVerticalEastGutter;
		private static BufferedImage roofBlueVerticalEastRidge;
		private static BufferedImage roofBlueVerticalEastWindow;
		private static BufferedImage roofBlueVerticalNorthEastGutter;
		private static BufferedImage roofBlueVerticalNorthWestGutter;
		private static BufferedImage roofBlueVerticalSouthEastGutter;
		private static BufferedImage roofBlueVerticalSouthWestGutter;
		private static BufferedImage roofBlueVerticalWest;
		private static BufferedImage roofBlueVerticalWestChimney;
		private static BufferedImage roofBlueVerticalWestGutter;
		private static BufferedImage roofBlueVerticalWestRidge;
		private static BufferedImage roofBlueVerticalWestWindow;
		private static BufferedImage roofRedHorizontalNorth;
		private static BufferedImage roofRedHorizontalNorthChimney;
		private static BufferedImage roofRedHorizontalNorthEastGutter;
		private static BufferedImage roofRedHorizontalNorthEastRidge;
		private static BufferedImage roofRedHorizontalNorthGutter;
		private static BufferedImage roofRedHorizontalNorthRidge;
		private static BufferedImage roofRedHorizontalNorthWestGutter;
		private static BufferedImage roofRedHorizontalNorthWestRidge;
		private static BufferedImage roofRedHorizontalNorthWindow;
		private static BufferedImage roofRedHorizontalSouth;
		private static BufferedImage roofRedHorizontalSouthChimney;
		private static BufferedImage roofRedHorizontalSouthEastGutter;
		private static BufferedImage roofRedHorizontalSouthEastRidge;
		private static BufferedImage roofRedHorizontalSouthGutter;
		private static BufferedImage roofRedHorizontalSouthRidge;
		private static BufferedImage roofRedHorizontalSouthWestGutter;
		private static BufferedImage roofRedHorizontalSouthWestRidge;
		private static BufferedImage roofRedHorizontalSouthWindow;
		private static BufferedImage roofRedVerticalEast;
		private static BufferedImage roofRedVerticalEastChimney;
		private static BufferedImage roofRedVerticalEastGutter;
		private static BufferedImage roofRedVerticalEastRidge;
		private static BufferedImage roofRedVerticalEastWindow;
		private static BufferedImage roofRedVerticalNorthEastGutter;
		private static BufferedImage roofRedVerticalNorthWestGutter;
		private static BufferedImage roofRedVerticalSouthEastGutter;
		private static BufferedImage roofRedVerticalSouthWestGutter;
		private static BufferedImage roofRedVerticalWest;
		private static BufferedImage roofRedVerticalWestChimney;
		private static BufferedImage roofRedVerticalWestGutter;
		private static BufferedImage roofRedVerticalWestRidge;
		private static BufferedImage roofRedVerticalWestWindow;
		private static BufferedImage tiles;
		private static BufferedImage water;
		private static BufferedImage yellowFlower;

		static {
			BufferedImage tileset = getTexture("img/overworld/overworld_tileset.png");

			asphalt = getTile(tileset, 3, 2);
			bridgeHorizontalNorth = getTile(tileset, 6, 9);
			bridgeHorizontalNorthEast = getTile(tileset, 7, 9);
			bridgeHorizontalNorthWest = getTile(tileset, 5, 9);
			bridgeHorizontalSouth = getTile(tileset, 6, 10);
			bridgeHorizontalSouthEast = getTile(tileset, 7, 10);
			bridgeHorizontalSouthWest = getTile(tileset, 5, 10);
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
			roofBlueHorizontalNorth = getTile(tileset, 4, 13);
			roofBlueHorizontalNorthChimney = getTile(tileset, 3, 13);
			roofBlueHorizontalNorthEastGutter = getTile(tileset, 5, 12);
			roofBlueHorizontalNorthEastRidge = getTile(tileset, 5, 14);
			roofBlueHorizontalNorthGutter = getTile(tileset, 4, 12);
			roofBlueHorizontalNorthRidge = getTile(tileset, 4, 14);
			roofBlueHorizontalNorthWestGutter = getTile(tileset, 3, 12);
			roofBlueHorizontalNorthWestRidge = getTile(tileset, 3, 14);
			roofBlueHorizontalNorthWindow = getTile(tileset, 5, 13);
			roofBlueHorizontalSouth = getTile(tileset, 4, 16);
			roofBlueHorizontalSouthChimney = getTile(tileset, 3, 16);
			roofBlueHorizontalSouthEastGutter = getTile(tileset, 5, 17);
			roofBlueHorizontalSouthEastRidge = getTile(tileset, 5, 15);
			roofBlueHorizontalSouthGutter = getTile(tileset, 4, 17);
			roofBlueHorizontalSouthRidge = getTile(tileset, 4, 15);
			roofBlueHorizontalSouthWestGutter = getTile(tileset, 3, 17);
			roofBlueHorizontalSouthWestRidge = getTile(tileset, 4, 15);
			roofBlueHorizontalSouthWindow = getTile(tileset, 5, 16);
			roofBlueVerticalEast = getTile(tileset, 4, 7);
			roofBlueVerticalEastChimney = getTile(tileset, 4, 8);
			roofBlueVerticalEastGutter = getTile(tileset, 5, 7);
			roofBlueVerticalEastRidge = getTile(tileset, 3, 7);
			roofBlueVerticalEastWindow = getTile(tileset, 4, 6);
			roofBlueVerticalNorthEastGutter = getTile(tileset, 5, 6);
			roofBlueVerticalNorthWestGutter = getTile(tileset, 0, 6);
			roofBlueVerticalSouthEastGutter = getTile(tileset, 5, 8);
			roofBlueVerticalSouthWestGutter = getTile(tileset, 0, 8);
			roofBlueVerticalWest = getTile(tileset, 1, 7);
			roofBlueVerticalWestChimney = getTile(tileset, 1, 8);
			roofBlueVerticalWestGutter = getTile(tileset, 0, 7);
			roofBlueVerticalWestRidge = getTile(tileset, 2, 7);
			roofBlueVerticalWestWindow = getTile(tileset, 1, 6);
			roofRedHorizontalNorth = getTile(tileset, 1, 13);
			roofRedHorizontalNorthChimney = getTile(tileset, 0, 13);
			roofRedHorizontalNorthEastGutter = getTile(tileset, 2, 12);
			roofRedHorizontalNorthEastRidge = getTile(tileset, 2, 14);
			roofRedHorizontalNorthGutter = getTile(tileset, 1, 12);
			roofRedHorizontalNorthRidge = getTile(tileset, 1, 14);
			roofRedHorizontalNorthWestGutter = getTile(tileset, 0, 12);
			roofRedHorizontalNorthWestRidge = getTile(tileset, 0, 14);
			roofRedHorizontalNorthWindow = getTile(tileset, 2, 13);
			roofRedHorizontalSouth = getTile(tileset, 1, 16);
			roofRedHorizontalSouthChimney = getTile(tileset, 0, 16);
			roofRedHorizontalSouthEastGutter = getTile(tileset, 2, 17);
			roofRedHorizontalSouthEastRidge = getTile(tileset, 2, 15);
			roofRedHorizontalSouthGutter = getTile(tileset, 1, 17);
			roofRedHorizontalSouthRidge = getTile(tileset, 1, 15);
			roofRedHorizontalSouthWestGutter = getTile(tileset, 0, 17);
			roofRedHorizontalSouthWestRidge = getTile(tileset, 0, 15);
			roofRedHorizontalSouthWindow = getTile(tileset, 2, 16);
			roofRedVerticalEast = getTile(tileset, 4, 4);
			roofRedVerticalEastChimney = getTile(tileset, 4, 5);
			roofRedVerticalEastGutter = getTile(tileset, 5, 4);
			roofRedVerticalEastRidge = getTile(tileset, 3, 4);
			roofRedVerticalEastWindow = getTile(tileset, 4, 3);
			roofRedVerticalNorthEastGutter = getTile(tileset, 5, 3);
			roofRedVerticalNorthWestGutter = getTile(tileset, 0, 3);
			roofRedVerticalSouthEastGutter = getTile(tileset, 5, 5);
			roofRedVerticalSouthWestGutter = getTile(tileset, 0, 5);
			roofRedVerticalWest = getTile(tileset, 1, 4);
			roofRedVerticalWestChimney = getTile(tileset, 1, 5);
			roofRedVerticalWestGutter = getTile(tileset, 0, 4);
			roofRedVerticalWestRidge = getTile(tileset, 2, 4);
			roofRedVerticalWestWindow = getTile(tileset, 1, 3);
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

		public static BufferedImage getBridgeHorizontalNorth() {
			return bridgeHorizontalNorth;
		}

		public static BufferedImage getBridgeHorizontalNorthEast() {
			return bridgeHorizontalNorthEast;
		}

		public static BufferedImage getBridgeHorizontalNorthWest() {
			return bridgeHorizontalNorthWest;
		}

		public static BufferedImage getBridgeHorizontalSouth() {
			return bridgeHorizontalSouth;
		}

		public static BufferedImage getBridgeHorizontalSouthEast() {
			return bridgeHorizontalSouthEast;
		}

		public static BufferedImage getBridgeHorizontalSouthWest() {
			return bridgeHorizontalSouthWest;
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

		public static BufferedImage getRoofBlueHorizontalNorth() {
			return roofBlueHorizontalNorth;
		}

		public static BufferedImage getRoofBlueHorizontalNorthChimney() {
			return roofBlueHorizontalNorthChimney;
		}

		public static BufferedImage getRoofBlueHorizontalNorthEastGutter() {
			return roofBlueHorizontalNorthEastGutter;
		}

		public static BufferedImage getRoofBlueHorizontalNorthEastRidge() {
			return roofBlueHorizontalNorthEastRidge;
		}

		public static BufferedImage getRoofBlueHorizontalNorthGutter() {
			return roofBlueHorizontalNorthGutter;
		}

		public static BufferedImage getRoofBlueHorizontalNorthRidge() {
			return roofBlueHorizontalNorthRidge;
		}

		public static BufferedImage getRoofBlueHorizontalNorthWestGutter() {
			return roofBlueHorizontalNorthWestGutter;
		}

		public static BufferedImage getRoofBlueHorizontalNorthWestRidge() {
			return roofBlueHorizontalNorthWestRidge;
		}

		public static BufferedImage getRoofBlueHorizontalNorthWindow() {
			return roofBlueHorizontalNorthWindow;
		}

		public static BufferedImage getRoofBlueHorizontalSouth() {
			return roofBlueHorizontalSouth;
		}

		public static BufferedImage getRoofBlueHorizontalSouthChimney() {
			return roofBlueHorizontalSouthChimney;
		}

		public static BufferedImage getRoofBlueHorizontalSouthEastGutter() {
			return roofBlueHorizontalSouthEastGutter;
		}

		public static BufferedImage getRoofBlueHorizontalSouthEastRidge() {
			return roofBlueHorizontalSouthEastRidge;
		}

		public static BufferedImage getRoofBlueHorizontalSouthGutter() {
			return roofBlueHorizontalSouthGutter;
		}

		public static BufferedImage getRoofBlueHorizontalSouthRidge() {
			return roofBlueHorizontalSouthRidge;
		}

		public static BufferedImage getRoofBlueHorizontalSouthWestGutter() {
			return roofBlueHorizontalSouthWestGutter;
		}

		public static BufferedImage getRoofBlueHorizontalSouthWestRidge() {
			return roofBlueHorizontalSouthWestRidge;
		}

		public static BufferedImage getRoofBlueHorizontalSouthWindow() {
			return roofBlueHorizontalSouthWindow;
		}

		public static BufferedImage getRoofBlueVerticalEast() {
			return roofBlueVerticalEast;
		}

		public static BufferedImage getRoofBlueVerticalEastChimney() {
			return roofBlueVerticalEastChimney;
		}

		public static BufferedImage getRoofBlueVerticalEastGutter() {
			return roofBlueVerticalEastGutter;
		}

		public static BufferedImage getRoofBlueVerticalEastRidge() {
			return roofBlueVerticalEastRidge;
		}

		public static BufferedImage getRoofBlueVerticalEastWindow() {
			return roofBlueVerticalEastWindow;
		}

		public static BufferedImage getRoofBlueVerticalNorthEastGutter() {
			return roofBlueVerticalNorthEastGutter;
		}

		public static BufferedImage getRoofBlueVerticalNorthWestGutter() {
			return roofBlueVerticalNorthWestGutter;
		}

		public static BufferedImage getRoofBlueVerticalSouthEastGutter() {
			return roofBlueVerticalSouthEastGutter;
		}

		public static BufferedImage getRoofBlueVerticalSouthWestGutter() {
			return roofBlueVerticalSouthWestGutter;
		}

		public static BufferedImage getRoofBlueVerticalWest() {
			return roofBlueVerticalWest;
		}

		public static BufferedImage getRoofBlueVerticalWestChimney() {
			return roofBlueVerticalWestChimney;
		}

		public static BufferedImage getRoofBlueVerticalWestGutter() {
			return roofBlueVerticalWestGutter;
		}

		public static BufferedImage getRoofBlueVerticalWestRidge() {
			return roofBlueVerticalWestRidge;
		}

		public static BufferedImage getRoofBlueVerticalWestWindow() {
			return roofBlueVerticalWestWindow;
		}

		public static BufferedImage getRoofRedHorizontalNorth() {
			return roofRedHorizontalNorth;
		}

		public static BufferedImage getRoofRedHorizontalNorthChimney() {
			return roofRedHorizontalNorthChimney;
		}

		public static BufferedImage getRoofRedHorizontalNorthEastGutter() {
			return roofRedHorizontalNorthEastGutter;
		}

		public static BufferedImage getRoofRedHorizontalNorthEastRidge() {
			return roofRedHorizontalNorthEastRidge;
		}

		public static BufferedImage getRoofRedHorizontalNorthGutter() {
			return roofRedHorizontalNorthGutter;
		}

		public static BufferedImage getRoofRedHorizontalNorthRidge() {
			return roofRedHorizontalNorthRidge;
		}

		public static BufferedImage getRoofRedHorizontalNorthWestGutter() {
			return roofRedHorizontalNorthWestGutter;
		}

		public static BufferedImage getRoofRedHorizontalNorthWestRidge() {
			return roofRedHorizontalNorthWestRidge;
		}

		public static BufferedImage getRoofRedHorizontalNorthWindow() {
			return roofRedHorizontalNorthWindow;
		}

		public static BufferedImage getRoofRedHorizontalSouth() {
			return roofRedHorizontalSouth;
		}

		public static BufferedImage getRoofRedHorizontalSouthChimney() {
			return roofRedHorizontalSouthChimney;
		}

		public static BufferedImage getRoofRedHorizontalSouthEastGutter() {
			return roofRedHorizontalSouthEastGutter;
		}

		public static BufferedImage getRoofRedHorizontalSouthEastRidge() {
			return roofRedHorizontalSouthEastRidge;
		}

		public static BufferedImage getRoofRedHorizontalSouthGutter() {
			return roofRedHorizontalSouthGutter;
		}

		public static BufferedImage getRoofRedHorizontalSouthRidge() {
			return roofRedHorizontalSouthRidge;
		}

		public static BufferedImage getRoofRedHorizontalSouthWestGutter() {
			return roofRedHorizontalSouthWestGutter;
		}

		public static BufferedImage getRoofRedHorizontalSouthWestRidge() {
			return roofRedHorizontalSouthWestRidge;
		}

		public static BufferedImage getRoofRedHorizontalSouthWindow() {
			return roofRedHorizontalSouthWindow;
		}

		public static BufferedImage getRoofRedVerticalEast() {
			return roofRedVerticalEast;
		}

		public static BufferedImage getRoofRedVerticalEastChimney() {
			return roofRedVerticalEastChimney;
		}

		public static BufferedImage getRoofRedVerticalEastGutter() {
			return roofRedVerticalEastGutter;
		}

		public static BufferedImage getRoofRedVerticalEastRidge() {
			return roofRedVerticalEastRidge;
		}

		public static BufferedImage getRoofRedVerticalEastWindow() {
			return roofRedVerticalEastWindow;
		}

		public static BufferedImage getRoofRedVerticalNorthEastGutter() {
			return roofRedVerticalNorthEastGutter;
		}

		public static BufferedImage getRoofRedVerticalNorthWestGutter() {
			return roofRedVerticalNorthWestGutter;
		}

		public static BufferedImage getRoofRedVerticalSouthEastGutter() {
			return roofRedVerticalSouthEastGutter;
		}

		public static BufferedImage getRoofRedVerticalSouthWestGutter() {
			return roofRedVerticalSouthWestGutter;
		}

		public static BufferedImage getRoofRedVerticalWest() {
			return roofRedVerticalWest;
		}

		public static BufferedImage getRoofRedVerticalWestChimney() {
			return roofRedVerticalWestChimney;
		}

		public static BufferedImage getRoofRedVerticalWestGutter() {
			return roofRedVerticalWestGutter;
		}

		public static BufferedImage getRoofRedVerticalWestRidge() {
			return roofRedVerticalWestRidge;
		}

		public static BufferedImage getRoofRedVerticalWestWindow() {
			return roofRedVerticalWestWindow;
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
