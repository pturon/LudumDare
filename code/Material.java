package code;

import java.awt.image.BufferedImage;

public enum Material {
	NONE(-1, false),
	PAVEMENT_CORNER_SOUTH_EAST(0, false),
	PAVEMENT_SOUTH(1, false),
	PAVEMENT_CORNER_SOUTH_WEST(2, false),
	PAVEMENT_NORTH_WEST(3, false),
	PAVEMENT_NORTH_EAST(4, false),
	PAVEMENT(5, false),
	PAVEMENT_EAST(8, false),
	GRASS(9, false),
	PAVEMENT_WEST(10, false),
	PAVEMENT_SOUTH_WEST(11, false),
	PAVEMENT_SOUTH_EAST(12, false),
	PURPLE_FLOWER(13, false),
	PAVEMENT_CORNER_NORTH_EAST(16, false),
	PAVEMENT_NORTH(17, false),
	PAVEMENT_CORNER_NORTH_WEST(18, false),
	ASPHALT(19, false),
	YELLOW_FLOWER(20, false),
	MAGENTA_FLOWER(21, false),
	ROOF_RED_VERTICAL_NORTH_WEST_GUTTER(24, true),
	ROOF_RED_VERTICAL_WEST_WINDOW(25, true),
	ROOF_RED_VERTICAL_EAST_WINDOW(28, true),
	ROOF_RED_VERTICAL_NORTH_EAST_GUTTER(29, true),
	ROOF_RED_VERTICAL_WEST_GUTTER(32, true),
	ROOF_RED_VERTICAL_WEST(33, true),
	ROOF_RED_VERTICAL_WEST_RIDGE(34, true),
	ROOF_RED_VERTICAL_EAST_RIDGE(35, true),
	ROOF_RED_VERTICAL_EAST(36, true),
	ROOF_RED_VERTICAL_EAST_GUTTER(37, true),
	ROOF_RED_VERTICAL_SOUTH_WEST_GUTTER(40, true),
	ROOF_RED_VERTICAL_WEST_CHIMNEY(41, true),
	ROOF_RED_VERTICAL_EAST_CHIMNEY(44, true),
	ROOF_RED_VERTICAL_SOUTH_EAST_GUTTER(45, true),
	ROOF_BLUE_VERTICAL_NORTH_WEST_GUTTER(48, true),
	ROOF_BLUE_VERTICAL_WEST_WINDOW(49, true),
	ROOF_BLUE_VERTICAL_EAST_WINDOW(52, true),
	ROOF_BLUE_VERTICAL_NORTH_EAST_GUTTER(53, true),
	ROOF_BLUE_VERTICAL_WEST_GUTTER(56, true),
	ROOF_BLUE_VERTICAL_WEST(57, true),
	ROOF_BLUE_VERTICAL_WEST_RIDGE(58, true),
	ROOF_BLUE_VERTICAL_EAST_RIDGE(59, true),
	ROOF_BLUE_VERTICAL_EAST(60, true),
	ROOF_BLUE_VERTICAL_EAST_GUTTER(61, true),
	ROOF_BLUE_VERTICAL_SOUTH_WEST_GUTTER(64, true),
	ROOF_BLUE_VERTICAL_WEST_CHIMNEY(65, true),
	ROOF_BLUE_VERTICAL_EAST_CHIMNEY(68, true),
	ROOF_BLUE_VERTICAL_SOUTH_EAST_GUTTER(69, true),
	FENCE_NORTH_WEST(72, true),
	FENCE_NORTH(73, true),
	FENCE_NORTH_EAST(74, true),
	BRIDGE_HORIZONTAL_NORTH_WEST(77, true),
	BRIDGE_HORIZONTAL_NORTH(78, true),
	BRIDGE_HORIZONTAL_NORTH_EAST(79, true),
	FENCE_WEST(80, true),
	LAMP(81, true),
	FENCE_EAST(82, true),
	BRIDGE_HORIZONTAL_SOUTH_WEST(85, true),
	BRIDGE_HORIZONTAL_SOUTH(86, true),
	BRIDGE_HORIZONTAL_SOUTH_EAST(87, true),
	FENCE_SOUTH_WEST(88, true),
	FENCE_SOUTH(89, true),
	FENCE_SOUTH_EAST(90, true),
	WATER(93, true),
	TILES(94, false),
	ROOF_RED_HORIZONTAL_NORTH_WEST_GUTTER(96, true),
	ROOF_RED_HORIZONTAL_NORTH_GUTTER(97, true),
	ROOF_RED_HORIZONTAL_NORTH_EAST_GUTTER(98, true),
	ROOF_BLUE_HORIZONTAL_NORTH_WEST_GUTTER(99, true),
	ROOF_BLUE_HORIZONTAL_NORTH_GUTTER(100, true),
	ROOF_BLUE_HORIZONTAL_NORTH_EAST_GUTTER(101, true),
	ROOF_RED_HORIZONTAL_NORTH_CHIMNEY(104, true),
	ROOF_RED_HORIZONTAL_NORTH(105, true),
	ROOF_RED_HORIZONTAL_NORTH_WINDOW(106, true),
	ROOF_BLUE_HORIZONTAL_NORTH_CHIMNEY(107, true),
	ROOF_BLUE_HORIZONTAL_NORTH(108, true),
	ROOF_BLUE_HORIZONTAL_NORTH_WINDOW(109, true),
	ROOF_RED_HORIZONTAL_NORTH_WEST_RIDGE(112, true),
	ROOF_RED_HORIZONTAL_NORTH_RIDGE(113, true),
	ROOF_RED_HORIZONTAL_NORTH_EAST_RIDGE(114, true),
	ROOF_BLUE_HORIZONTAL_NORTH_WEST_RIDGE(115, true),
	ROOF_BLUE_HORIZONTAL_NORTH_RIDGE(116, true),
	ROOF_BLUE_HORIZONTAL_NORTH_EAST_RIDGE(117, true),
	ROOF_RED_HORIZONTAL_SOUTH_WEST_RIDGE(120, true),
	ROOF_RED_HORIZONTAL_SOUTH_RIDGE(121, true),
	ROOF_RED_HORIZONTAL_SOUTH_EAST_RIDGE(122, true),
	ROOF_BLUE_HORIZONTAL_SOUTH_WEST_RIDGE(123, true),
	ROOF_BLUE_HORIZONTAL_SOUTH_RIDGE(124, true),
	ROOF_BLUE_HORIZONTAL_SOUTH_EAST_RIDGE(125, true),
	ROOF_RED_HORIZONTAL_SOUTH_CHIMNEY(128, true),
	ROOF_RED_HORIZONTAL_SOUTH(129, true),
	ROOF_RED_HORIZONTAL_SOUTH_WINDOW(130, true),
	ROOF_BLUE_HORIZONTAL_SOUTH_CHIMNEY(131, true),
	ROOF_BLUE_HORIZONTAL_SOUTH(132, true),
	ROOF_BLUE_HORIZONTAL_SOUTH_WINDOW(133, true),
	ROOF_RED_HORIZONTAL_SOUTH_WEST_GUTTER(136, true),
	ROOF_RED_HORIZONTAL_SOUTH_GUTTER(137, true),
	ROOF_RED_HORIZONTAL_SOUTH_EAST_GUTTER(138, true),
	ROOF_BLUE_HORIZONTAL_SOUTH_WEST_GUTTER(139, true),
	ROOF_BLUE_HORIZONTAL_SOUTH_GUTTER(140, true),
	ROOF_BLUE_HORIZONTAL_SOUTH_EAST_GUTTER(141, true);

