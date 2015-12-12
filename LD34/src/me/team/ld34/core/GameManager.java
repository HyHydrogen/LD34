package me.team.ld34.core;

import java.util.ArrayList;

import me.team.ld34.resources.ResourcesManager;
import me.team.ld34.tiles.Tile;

public class GameManager {

	private Game				game;
	private ResourcesManager	resourceManager;

	public static final int	TILE_WIDTH	= 64;
	public static final int	TILE_HEIGHT	= 64;
	public static double	TILE_SCALE	= 2.5;
	
	public static final int TILE_LEFT_BRIDGE_WIDTH = 8;
	public static final int TILE_LEFT_BRIDGE_HEIGHT = 30;
	
	public static final int TILE_TOP_BRIDGE_WIDTH = 30;
	public static final int TILE_TOP_BRIDGE_HEIGHT = 8;
	
	public ArrayList<Tile> gameTiles;

	public GameManager(Game game) {
		this.game = game;
		
		gameTiles = new ArrayList<Tile>();
		resourceManager = new ResourcesManager();
		
		addTile(new Tile(1, 1, Tile.TILE_PRODUCTION));
		addTile(new Tile(2, 1, Tile.TILE_PRODUCTION));
		addTile(new Tile(3, 1, Tile.TILE_PRODUCTION));
		
		addTile(new Tile(1, 2, Tile.TILE_PRODUCTION));
		addTile(new Tile(3, 2, Tile.TILE_PRODUCTION));
		
		addTile(new Tile(1, 3, Tile.TILE_PRODUCTION));
		addTile(new Tile(2, 3, Tile.TILE_PRODUCTION));
		addTile(new Tile(3, 3, Tile.TILE_PRODUCTION));
		addTile(new Tile(4, 3, Tile.TILE_PRODUCTION));

	}

	public ResourcesManager getResourceManager() {
		return resourceManager;
	}
	
	public ArrayList<Tile> getShipTiles() {
		return gameTiles;
	}
	
	public void addTile(Tile tile) {
		getShipTiles().add(tile);
	}

}
