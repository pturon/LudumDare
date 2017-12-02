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
	RED_GUTTER_WEST(32, true),
	RED_ROOF_WEST(33, true),
	RED_RIDGE_WEST(34, true),
	RED_RIDGE_EAST(35, true),
	RED_ROOF_EAST(36, true),
	RED_GUTTER_EAST(37, true),
	BLUE_GUTTER_WEST(56, true),
	BLUE_ROOF_WEST(57, true),
	BLUE_RIDGE_WEST(58, true),
	BLUE_RIDGE_EAST(59, true),
	BLUE_ROOF_EAST(60, true),
	BLUE_GUTTER_EAST(61, true),
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
		case BLUE_GUTTER_EAST:
			return Textures.Terrain.getBlueGutterEast();
		case BLUE_GUTTER_WEST:
			return Textures.Terrain.getBlueGutterWest();
		case BLUE_RIDGE_EAST:
			return Textures.Terrain.getBlueRidgeEast();
		case BLUE_RIDGE_WEST:
			return Textures.Terrain.getBlueRidgeWest();
		case BLUE_ROOF_EAST:
			return Textures.Terrain.getBlueRoofEast();
		case BLUE_ROOF_WEST:
			return Textures.Terrain.getBlueRoofWest();
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
		case RED_GUTTER_EAST:
			return Textures.Terrain.getRedGutterEast();
		case RED_GUTTER_WEST:
			return Textures.Terrain.getRedGutterWest();
		case RED_RIDGE_EAST:
			return Textures.Terrain.getRedRidgeEast();
		case RED_RIDGE_WEST:
			return Textures.Terrain.getRedRidgeWest();
		case RED_ROOF_EAST:
			return Textures.Terrain.getRedRoofEast();
		case RED_ROOF_WEST:
			return Textures.Terrain.getRedRoofWest();
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