	private int id;
	private boolean solid;

	Material(int id, boolean solid) {
		this.id = id;
		this.solid = solid;
	}

	public static Material byId(int id) {
		for(Material material : Material.values()) {
			if(material.id == id) {
				return material;
			}
		}
		return NONE;
	}

	public BufferedImage getImage() {
		switch(this) {
		case ASPHALT:
			return Textures.Terrain.getAsphalt();
		case BRIDGE_HORIZONTAL_NORTH:
			return Textures.Terrain.getBridgeHorizontalNorth();
		case BRIDGE_HORIZONTAL_NORTH_EAST:
			return Textures.Terrain.getBridgeHorizontalNorthEast();
		case BRIDGE_HORIZONTAL_NORTH_WEST:
			return Textures.Terrain.getBridgeHorizontalNorthWest();
		case BRIDGE_HORIZONTAL_SOUTH:
			return Textures.Terrain.getBridgeHorizontalSouth();
		case BRIDGE_HORIZONTAL_SOUTH_EAST:
			return Textures.Terrain.getBridgeHorizontalSouthEast();
		case BRIDGE_HORIZONTAL_SOUTH_WEST:
			return Textures.Terrain.getBridgeHorizontalSouthWest();
		case FENCE_EAST:
			return Textures.Terrain.getFenceEast();
		case FENCE_NORTH:
			return Textures.Terrain.getFenceNorth();
		case FENCE_NORTH_EAST:
			return Textures.Terrain.getFenceNorthEast();
		case FENCE_NORTH_WEST:
			return Textures.Terrain.getFenceNorthWest();
		case FENCE_SOUTH:
			return Textures.Terrain.getFenceSouth();
		case FENCE_SOUTH_EAST:
			return Textures.Terrain.getFenceSouthEast();
		case FENCE_SOUTH_WEST:
			return Textures.Terrain.getFenceSouthWest();
		case FENCE_WEST:
			return Textures.Terrain.getFenceWest();
		case GRASS:
			return Textures.Terrain.getGrass();
		case LAMP:
			return Textures.Terrain.getLamp();
		case MAGENTA_FLOWER:
			return Textures.Terrain.getMagentaFlower();
		case PAVEMENT:
			return Textures.Terrain.getPavement();
		case PAVEMENT_CORNER_NORTH_EAST:
			return Textures.Terrain.getPavementCornerNorthEast();
		case PAVEMENT_CORNER_NORTH_WEST:
			return Textures.Terrain.getPavementCornerNorthWest();
		case PAVEMENT_CORNER_SOUTH_EAST:
			return Textures.Terrain.getPavementCornerSouthEast();
		case PAVEMENT_CORNER_SOUTH_WEST:
			return Textures.Terrain.getPavementCornerSouthWest();
		case PAVEMENT_EAST:
			return Textures.Terrain.getPavementEast();
		case PAVEMENT_NORTH:
			return Textures.Terrain.getPavementNorth();
		case PAVEMENT_NORTH_EAST:
			return Textures.Terrain.getPavementNorthEast();
		case PAVEMENT_NORTH_WEST:
			return Textures.Terrain.getPavementNorthWest();
		case PAVEMENT_SOUTH:
			return Textures.Terrain.getPavementSouth();
		case PAVEMENT_SOUTH_EAST:
			return Textures.Terrain.getPavementSouthEast();
		case PAVEMENT_SOUTH_WEST:
			return Textures.Terrain.getPavementSouthWest();
		case PAVEMENT_WEST:
			return Textures.Terrain.getPavementWest();
		case PURPLE_FLOWER:
			return Textures.Terrain.getPurpleFlower();
		case ROOF_BLUE_HORIZONTAL_NORTH:
			return Textures.Terrain.getRoofBlueHorizontalNorth();
		case ROOF_BLUE_HORIZONTAL_NORTH_CHIMNEY:
			return Textures.Terrain.getRoofBlueHorizontalNorthChimney();
		case ROOF_BLUE_HORIZONTAL_NORTH_EAST_GUTTER:
			return Textures.Terrain.getRoofBlueHorizontalNorthEastGutter();
		case ROOF_BLUE_HORIZONTAL_NORTH_EAST_RIDGE:
			return Textures.Terrain.getRoofBlueHorizontalNorthEastRidge();
		case ROOF_BLUE_HORIZONTAL_NORTH_GUTTER:
			return Textures.Terrain.getRoofBlueHorizontalNorthGutter();
		case ROOF_BLUE_HORIZONTAL_NORTH_RIDGE:
			return Textures.Terrain.getRoofBlueHorizontalNorthRidge();
		case ROOF_BLUE_HORIZONTAL_NORTH_WEST_GUTTER:
			return Textures.Terrain.getRoofBlueHorizontalNorthWestGutter();
		case ROOF_BLUE_HORIZONTAL_NORTH_WEST_RIDGE:
			return Textures.Terrain.getRoofBlueHorizontalNorthWestRidge();
		case ROOF_BLUE_HORIZONTAL_NORTH_WINDOW:
			return Textures.Terrain.getRoofBlueHorizontalNorthWindow();
		case ROOF_BLUE_HORIZONTAL_SOUTH:
			return Textures.Terrain.getRoofBlueHorizontalSouth();
		case ROOF_BLUE_HORIZONTAL_SOUTH_CHIMNEY:
			return Textures.Terrain.getRoofBlueHorizontalSouthChimney();
		case ROOF_BLUE_HORIZONTAL_SOUTH_EAST_GUTTER:
			return Textures.Terrain.getRoofBlueHorizontalSouthEastGutter();
		case ROOF_BLUE_HORIZONTAL_SOUTH_EAST_RIDGE:
			return Textures.Terrain.getRoofBlueHorizontalSouthEastRidge();
		case ROOF_BLUE_HORIZONTAL_SOUTH_GUTTER:
			return Textures.Terrain.getRoofBlueHorizontalSouthGutter();
		case ROOF_BLUE_HORIZONTAL_SOUTH_RIDGE:
			return Textures.Terrain.getRoofBlueHorizontalSouthRidge();
		case ROOF_BLUE_HORIZONTAL_SOUTH_WEST_GUTTER:
			return Textures.Terrain.getRoofBlueHorizontalSouthWestGutter();
		case ROOF_BLUE_HORIZONTAL_SOUTH_WEST_RIDGE:
			return Textures.Terrain.getRoofBlueHorizontalSouthWestRidge();
		case ROOF_BLUE_HORIZONTAL_SOUTH_WINDOW:
			return Textures.Terrain.getRoofBlueHorizontalSouthWindow();
		case ROOF_BLUE_VERTICAL_EAST:
			return Textures.Terrain.getRoofBlueVerticalEast();
		case ROOF_BLUE_VERTICAL_EAST_CHIMNEY:
			return Textures.Terrain.getRoofBlueVerticalEastChimney();
		case ROOF_BLUE_VERTICAL_EAST_GUTTER:
			return Textures.Terrain.getRoofBlueVerticalEastGutter();
		case ROOF_BLUE_VERTICAL_EAST_RIDGE:
			return Textures.Terrain.getRoofBlueVerticalEastRidge();
		case ROOF_BLUE_VERTICAL_EAST_WINDOW:
			return Textures.Terrain.getRoofBlueVerticalEastWindow();
		case ROOF_BLUE_VERTICAL_NORTH_EAST_GUTTER:
			return Textures.Terrain.getRoofBlueVerticalNorthEastGutter();
		case ROOF_BLUE_VERTICAL_NORTH_WEST_GUTTER:
			return Textures.Terrain.getRoofBlueVerticalNorthWestGutter();
		case ROOF_BLUE_VERTICAL_SOUTH_EAST_GUTTER:
			return Textures.Terrain.getRoofBlueVerticalSouthEastGutter();
		case ROOF_BLUE_VERTICAL_SOUTH_WEST_GUTTER:
			return Textures.Terrain.getRoofBlueVerticalSouthWestGutter();
		case ROOF_BLUE_VERTICAL_WEST:
			return Textures.Terrain.getRoofBlueVerticalWest();
		case ROOF_BLUE_VERTICAL_WEST_CHIMNEY:
			return Textures.Terrain.getRoofBlueVerticalWestChimney();
		case ROOF_BLUE_VERTICAL_WEST_GUTTER:
			return Textures.Terrain.getRoofBlueVerticalWestGutter();
		case ROOF_BLUE_VERTICAL_WEST_RIDGE:
			return Textures.Terrain.getRoofBlueVerticalWestRidge();
		case ROOF_BLUE_VERTICAL_WEST_WINDOW:
			return Textures.Terrain.getRoofBlueVerticalWestWindow();
		case ROOF_RED_HORIZONTAL_NORTH:
			return Textures.Terrain.getRoofRedHorizontalNorth();
		case ROOF_RED_HORIZONTAL_NORTH_CHIMNEY:
			return Textures.Terrain.getRoofRedHorizontalNorthChimney();
		case ROOF_RED_HORIZONTAL_NORTH_EAST_GUTTER:
			return Textures.Terrain.getRoofRedHorizontalNorthEastGutter();
		case ROOF_RED_HORIZONTAL_NORTH_EAST_RIDGE:
			return Textures.Terrain.getRoofRedHorizontalNorthEastRidge();
		case ROOF_RED_HORIZONTAL_NORTH_GUTTER:
			return Textures.Terrain.getRoofRedHorizontalNorthGutter();
		case ROOF_RED_HORIZONTAL_NORTH_RIDGE:
			return Textures.Terrain.getRoofRedHorizontalNorthRidge();
		case ROOF_RED_HORIZONTAL_NORTH_WEST_GUTTER:
			return Textures.Terrain.getRoofRedHorizontalNorthWestGutter();
		case ROOF_RED_HORIZONTAL_NORTH_WEST_RIDGE:
			return Textures.Terrain.getRoofRedHorizontalNorthWestRidge();
		case ROOF_RED_HORIZONTAL_NORTH_WINDOW:
			return Textures.Terrain.getRoofRedHorizontalNorthWindow();
		case ROOF_RED_HORIZONTAL_SOUTH:
			return Textures.Terrain.getRoofRedHorizontalSouth();
		case ROOF_RED_HORIZONTAL_SOUTH_CHIMNEY:
			return Textures.Terrain.getRoofRedHorizontalSouthChimney();
		case ROOF_RED_HORIZONTAL_SOUTH_EAST_GUTTER:
			return Textures.Terrain.getRoofRedHorizontalSouthEastGutter();
		case ROOF_RED_HORIZONTAL_SOUTH_EAST_RIDGE:
			return Textures.Terrain.getRoofRedHorizontalSouthEastRidge();
		case ROOF_RED_HORIZONTAL_SOUTH_GUTTER:
			return Textures.Terrain.getRoofRedHorizontalSouthGutter();
		case ROOF_RED_HORIZONTAL_SOUTH_RIDGE:
			return Textures.Terrain.getRoofRedHorizontalSouthRidge();
		case ROOF_RED_HORIZONTAL_SOUTH_WEST_GUTTER:
			return Textures.Terrain.getRoofRedHorizontalSouthWestGutter();
		case ROOF_RED_HORIZONTAL_SOUTH_WEST_RIDGE:
			return Textures.Terrain.getRoofRedHorizontalSouthWestRidge();
		case ROOF_RED_HORIZONTAL_SOUTH_WINDOW:
			return Textures.Terrain.getRoofRedHorizontalSouthWindow();
		case ROOF_RED_VERTICAL_EAST:
			return Textures.Terrain.getRoofRedVerticalEast();
		case ROOF_RED_VERTICAL_EAST_CHIMNEY:
			return Textures.Terrain.getRoofRedVerticalEastChimney();
		case ROOF_RED_VERTICAL_EAST_GUTTER:
			return Textures.Terrain.getRoofRedVerticalEastGutter();
		case ROOF_RED_VERTICAL_EAST_RIDGE:
			return Textures.Terrain.getRoofRedVerticalEastRidge();
		case ROOF_RED_VERTICAL_EAST_WINDOW:
			return Textures.Terrain.getRoofRedVerticalEastWindow();
		case ROOF_RED_VERTICAL_NORTH_EAST_GUTTER:
			return Textures.Terrain.getRoofRedVerticalNorthEastGutter();
		case ROOF_RED_VERTICAL_NORTH_WEST_GUTTER:
			return Textures.Terrain.getRoofRedVerticalNorthWestGutter();
		case ROOF_RED_VERTICAL_SOUTH_EAST_GUTTER:
			return Textures.Terrain.getRoofRedVerticalSouthEastGutter();
		case ROOF_RED_VERTICAL_SOUTH_WEST_GUTTER:
			return Textures.Terrain.getRoofRedVerticalSouthWestGutter();
		case ROOF_RED_VERTICAL_WEST:
			return Textures.Terrain.getRoofRedVerticalWest();
		case ROOF_RED_VERTICAL_WEST_CHIMNEY:
			return Textures.Terrain.getRoofRedVerticalWestChimney();
		case ROOF_RED_VERTICAL_WEST_GUTTER:
			return Textures.Terrain.getRoofRedVerticalWestGutter();
		case ROOF_RED_VERTICAL_WEST_RIDGE:
			return Textures.Terrain.getRoofRedVerticalWestRidge();
		case ROOF_RED_VERTICAL_WEST_WINDOW:
			return Textures.Terrain.getRoofRedVerticalWestWindow();
		case TILES:
			return Textures.Terrain.getTiles();
		case WATER:
			return Textures.Terrain.getWater();
		case YELLOW_FLOWER:
			return Textures.Terrain.getYellowFlower();
		default:
			return null;
		}
	}

	public boolean isSolid() {
		return solid;
	}
}
