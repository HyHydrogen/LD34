package me.team.ld34.graphics;

import java.awt.Graphics2D;

import me.team.ld34.core.Game;
import me.team.ld34.tiles.Tile;

public class PlaceTiles {

	private Game	game;

	private boolean	placingTiles;

	private int		mouseX;
	private int		mouseY;

	public PlaceTiles(Game game) {
		this.game = game;
		
		placingTiles = false;
	}

	public void render(Graphics2D g) {
		if (!placingTiles)
			return;

		int xLocationTile = (game.xScroll + mouseX) / 64;
		int yLocationTile = (game.yScroll + mouseY) / 64;

		for (Tile tile : game.getGameManager().gameTiles) {
			if (tile.getTileX() == xLocationTile && tile.getTileY() == yLocationTile)
				return;
		}

		game.getRenderer().getTileRenderer().render(g, new Tile(xLocationTile, yLocationTile, Tile.TILE_PRODUCTION));
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

}
