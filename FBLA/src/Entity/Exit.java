package Entity;

import java.awt.Rectangle;

import Map.MapHandler;
import Render.Texture;

public class Exit extends Entity {

	private int radius;
	private boolean open;
	
	public Exit(int x, int y, int width, int height, int radius) {
		super(x, y, width , height, 255, true);
		this.radius = radius;
		open = false;
	}

	public Exit(int x, int y, int width, int height, int radius, Texture texture) {
		super(x, y, width, height, texture, true);
		this.radius = radius;
		open = false;
	}
	
	public void tick(Player player) {
		if(detect(player)) {
			if(MapHandler.currentLevel + 1 < 5) {
				MapHandler.locked[MapHandler.currentLevel + 1] = true;				
			}
			MapHandler.locked[MapHandler.currentLevel] = false;
			MapHandler.closeGame1 = true;
		}
	}
	
	public boolean detect(Player player) {
		return getAOE().intersects(player.getBounds()) && !open;
	}
	
	public Rectangle getAOE() {
		return new Rectangle(x - radius, y - radius, 2 * radius + width, 2 * radius + height);
	}
	
	
}