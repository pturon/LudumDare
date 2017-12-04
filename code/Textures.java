package code;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Textures {
	private Textures() {
		//no instance allowed
	}

	private static BufferedImage cardboardBox;
	private static BufferedImage emptyBottle;
	private static BufferedImage filledBottle;

	static {
		cardboardBox = getTexture("img/overworld/box.png");
		emptyBottle = getTexture("img/overworld/milkbottle.png");
		filledBottle = getTexture("img/overworld/milkbottle_full.png");
	}

	public static BufferedImage getCardboardBox() {
		return cardboardBox;
	}

	public static BufferedImage getEmptyBottle() {
		return emptyBottle;
	}

	public static BufferedImage getFilledBottle() {
		return filledBottle;
	}

	private static BufferedImage getTexture(String path) {
		try {
			return ImageIO.read(ClassLoader.getSystemClassLoader().getResource(path));
		} catch (Exception exception) {
			return null;
		}
	}

	public static class HUD {
		private HUD() {
			//no instance allowed
		}

		private static BufferedImage instructions;
		private static BufferedImage restart;

		static {
			instructions = getTexture("img/hud/instructions.png");
			restart = getTexture("img/hud/restart.png");
		}

		public static BufferedImage getInstructions() {
			return instructions;
		}

		public static BufferedImage getRestart() {
			return restart;
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
		private static BufferedImage conveyorBelt;
		private static BufferedImage fenceEast;
		private static BufferedImage fenceEastMF;
		private static BufferedImage fenceNorth;
		private static BufferedImage fenceNorthEast;
		private static BufferedImage fenceNorthWest;
		private static BufferedImage fenceSouth;
		private static BufferedImage fenceSouthEast;
		private static BufferedImage fenceSouthEastMF;
		private static BufferedImage fenceSouthMF;
		private static BufferedImage fenceSouthWest;
		private static BufferedImage fenceSouthWestMF;
		private static BufferedImage fenceWest;
		private static BufferedImage fenceWestMF;
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
		private static BufferedImage pipe1;
		private static BufferedImage pipe2;
		private static BufferedImage pipe3;
		private static BufferedImage pipeCorner;
		private static BufferedImage ramp1;
		private static BufferedImage ramp2;
		private static BufferedImage ramp3;
		private static BufferedImage ramp4;
		private static BufferedImage ramp5;
		private static BufferedImage ramp6;
		private static BufferedImage sign1;
		private static BufferedImage sign2;
		private static BufferedImage sign3;
		private static BufferedImage sign4;
		private static BufferedImage sign5;
		private static BufferedImage sign6;
		private static BufferedImage tank1;
		private static BufferedImage tank2;
		private static BufferedImage tank3;
		private static BufferedImage tank4;
		private static BufferedImage tank5;
		private static BufferedImage tank6;
		private static BufferedImage tank7;
		private static BufferedImage tank8;
		private static BufferedImage tank9;
		private static BufferedImage tiles;
		private static BufferedImage trackMarkH;
		private static BufferedImage trackMarkV;
		private static BufferedImage water;
		private static BufferedImage yellowFlower;


		static {
			BufferedImage overworldTileset = getTexture("img/overworld/overworld_tileset.png");

			asphalt = getTile(overworldTileset, 3, 2);
			bridgeHorizontalNorth = getTile(overworldTileset, 6, 9);
			bridgeHorizontalNorthEast = getTile(overworldTileset, 7, 9);
			bridgeHorizontalNorthWest = getTile(overworldTileset, 5, 9);
			bridgeHorizontalSouth = getTile(overworldTileset, 6, 10);
			bridgeHorizontalSouthEast = getTile(overworldTileset, 7, 10);
			bridgeHorizontalSouthWest = getTile(overworldTileset, 5, 10);
			fenceEast = getTile(overworldTileset, 2, 10);
			fenceNorth = getTile(overworldTileset, 1, 9);
			fenceNorthEast = getTile(overworldTileset, 2, 9);
			fenceNorthWest = getTile(overworldTileset, 0, 9);
			fenceSouth = getTile(overworldTileset, 1,11);
			fenceSouthEast = getTile(overworldTileset, 2, 11);
			fenceSouthWest = getTile(overworldTileset, 0, 11);
			fenceWest = getTile(overworldTileset, 0, 10);
			grass = getTile(overworldTileset, 1, 1);
			lamp = getTile(overworldTileset, 1, 10);
			magentaFlower = getTile(overworldTileset, 5, 2);
			pavement = getTile(overworldTileset, 5, 0);
			pavementCornerNorthEast = getTile(overworldTileset, 0, 2);
			pavementCornerNorthWest = getTile(overworldTileset, 2, 2);
			pavementCornerSouthEast = getTile(overworldTileset, 0, 0);
			pavementCornerSouthWest = getTile(overworldTileset, 2, 0);
			pavementEast = getTile(overworldTileset, 0, 1);
			pavementNorth = getTile(overworldTileset, 1, 2);
			pavementNorthEast = getTile(overworldTileset, 4, 0);
			pavementNorthWest = getTile(overworldTileset, 3, 0);
			pavementSouth = getTile(overworldTileset, 1, 0);
			pavementSouthEast = getTile(overworldTileset, 4, 1);
			pavementSouthWest = getTile(overworldTileset, 3, 1);
			pavementWest = getTile(overworldTileset, 2, 1);
			purpleFlower = getTile(overworldTileset, 5, 1);
			roofBlueHorizontalNorth = getTile(overworldTileset, 4, 13);
			roofBlueHorizontalNorthChimney = getTile(overworldTileset, 3, 13);
			roofBlueHorizontalNorthEastGutter = getTile(overworldTileset, 5, 12);
			roofBlueHorizontalNorthEastRidge = getTile(overworldTileset, 5, 14);
			roofBlueHorizontalNorthGutter = getTile(overworldTileset, 4, 12);
			roofBlueHorizontalNorthRidge = getTile(overworldTileset, 4, 14);
			roofBlueHorizontalNorthWestGutter = getTile(overworldTileset, 3, 12);
			roofBlueHorizontalNorthWestRidge = getTile(overworldTileset, 3, 14);
			roofBlueHorizontalNorthWindow = getTile(overworldTileset, 5, 13);
			roofBlueHorizontalSouth = getTile(overworldTileset, 4, 16);
			roofBlueHorizontalSouthChimney = getTile(overworldTileset, 3, 16);
			roofBlueHorizontalSouthEastGutter = getTile(overworldTileset, 5, 17);
			roofBlueHorizontalSouthEastRidge = getTile(overworldTileset, 5, 15);
			roofBlueHorizontalSouthGutter = getTile(overworldTileset, 4, 17);
			roofBlueHorizontalSouthRidge = getTile(overworldTileset, 4, 15);
			roofBlueHorizontalSouthWestGutter = getTile(overworldTileset, 3, 17);
			roofBlueHorizontalSouthWestRidge = getTile(overworldTileset, 4, 15);
			roofBlueHorizontalSouthWindow = getTile(overworldTileset, 5, 16);
			roofBlueVerticalEast = getTile(overworldTileset, 4, 7);
			roofBlueVerticalEastChimney = getTile(overworldTileset, 4, 8);
			roofBlueVerticalEastGutter = getTile(overworldTileset, 5, 7);
			roofBlueVerticalEastRidge = getTile(overworldTileset, 3, 7);
			roofBlueVerticalEastWindow = getTile(overworldTileset, 4, 6);
			roofBlueVerticalNorthEastGutter = getTile(overworldTileset, 5, 6);
			roofBlueVerticalNorthWestGutter = getTile(overworldTileset, 0, 6);
			roofBlueVerticalSouthEastGutter = getTile(overworldTileset, 5, 8);
			roofBlueVerticalSouthWestGutter = getTile(overworldTileset, 0, 8);
			roofBlueVerticalWest = getTile(overworldTileset, 1, 7);
			roofBlueVerticalWestChimney = getTile(overworldTileset, 1, 8);
			roofBlueVerticalWestGutter = getTile(overworldTileset, 0, 7);
			roofBlueVerticalWestRidge = getTile(overworldTileset, 2, 7);
			roofBlueVerticalWestWindow = getTile(overworldTileset, 1, 6);
			roofRedHorizontalNorth = getTile(overworldTileset, 1, 13);
			roofRedHorizontalNorthChimney = getTile(overworldTileset, 0, 13);
			roofRedHorizontalNorthEastGutter = getTile(overworldTileset, 2, 12);
			roofRedHorizontalNorthEastRidge = getTile(overworldTileset, 2, 14);
			roofRedHorizontalNorthGutter = getTile(overworldTileset, 1, 12);
			roofRedHorizontalNorthRidge = getTile(overworldTileset, 1, 14);
			roofRedHorizontalNorthWestGutter = getTile(overworldTileset, 0, 12);
			roofRedHorizontalNorthWestRidge = getTile(overworldTileset, 0, 14);
			roofRedHorizontalNorthWindow = getTile(overworldTileset, 2, 13);
			roofRedHorizontalSouth = getTile(overworldTileset, 1, 16);
			roofRedHorizontalSouthChimney = getTile(overworldTileset, 0, 16);
			roofRedHorizontalSouthEastGutter = getTile(overworldTileset, 2, 17);
			roofRedHorizontalSouthEastRidge = getTile(overworldTileset, 2, 15);
			roofRedHorizontalSouthGutter = getTile(overworldTileset, 1, 17);
			roofRedHorizontalSouthRidge = getTile(overworldTileset, 1, 15);
			roofRedHorizontalSouthWestGutter = getTile(overworldTileset, 0, 17);
			roofRedHorizontalSouthWestRidge = getTile(overworldTileset, 0, 15);
			roofRedHorizontalSouthWindow = getTile(overworldTileset, 2, 16);
			roofRedVerticalEast = getTile(overworldTileset, 4, 4);
			roofRedVerticalEastChimney = getTile(overworldTileset, 4, 5);
			roofRedVerticalEastGutter = getTile(overworldTileset, 5, 4);
			roofRedVerticalEastRidge = getTile(overworldTileset, 3, 4);
			roofRedVerticalEastWindow = getTile(overworldTileset, 4, 3);
			roofRedVerticalNorthEastGutter = getTile(overworldTileset, 5, 3);
			roofRedVerticalNorthWestGutter = getTile(overworldTileset, 0, 3);
			roofRedVerticalSouthEastGutter = getTile(overworldTileset, 5, 5);
			roofRedVerticalSouthWestGutter = getTile(overworldTileset, 0, 5);
			roofRedVerticalWest = getTile(overworldTileset, 1, 4);
			roofRedVerticalWestChimney = getTile(overworldTileset, 1, 5);
			roofRedVerticalWestGutter = getTile(overworldTileset, 0, 4);
			roofRedVerticalWestRidge = getTile(overworldTileset, 2, 4);
			roofRedVerticalWestWindow = getTile(overworldTileset, 1, 3);
			tiles = getTile(overworldTileset, 6, 11);
			yellowFlower = getTile(overworldTileset, 4, 2);
			water = getTile(overworldTileset, 5, 11);

			BufferedImage milkFactoryTileset = getTexture("img/milkfactory/milk_factory_tileset.png");

			conveyorBelt = getTile(milkFactoryTileset, 3, 3);
			fenceEastMF = getTile(milkFactoryTileset, 5, 3);
			fenceSouthMF = getTile(milkFactoryTileset, 4, 4);
			fenceSouthEastMF = getTile(milkFactoryTileset, 5, 4);
			fenceSouthWestMF = getTile(milkFactoryTileset, 3, 4);
			fenceWestMF = getTile(milkFactoryTileset, 4, 3);
			pipe1 = getTile(milkFactoryTileset, 2, 7);
			pipe2 = getTile(milkFactoryTileset, 1, 8);
			pipe3 = getTile(milkFactoryTileset, 2, 8);
			pipeCorner = getTile(milkFactoryTileset, 1, 7);
			ramp1 = getTile(milkFactoryTileset, 3, 5);
			ramp2 = getTile(milkFactoryTileset, 4, 5);
			ramp3 = getTile(milkFactoryTileset, 5, 5);
			ramp4 = getTile(milkFactoryTileset, 3, 6);
			ramp5 = getTile(milkFactoryTileset, 4, 6);
			ramp6 = getTile(milkFactoryTileset, 5, 6);
			sign1 = getTile(milkFactoryTileset, 3, 7);
			sign2 = getTile(milkFactoryTileset, 4, 7);
			sign3 = getTile(milkFactoryTileset, 5, 7);
			sign4 = getTile(milkFactoryTileset, 3, 8);
			sign5 = getTile(milkFactoryTileset, 4, 8);
			sign6 = getTile(milkFactoryTileset, 5, 8);
			tank1 = getTile(milkFactoryTileset, 0, 4);
			tank2 = getTile(milkFactoryTileset, 1, 4);
			tank3 = getTile(milkFactoryTileset, 2, 4);
			tank4 = getTile(milkFactoryTileset, 0, 5);
			tank5 = getTile(milkFactoryTileset, 1, 5);
			tank6 = getTile(milkFactoryTileset, 2, 5);
			tank7 = getTile(milkFactoryTileset, 0, 6);
			tank8 = getTile(milkFactoryTileset, 1, 6);
			tank9 = getTile(milkFactoryTileset, 2, 6);
			trackMarkV = getTile(milkFactoryTileset, 1, 3);
			trackMarkH = getTile(milkFactoryTileset, 2, 3);
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

		public static BufferedImage getConveyorBelt() {
			return conveyorBelt;
		}

		public static BufferedImage getFenceEast() {
			return fenceEast;
		}

		public static BufferedImage getFenceEastMF() {
			return fenceEastMF;
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

		public static BufferedImage getFenceSouthMF() {
			return fenceSouthMF;
		}

		public static BufferedImage getFenceSouthEast() {
			return fenceSouthEast;
		}

		public static BufferedImage getFenceSouthEastMF() {
			return fenceSouthEastMF;
		}

		public static BufferedImage getFenceSouthWest() {
			return fenceSouthWest;
		}

		public static BufferedImage getFenceSouthWestMF() {
			return fenceSouthWestMF;
		}

		public static BufferedImage getFenceWest() {
			return fenceWest;
		}

		public static BufferedImage getFenceWestMF() {
			return fenceWestMF;
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

		public static BufferedImage getPipe1() {
			return pipe1;
		}

		public static BufferedImage getPipe2() {
			return pipe2;
		}

		public static BufferedImage getPipe3() {
			return pipe3;
		}

		public static BufferedImage getPipeCorner() {
			return pipeCorner;
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

		public static BufferedImage getRamp1() {
			return ramp1;
		}

		public static BufferedImage getRamp2() {
			return ramp2;
		}

		public static BufferedImage getRamp3() {
			return ramp3;
		}

		public static BufferedImage getRamp4() {
			return ramp4;
		}

		public static BufferedImage getRamp5() {
			return ramp5;
		}

		public static BufferedImage getRamp6() {
			return ramp6;
		}

		public static BufferedImage getSign1() {
			return sign1;
		}

		public static BufferedImage getSign2() {
			return sign2;
		}

		public static BufferedImage getSign3() {
			return sign3;
		}

		public static BufferedImage getSign4() {
			return sign4;
		}

		public static BufferedImage getSign5() {
			return sign5;
		}

		public static BufferedImage getSign6() {
			return sign6;
		}

		public static BufferedImage getTank1() {
			return tank1;
		}

		public static BufferedImage getTank2() {
			return tank2;
		}

		public static BufferedImage getTank3() {
			return tank3;
		}

		public static BufferedImage getTank4() {
			return tank4;
		}

		public static BufferedImage getTank5() {
			return tank5;
		}

		public static BufferedImage getTank6() {
			return tank6;
		}

		public static BufferedImage getTank7() {
			return tank7;
		}

		public static BufferedImage getTank8() {
			return tank8;
		}

		public static BufferedImage getTank9() {
			return tank9;
		}

		public static BufferedImage getTiles() {
			return tiles;
		}

		public static BufferedImage getTrackMarkH() {
			return trackMarkH;
		}

		public static BufferedImage getTrackMarkV() {
			return trackMarkV;
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

		public static class Cow {
			private static BufferedImage[] walking = new BufferedImage[4];

			private Cow() {
				//no instance allowed
			}

			static {
				BufferedImage cowSpritesheet = getTexture("img/cows/standard_spritesheet.png");
				walking[0] = cowSpritesheet.getSubimage(16, 0, 32, 64);//UP
				walking[1] = cowSpritesheet.getSubimage(16, 64, 32, 64);//DOWN
				walking[2] = cowSpritesheet.getSubimage(0, 2 * 64 + 16, 64, 32);//RIGHT
				walking[3] = cowSpritesheet.getSubimage(0, 3 * 64 + 16, 64, 32);//LEFT
			}

			public static BufferedImage getWalking(int direction) {
				return walking[direction % 4];
			}
		}

		public static class IntelligentCow {
			private static BufferedImage[][] walking = new BufferedImage[4][4];

			private IntelligentCow() {
				//no instance allowed
			}

			static {
				BufferedImage cowSpritesheet = getTexture("img/cows/clever_spritesheet.png");
				for(int direction = 0; direction < 4; direction++) {
					for(int frame = 0; frame < 4; frame++) {
						walking[direction][frame] = cowSpritesheet.getSubimage(32 * frame, 32 * direction, 32, 32);
					}
				}
			}

			public static BufferedImage getWalking(int direction, int frame) {
				return walking[direction % 4][frame % 4];
			}
		}

		public static class Milkman {
			private static BufferedImage[][][] pickupAnimation = new BufferedImage[4][4][8];
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

				for(int direction = 0; direction < 4; direction++) {
					for(int frame = 0; frame < 4; frame++) {
						for(int bottles = 0; bottles < 8; bottles++) {
							pickupAnimation[direction][frame][bottles] = milkmanSpritesheet.getSubimage(bottles * 128 + frame * 32, 128 + direction * 32, 32, 32);
						}
					}
				}
			}

			public static BufferedImage getPickupAnimation(int direction, int frame, int bottles) {
				return pickupAnimation[direction % 4][frame % 4][bottles % 8];
			}

			public static BufferedImage getWalkCycle(int direction, int frame, int bottles) {
				return walking[direction % 4][frame % 4][bottles % 9];
			}
		}
	}
	
	public static class Menu {
		private static BufferedImage background = getTexture("img/menu/background.png");
		private static BufferedImage title = getTexture("img/menu/title.png");
		private static BufferedImage title1 = getTexture("img/menu/title1.png");
		private static BufferedImage title2 = getTexture("img/menu/title2.png");
		private static BufferedImage title3 = getTexture("img/menu/title3.png");
		private static BufferedImage button = getTexture("img/menu/button.png");
		private static BufferedImage frame = getTexture("img/menu/frame.png");
		private static BufferedImage milkman = getTexture("img/menu/milkman.png");
		private static BufferedImage play = getTexture("img/menu/play.png");
		private static BufferedImage difficultyEasy = getTexture("img/menu/difficulty_0.png");
		private static BufferedImage difficultyNormal = getTexture("img/menu/difficulty_1.png");
		private static BufferedImage difficultyHard = getTexture("img/menu/difficulty_2.png");
		private static BufferedImage exit = getTexture("img/menu/exit.png");
		
		public static BufferedImage getBackground(){
			return background;
		}
		
		public static BufferedImage getTitle(int cloudAnimation){
			switch (cloudAnimation){
			case 0:
				return title;
			case 1:
				return title1;
			case 2:
				return title2;
			case 3:
				return title3;
			default:
				return title;
			}
		}
		
		public static BufferedImage getButton(){
			return button;
		}
		
		public static BufferedImage getFrame(){
			return frame;
		}
		
		public static BufferedImage getPlayFont(){
			return play;
		}
		
		public static BufferedImage getDifficultyFont(int difficulty){
			switch (difficulty){
			case 0:
				return difficultyEasy;
			case 10:
				return difficultyNormal;
			case 2:
				return difficultyHard;
			default:
				return difficultyNormal;
			}
		}
		
		public static BufferedImage getExitFont(){
			return exit;
		}
		
		public static BufferedImage getMilkman(){
			return milkman;
		}
		
	}

	public static class CutSceneTextures{

		private static BufferedImage factoryOverview = getTexture("img/cutscenes/factory_overview.png");
		private static BufferedImage destroyedLab = getTexture("img/cutscenes/factory_destroyed_lab.png");
		private static BufferedImage explosion_sheet = getTexture("img/cutscenes/explosion.png");
		private static BufferedImage chemicals = getTexture("img/cutscenes/chemical_flood.png");

		private static BufferedImage explosion_0 = explosion_sheet.getSubimage(800*0,0,800,600);
		private static BufferedImage explosion_1 = explosion_sheet.getSubimage(800*1,0,800,600);
		private static BufferedImage explosion_2 = explosion_sheet.getSubimage(800*2,0,800,600);
		private static BufferedImage explosion_3 = explosion_sheet.getSubimage(800*3,0,800,600);

		private static BufferedImage chemical_0 = chemicals.getSubimage(800*0,0,800,600);
		private static BufferedImage chemical_1 = chemicals.getSubimage(800*1,0,800,600);
		private static BufferedImage chemical_2 = chemicals.getSubimage(800*2,0,800,600);
		private static BufferedImage chemical_3 = chemicals.getSubimage(800*3,0,800,600);
		private static BufferedImage chemical_4 = chemicals.getSubimage(800*4,0,800,600);
		private static BufferedImage chemical_5 = chemicals.getSubimage(800*5,0,800,600);
		private static BufferedImage chemical_6 = chemicals.getSubimage(800*6,0,800,600);
		private static BufferedImage chemical_7 = chemicals.getSubimage(800*7,0,800,600);

		public static BufferedImage getExplosion_0() {
			return explosion_0;
		}

		public static BufferedImage getExplosion_1() {
			return explosion_1;
		}

		public static BufferedImage getExplosion_2() {
			return explosion_2;
		}

		public static BufferedImage getExplosion_3() {
			return explosion_3;
		}

		public static BufferedImage getChemical_0() {
			return chemical_0;
		}

		public static BufferedImage getChemical_1() {
			return chemical_1;
		}

		public static BufferedImage getChemical_2() {
			return chemical_2;
		}

		public static BufferedImage getChemical_3() {
			return chemical_3;
		}

		public static BufferedImage getChemical_4() {
			return chemical_4;
		}

		public static BufferedImage getChemical_5() {
			return chemical_5;
		}

		public static BufferedImage getChemical_6() {
			return chemical_6;
		}

		public static BufferedImage getChemical_7() {
			return chemical_7;
		}

		public static BufferedImage getChemical_8() {
			return chemical_8;
		}

		private static BufferedImage chemical_8 = chemicals.getSubimage(800*8,0,800,600);


		public static BufferedImage getFactoryOverview() {
			return factoryOverview;
		}

		public static BufferedImage getDestroyedLab() {
			return destroyedLab;
		}
	}

	public static class ui{
		public static BufferedImage uiBackground = getTexture("img/hud/interface_background.png");
		public static BufferedImage emptyBottle = getTexture("img/hud/empty_bottle.png");
		public static BufferedImage full_bottle = getTexture("img/hud/full_bottle.png");
		public static BufferedImage heart = getTexture("img/hud/heart.png");

		public static BufferedImage numbers = getTexture("img/hud/numbers.png");

		public static BufferedImage number_0 = numbers.getSubimage(0,0,10,15);
		public static BufferedImage number_1 = numbers.getSubimage(10,0,10,15);
		public static BufferedImage number_2 = numbers.getSubimage(20,0,10,15);
		public static BufferedImage number_3 = numbers.getSubimage(30,0,10,15);
		public static BufferedImage number_4 = numbers.getSubimage(40,0,10,15);
		public static BufferedImage number_5 = numbers.getSubimage(50,0,10,15);
		public static BufferedImage number_6 = numbers.getSubimage(60,0,10,15);
		public static BufferedImage number_7 = numbers.getSubimage(70,0,10,15);
		public static BufferedImage number_8 = numbers.getSubimage(80,0,10,15);

		public static BufferedImage getUiBackground() {
			return uiBackground;
		}

		public static BufferedImage getEmptyBottle() {
			return emptyBottle;
		}

		public static BufferedImage getFull_bottle() {
			return full_bottle;
		}

		public static BufferedImage getHeart() {
			return heart;
		}

		public static BufferedImage getNumber_0() {
			return number_0;
		}

		public static BufferedImage getNumber_1() {
			return number_1;
		}

		public static BufferedImage getNumber_2() {
			return number_2;
		}

		public static BufferedImage getNumber_3() {
			return number_3;
		}

		public static BufferedImage getNumber_4() {
			return number_4;
		}

		public static BufferedImage getNumber_5() {
			return number_5;
		}

		public static BufferedImage getNumber_6() {
			return number_6;
		}

		public static BufferedImage getNumber_7() {
			return number_7;
		}

		public static BufferedImage getNumber_8() {
			return number_8;
		}

		public static BufferedImage getNumber_9() {
			return number_9;
		}

		public static BufferedImage number_9 = numbers.getSubimage(90,0,10,15);
	}
	
}
