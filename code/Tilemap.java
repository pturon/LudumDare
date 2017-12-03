package code;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tilemap {
	private int width;
	private int height;
	private Material[][] materials;

	public Tilemap(String path, Class parentClass) {
		try(InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {

			width = Integer.parseInt(reader.readLine().substring(10));//tileswide xxx
			height = Integer.parseInt(reader.readLine().substring(10));//tileshigh xxx
			materials = new Material[width][height];

			reader.readLine();//tilewidth xxx
			reader.readLine();//tileheight xxx
			reader.readLine();//empty line
			reader.readLine();//layer 0

			for(int y = 0; y < height; y++) {
				String[] line = reader.readLine().split(",");
				for(int x = 0; x < width; x++) {
					materials[x][y] = Material.byId(Integer.parseInt(line[x]), parentClass);
				}
			}
		} catch(Exception exception) {
			//TODO
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Material getMaterial(int x, int y) {
		if(x < 0 || y < 0 || x >= materials.length || y >= materials[x].length) {
			return Material.NONE;
		}
		return materials[x][y];
	}

	public void setMaterial(int x, int y, Material material) {
		if(x < 0 || y < 0 || x >= materials.length || y >= materials[x].length) {
			return;
		}
		materials[x][y] = material;
	}
}
