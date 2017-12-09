package code.enums;

import java.awt.image.BufferedImage;

import code.Textures;
import code.views.MilkFactory;
import code.views.Overworld;
import code.views.Scene;

public enum Material {
	//technical tiles
	NONE(-1, true, null),
	SCENE_CONNECTOR(-42, false, null),//connects the overworld with the milk-factory

	//overworld-tiles
	PAVEMENT_CORNER_SOUTH_EAST(0, false, Overworld.class),
	PAVEMENT_SOUTH(1, false, Overworld.class),
	PAVEMENT_CORNER_SOUTH_WEST(2, false, Overworld.class),
	PAVEMENT_NORTH_WEST(3, false, Overworld.class),
	PAVEMENT_NORTH_EAST(4, false, Overworld.class),
	PAVEMENT(5, false, Overworld.class),
	PAVEMENT_EAST(8, false, Overworld.class),
	GRASS(9, false, Overworld.class),
	PAVEMENT_WEST(10, false, Overworld.class),
	PAVEMENT_SOUTH_WEST(11, false, Overworld.class),
	PAVEMENT_SOUTH_EAST(12, false, Overworld.class),
	PURPLE_FLOWER(13, false, Overworld.class),
	PAVEMENT_CORNER_NORTH_EAST(16, false, Overworld.class),
	PAVEMENT_NORTH(17, false, Overworld.class),
	PAVEMENT_CORNER_NORTH_WEST(18, false, Overworld.class),
	ASPHALT(19, false, Overworld.class),
	YELLOW_FLOWER(20, false, Overworld.class),
	MAGENTA_FLOWER(21, false, Overworld.class),
	ROOF_RED_VERTICAL_NORTH_WEST_GUTTER(24, true, Overworld.class),
	ROOF_RED_VERTICAL_WEST_WINDOW(25, true, Overworld.class),
	ROOF_RED_VERTICAL_EAST_WINDOW(28, true, Overworld.class),
	ROOF_RED_VERTICAL_NORTH_EAST_GUTTER(29, true, Overworld.class),
	ROOF_RED_VERTICAL_WEST_GUTTER(32, true, Overworld.class),
	ROOF_RED_VERTICAL_WEST(33, true, Overworld.class),
	ROOF_RED_VERTICAL_WEST_RIDGE(34, true, Overworld.class),
	ROOF_RED_VERTICAL_EAST_RIDGE(35, true, Overworld.class),
	ROOF_RED_VERTICAL_EAST(36, true, Overworld.class),
	ROOF_RED_VERTICAL_EAST_GUTTER(37, true, Overworld.class),
	ROOF_RED_VERTICAL_SOUTH_WEST_GUTTER(40, true, Overworld.class),
	ROOF_RED_VERTICAL_WEST_CHIMNEY(41, true, Overworld.class),
	ROOF_RED_VERTICAL_EAST_CHIMNEY(44, true, Overworld.class),
	ROOF_RED_VERTICAL_SOUTH_EAST_GUTTER(45, true, Overworld.class),
	ROOF_BLUE_VERTICAL_NORTH_WEST_GUTTER(48, true, Overworld.class),
	ROOF_BLUE_VERTICAL_WEST_WINDOW(49, true, Overworld.class),
	ROOF_BLUE_VERTICAL_EAST_WINDOW(52, true, Overworld.class),
	ROOF_BLUE_VERTICAL_NORTH_EAST_GUTTER(53, true, Overworld.class),
	ROOF_BLUE_VERTICAL_WEST_GUTTER(56, true, Overworld.class),
	ROOF_BLUE_VERTICAL_WEST(57, true, Overworld.class),
	ROOF_BLUE_VERTICAL_WEST_RIDGE(58, true, Overworld.class),
	ROOF_BLUE_VERTICAL_EAST_RIDGE(59, true, Overworld.class),
	ROOF_BLUE_VERTICAL_EAST(60, true, Overworld.class),
	ROOF_BLUE_VERTICAL_EAST_GUTTER(61, true, Overworld.class),
	ROOF_BLUE_VERTICAL_SOUTH_WEST_GUTTER(64, true, Overworld.class),
	ROOF_BLUE_VERTICAL_WEST_CHIMNEY(65, true, Overworld.class),
	ROOF_BLUE_VERTICAL_EAST_CHIMNEY(68, true, Overworld.class),
	ROOF_BLUE_VERTICAL_SOUTH_EAST_GUTTER(69, true, Overworld.class),
	FENCE_NORTH_WEST(72, true, Overworld.class),
	FENCE_NORTH(73, true, Overworld.class),
	FENCE_NORTH_EAST(74, true, Overworld.class),
	BRIDGE_HORIZONTAL_NORTH_WEST(77, true, Overworld.class),
	BRIDGE_HORIZONTAL_NORTH(78, true, Overworld.class),
	BRIDGE_HORIZONTAL_NORTH_EAST(79, true, Overworld.class),
	FENCE_WEST(80, true, Overworld.class),
	LAMP(81, true, Overworld.class),
	FENCE_EAST(82, true, Overworld.class),
	BRIDGE_HORIZONTAL_SOUTH_WEST(85, true, Overworld.class),
	BRIDGE_HORIZONTAL_SOUTH(86, true, Overworld.class),
	BRIDGE_HORIZONTAL_SOUTH_EAST(87, true, Overworld.class),
	FENCE_SOUTH_WEST(88, true, Overworld.class),
	FENCE_SOUTH(89, true, Overworld.class),
	FENCE_SOUTH_EAST(90, true, Overworld.class),
	WATER(93, true, Overworld.class),
	TILES(94, false, Overworld.class),
	ROOF_RED_HORIZONTAL_NORTH_WEST_GUTTER(96, true, Overworld.class),
	ROOF_RED_HORIZONTAL_NORTH_GUTTER(97, true, Overworld.class),
	ROOF_RED_HORIZONTAL_NORTH_EAST_GUTTER(98, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_NORTH_WEST_GUTTER(99, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_NORTH_GUTTER(100, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_NORTH_EAST_GUTTER(101, true, Overworld.class),
	ROOF_RED_HORIZONTAL_NORTH_CHIMNEY(104, true, Overworld.class),
	ROOF_RED_HORIZONTAL_NORTH(105, true, Overworld.class),
	ROOF_RED_HORIZONTAL_NORTH_WINDOW(106, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_NORTH_CHIMNEY(107, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_NORTH(108, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_NORTH_WINDOW(109, true, Overworld.class),
	ROOF_RED_HORIZONTAL_NORTH_WEST_RIDGE(112, true, Overworld.class),
	ROOF_RED_HORIZONTAL_NORTH_RIDGE(113, true, Overworld.class),
	ROOF_RED_HORIZONTAL_NORTH_EAST_RIDGE(114, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_NORTH_WEST_RIDGE(115, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_NORTH_RIDGE(116, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_NORTH_EAST_RIDGE(117, true, Overworld.class),
	ROOF_RED_HORIZONTAL_SOUTH_WEST_RIDGE(120, true, Overworld.class),
	ROOF_RED_HORIZONTAL_SOUTH_RIDGE(121, true, Overworld.class),
	ROOF_RED_HORIZONTAL_SOUTH_EAST_RIDGE(122, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_SOUTH_WEST_RIDGE(123, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_SOUTH_RIDGE(124, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_SOUTH_EAST_RIDGE(125, true, Overworld.class),
	ROOF_RED_HORIZONTAL_SOUTH_CHIMNEY(128, true, Overworld.class),
	ROOF_RED_HORIZONTAL_SOUTH(129, true, Overworld.class),
	ROOF_RED_HORIZONTAL_SOUTH_WINDOW(130, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_SOUTH_CHIMNEY(131, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_SOUTH(132, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_SOUTH_WINDOW(133, true, Overworld.class),
	ROOF_RED_HORIZONTAL_SOUTH_WEST_GUTTER(136, true, Overworld.class),
	ROOF_RED_HORIZONTAL_SOUTH_GUTTER(137, true, Overworld.class),
	ROOF_RED_HORIZONTAL_SOUTH_EAST_GUTTER(138, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_SOUTH_WEST_GUTTER(139, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_SOUTH_GUTTER(140, true, Overworld.class),
	ROOF_BLUE_HORIZONTAL_SOUTH_EAST_GUTTER(141, true, Overworld.class),
	EMPTY_BOTTLE(144, false, Overworld.class),
	FILLED_BOTTLE(145, false, Overworld.class),
	CARDBOARD_BOX(146, false, Overworld.class),

	//milk-factory-tiles
	PAVEMENT_SOUTH_MF(1, false, MilkFactory.class),
	PAVEMENT_NORTH_WEST_MF(3, false, MilkFactory.class),
	PAVEMENT_NORTH_EAST_MF(4, false, MilkFactory.class),
	PAVEMENT_EAST_MF(6, false, MilkFactory.class),
	GRASS_MF(7, false, MilkFactory.class),
	PAVEMENT_WEST_MF(8, false, MilkFactory.class),
	PAVEMENT_SOUTH_EAST_MF(10, false, MilkFactory.class),
	PAVEMENT_CORNER_NORTH_EAST_MF(12, false, MilkFactory.class),
	PAVEMENT_NORTH_MF(13, false, MilkFactory.class),
	PAVEMENT_CORNER_NORTH_WEST_MF(14, false, MilkFactory.class),
	ASPHALT_MF(15, false, MilkFactory.class),
	TRACK_MARK_V(19, false, MilkFactory.class),
	TRACK_MARK_H(20, false, MilkFactory.class),
	CONVEYOR_BELT(21, true, MilkFactory.class),
	FENCE_WEST_MF(22, true, MilkFactory.class),
	FENCE_EAST_MF(23, true, MilkFactory.class),
	TANK1(24, true, MilkFactory.class),
	TANK2(25, true, MilkFactory.class),
	TANK3(26, true, MilkFactory.class),
	FENCE_SOUTH_WEST_MF(27, true, MilkFactory.class),
	FENCE_SOUTH_MF(28, true, MilkFactory.class),
	FENCE_SOUTH_EAST_MF(29, true, MilkFactory.class),
	TANK4(30, true, MilkFactory.class),
	TANK5(31, true, MilkFactory.class),
	TANK6(32, true, MilkFactory.class),
	RAMP1(33, true, MilkFactory.class),
	RAMP2(34, true, MilkFactory.class),
	RAMP3(35, true, MilkFactory.class),
	TANK7(36, true, MilkFactory.class),
	TANK8(37, true, MilkFactory.class),
	TANK9(38, true, MilkFactory.class),
	RAMP4(39, true, MilkFactory.class),
	RAMP5(40, true, MilkFactory.class),
	RAMP6(41, true, MilkFactory.class),
	PIPE_CORNER(43, true, MilkFactory.class),
	PIPE1(44, true, MilkFactory.class),
	SIGN1(45, true, MilkFactory.class),
	SIGN2(46, true, MilkFactory.class),
	SIGN3(47, true, MilkFactory.class),
	PIPE2(49, true, MilkFactory.class),
	PIPE3(50, true, MilkFactory.class),
	SIGN4(51, true, MilkFactory.class),
	SIGN5(52, true, MilkFactory.class),
	SIGN6(53, true, MilkFactory.class);

	private int id;
	private boolean solid;
	private Class<?> clazz;

	Material(int id, boolean solid, Class<?> clazz) {
		this.id = id;
		this.solid = solid;
		this.clazz = clazz;
	}

	public static Material byId(int id, Class<? extends Scene> clazz) {
		for(Material material : Material.values()) {
			if(material.id == id && (material.clazz == clazz || material.clazz == null)) {
				return material;
			}
		}
		return NONE;
	}

	public BufferedImage getImage() {
		switch(this) {
		case ASPHALT:
		case ASPHALT_MF:
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
		case CARDBOARD_BOX:
			return Textures.getCardboardBox();
		case CONVEYOR_BELT:
			return Textures.Terrain.getConveyorBelt();
		case EMPTY_BOTTLE:
			return Textures.getEmptyBottle();
		case FENCE_EAST:
			return Textures.Terrain.getFenceEast();
		case FENCE_EAST_MF:
			return Textures.Terrain.getFenceEastMF();
		case FENCE_NORTH:
			return Textures.Terrain.getFenceNorth();
		case FENCE_NORTH_EAST:
			return Textures.Terrain.getFenceNorthEast();
		case FENCE_NORTH_WEST:
			return Textures.Terrain.getFenceNorthWest();
		case FENCE_SOUTH:
			return Textures.Terrain.getFenceSouth();
		case FENCE_SOUTH_MF:
			return Textures.Terrain.getFenceSouthMF();
		case FENCE_SOUTH_EAST:
			return Textures.Terrain.getFenceSouthEast();
		case FENCE_SOUTH_EAST_MF:
			return Textures.Terrain.getFenceSouthEastMF();
		case FENCE_SOUTH_WEST:
			return Textures.Terrain.getFenceSouthWest();
		case FENCE_SOUTH_WEST_MF:
			return Textures.Terrain.getFenceSouthWestMF();
		case FENCE_WEST:
			return Textures.Terrain.getFenceWest();
		case FENCE_WEST_MF:
			return Textures.Terrain.getFenceWestMF();
		case FILLED_BOTTLE:
			return Textures.getFilledBottle();
		case GRASS:
		case GRASS_MF:
			return Textures.Terrain.getGrass();
		case LAMP:
			return Textures.Terrain.getLamp();
		case MAGENTA_FLOWER:
			return Textures.Terrain.getMagentaFlower();
		case PAVEMENT:
			return Textures.Terrain.getPavement();
		case PAVEMENT_CORNER_NORTH_EAST:
		case PAVEMENT_CORNER_NORTH_EAST_MF:
			return Textures.Terrain.getPavementCornerNorthEast();
		case PAVEMENT_CORNER_NORTH_WEST:
		case PAVEMENT_CORNER_NORTH_WEST_MF:
			return Textures.Terrain.getPavementCornerNorthWest();
		case PAVEMENT_CORNER_SOUTH_EAST:
			return Textures.Terrain.getPavementCornerSouthEast();
		case PAVEMENT_CORNER_SOUTH_WEST:
			return Textures.Terrain.getPavementCornerSouthWest();
		case PAVEMENT_EAST:
		case PAVEMENT_EAST_MF:
			return Textures.Terrain.getPavementEast();
		case PAVEMENT_NORTH:
		case PAVEMENT_NORTH_MF:
			return Textures.Terrain.getPavementNorth();
		case PAVEMENT_NORTH_EAST:
		case PAVEMENT_NORTH_EAST_MF:
			return Textures.Terrain.getPavementNorthEast();
		case PAVEMENT_NORTH_WEST:
		case PAVEMENT_NORTH_WEST_MF:
			return Textures.Terrain.getPavementNorthWest();
		case PAVEMENT_SOUTH:
		case PAVEMENT_SOUTH_MF:
			return Textures.Terrain.getPavementSouth();
		case PAVEMENT_SOUTH_EAST:
		case PAVEMENT_SOUTH_EAST_MF:
			return Textures.Terrain.getPavementSouthEast();
		case PAVEMENT_SOUTH_WEST:
			return Textures.Terrain.getPavementSouthWest();
		case PAVEMENT_WEST:
		case PAVEMENT_WEST_MF:
			return Textures.Terrain.getPavementWest();
		case PIPE1:
			return Textures.Terrain.getPipe1();
		case PIPE2:
			return Textures.Terrain.getPipe2();
		case PIPE3:
			return Textures.Terrain.getPipe3();
		case PIPE_CORNER:
			return Textures.Terrain.getPipeCorner();
		case PURPLE_FLOWER:
			return Textures.Terrain.getPurpleFlower();
		case RAMP1:
			return Textures.Terrain.getRamp1();
		case RAMP2:
			return Textures.Terrain.getRamp2();
		case RAMP3:
			return Textures.Terrain.getRamp3();
		case RAMP4:
			return Textures.Terrain.getRamp4();
		case RAMP5:
			return Textures.Terrain.getRamp5();
		case RAMP6:
			return Textures.Terrain.getRamp6();
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
		case SIGN1:
			return Textures.Terrain.getSign1();
		case SIGN2:
			return Textures.Terrain.getSign2();
		case SIGN3:
			return Textures.Terrain.getSign3();
		case SIGN4:
			return Textures.Terrain.getSign4();
		case SIGN5:
			return Textures.Terrain.getSign5();
		case SIGN6:
			return Textures.Terrain.getSign6();
		case TANK1:
			return Textures.Terrain.getTank1();
		case TANK2:
			return Textures.Terrain.getTank2();
		case TANK3:
			return Textures.Terrain.getTank3();
		case TANK4:
			return Textures.Terrain.getTank4();
		case TANK5:
			return Textures.Terrain.getTank5();
		case TANK6:
			return Textures.Terrain.getTank6();
		case TANK7:
			return Textures.Terrain.getTank7();
		case TANK8:
			return Textures.Terrain.getTank8();
		case TANK9:
			return Textures.Terrain.getTank9();
		case TILES:
			return Textures.Terrain.getTiles();
		case TRACK_MARK_H:
			return Textures.Terrain.getTrackMarkH();
		case TRACK_MARK_V:
			return Textures.Terrain.getTrackMarkV();
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
