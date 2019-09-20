 package Map;

import java.awt.Graphics;

import Display.ButtonHandler;
import Display.Display;
import Render.LoadTextures;

public class MapHandler {
	
	
	private String directory = System.getProperty("user.dir");
	private String[] mapPaths, levelPaths;
	private Map currentMap;
	private LoadTextures textures;
	private String texturePaths = directory + "/res/TexturePaths.txt";
	private int width, height, scale, currentMapIndex, currentDifficulty;
	protected int[] difficulty;
	public static boolean[] locked = {true, false, false, false, false};
	public static boolean closeGame1 = false;
	public static int currentLevel = 0;
 
	
	public MapHandler(ButtonHandler buttonHandler) {
		width = Display.WIDTH; height = Display.HEIGHT; scale = Display.scale;
		textures = new LoadTextures(new LoadFile(texturePaths).getFileText());
		
		mapPaths = new String[]{directory + "/res/Map1.png", directory + "/res/Map2.png", directory + "/res/Map3.png", directory + "/res/Map4.png", directory + "/res/Map5.png"};
		levelPaths = new String[]{directory + "/res/Level1.txt", directory + "/res/Level2.txt", directory + "/res/Level3.txt", directory + "/res/Level4.txt", directory + "/res/Level5.txt"};
		currentMapIndex = 0;
		difficulty = new int[] {1, 2, 3, 4, 5};
		currentMap = new Map(mapPaths[currentMapIndex], textures, levelPaths[currentMapIndex],width, height, scale, this);
	}
	
	public void render(Graphics g) {
		currentMap.render(g);
	}
	
	public void tick(ButtonHandler buttonHandler) {
		currentMap.tick(buttonHandler);
	}
	
	public void setCurrentMap(int index) { 
		if(locked[index]) {
			currentMap = new Map(mapPaths[index], textures, levelPaths[index], width, height, scale, this);
			currentDifficulty = difficulty[index];
			currentMap.setDifficulty(getDifficulty());
			currentLevel = index;
		} else {
			closeGame1 = true;
		}
		
	}
	
	public int getDifficulty() {
		return currentDifficulty;
	}
	
	public Map getCurrentMap() {
		return currentMap;
	}
}	
