package code.views;

import java.util.ArrayList;
import java.util.List;

import code.Tilemap;
import code.entities.Actor;
import code.entities.Milkman;

public abstract class Scene extends View {
	protected Milkman milkman;
	protected List<Actor> actors = new ArrayList<>();
	protected Tilemap terrain;
	protected Tilemap items;

	public Scene(String pathToTerrainMap, String pathToItemMap) {
		terrain = new Tilemap(pathToTerrainMap);
		items = new Tilemap(pathToItemMap);
	}

	public List<Actor> getActors() {
		return actors;
	}

	public Milkman getMilkman() {
		return milkman;
	}

	public boolean isPixelSolid(int pixelX, int pixelY) {
		return terrain.getMaterial(pixelX / 32, pixelY / 32).isSolid();
	}
}
