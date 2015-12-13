package me.team.ld34.graphics;

import java.awt.Graphics2D;

import me.team.ld34.core.Game;
import me.team.ld34.tiles.Tile;

public class Renderer {

	private final Game	game;
	private GuiRenderer	guiRenderer;
	private TileRenderer tileRenderer;
	private PlaceTiles placeTiles;

	public Renderer(Game game) {
		this.game = game;
		
		guiRenderer = new GuiRenderer(game);
		tileRenderer = new TileRenderer(game, game.getGameManager());
		placeTiles = new PlaceTiles(game);
	}
	
	public void render(Graphics2D g) {
		for (Tile tile : game.getGameManager().getShipTiles()) {
			tileRenderer.render(g, tile);
			tileRenderer.renderOverlay(g, tile);
		}
		
		guiRenderer.render(g);
	}

	public TileRenderer getTileRenderer() {
        return tileRenderer;
	}
}
