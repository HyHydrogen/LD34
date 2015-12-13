package me.team.ld34.tiles;

public class Tile {
	public static final int TILE_PRODUCTION = 3;

	public static final int TILE_REACTOR = 4;
	public static final int TILE_CORE = 5;
	public static final int TILE_LASER = 6;

	private int	tileX;
	private int	tileY;
	private int	type;

	public Tile(int x, int y, int type) {
		this.tileX = x;
		this.tileY = y;
		this.type = type;
	}
	
	public int getTileX() {
		return tileX;
	}
	
	public int getTileY() {
		return tileY;
	}
	
	public int getTileType() {
		return type;
	}
}
