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
	ROOF_RED_VERTICAL_WEST_GUTTER(32, true),
	ROOF_RED_VERTICAL_WEST(33, true),
	ROOF_RED_VERTICAL_WEST_RIDGE(34, true),
	ROOF_RED_VERTICAL_EAST_RIDGE(35, true),
	ROOF_RED_VERTICAL_EAST(36, true),
	ROOF_RED_VERTICAL_EAST_GUTTER(37, true),
	ROOF_BLUE_VERTICAL_WEST_GUTTER(56, true),
	ROOF_BLUE_VERTICAL_WEST(57, true),
	ROOF_BLUE_VERTICAL_WEST_RIDGE(58, true),
	ROOF_BLUE_VERTICAL_EAST_RIDGE(59, true),
	ROOF_BLUE_VERTICAL_EAST(60, true),
	ROOF_BLUE_VERTICAL_EAST_GUTTER(61, true),
	FENCE_NORTH_WEST(72, true),
	FENCE_NORTH(73, true),
	FENCE_NORTH_EAST(74, true),
	FENCE_WEST(80, true),
	LAMP(81, true),
	FENCE_EAST(82, true),
	FENCE_SOUTH_WEST(88, true),
	FENCE_SOUTH(89, true),
	FENCE_SOUTH_EAST(90, true),
	WATER(93, true),
	TILES(94, false);

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
		case ROOF_BLUE_VERTICAL_EAST:
			return Textures.Terrain.getRoofBlueVerticalEast();
		case ROOF_BLUE_VERTICAL_EAST_GUTTER:
			return Textures.Terrain.getRoofBlueVerticalEastGutter();
		case ROOF_BLUE_VERTICAL_EAST_RIDGE:
			return Textures.Terrain.getRoofBlueVerticalEastRidge();
		case ROOF_BLUE_VERTICAL_WEST:
			return Textures.Terrain.getRoofBlueVerticalWest();
		case ROOF_BLUE_VERTICAL_WEST_GUTTER:
			return Textures.Terrain.getRoofBlueVerticalWestGutter();
		case ROOF_BLUE_VERTICAL_WEST_RIDGE:
			return Textures.Terrain.getRoofBlueVerticalWestRidge();
		case ROOF_RED_VERTICAL_EAST:
			return Textures.Terrain.getRoofRedVerticalEast();
		case ROOF_RED_VERTICAL_EAST_GUTTER:
			return Textures.Terrain.getRoofRedVerticalEastGutter();
		case ROOF_RED_VERTICAL_EAST_RIDGE:
			return Textures.Terrain.getRoofRedVerticalEastRidge();
		case ROOF_RED_VERTICAL_WEST:
			return Textures.Terrain.getRoofRedVerticalWest();
		case ROOF_RED_VERTICAL_WEST_GUTTER:
			return Textures.Terrain.getRoofRedVerticalWestGutter();
		case ROOF_RED_VERTICAL_WEST_RIDGE:
			return Textures.Terrain.getRoofRedVerticalWestRidge();
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
