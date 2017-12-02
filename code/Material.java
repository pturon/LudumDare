package code;

import java.awt.image.BufferedImage;

public enum Material {
	NONE(-1, false),
	PAVEMENT_CORNER_SOUT_EAST(0, false),
	PAVEMENT_SOUTH(1, false),
	PAVEMENT_CORNER_SOUT_WEST(2, false),
	PAVEMENT_NORTH_WEST(3, false),
	PAVEMENT_EAST(8, false),
	GRASS(9, false),
	PAVEMENT_WEST(10, false),
	PAVEMENT_NORTH(17, false),
	ASPHALT(19, false),
	FLOWERS(20, false);

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
		case FLOWERS:
			return Textures.Terrain.getFlowers();
		case GRASS:
			return Textures.Terrain.getGrass();
		case PAVEMENT_CORNER_SOUT_EAST:
			return Textures.Terrain.getPavementCornerSouthEast();
		case PAVEMENT_CORNER_SOUT_WEST:
			return Textures.Terrain.getPavementCornerSouthWest();
		case PAVEMENT_EAST:
			return Textures.Terrain.getPavementEast();
		case PAVEMENT_NORTH:
			return Textures.Terrain.getPavementNorth();
		case PAVEMENT_NORTH_WEST:
			return Textures.Terrain.getPavementNorthWest();
		case PAVEMENT_SOUTH:
			return Textures.Terrain.getPavementSouth();
		case PAVEMENT_WEST:
			return Textures.Terrain.getPavementWest();
		default:
			return null;
		}
	}

	public boolean isSolid() {
		return solid;
	}
}
