package me.team.ld34.graphics;

import java.awt.Graphics2D;

import me.team.ld34.core.Game;
import me.team.ld34.tiles.Tile;

public class Renderer {

	private final Game	game;
	private GuiRenderer	guiRenderer;
	private TileRenderer tileRenderer;

	public Renderer(Game game) {
		this.game = game;
		
		guiRenderer = new GuiRenderer(game);
		tileRenderer = new TileRenderer(game.getGameManager());
	}
	
	public void render(Graphics2D g) {
		for (Tile tile : game.getGameManager().getShipTiles()) {
			tileRenderer.render(g, tile, game.xScroll, game.yScroll);
			tileRenderer.renderOverlay(g, tile, game.xScroll, game.yScroll);
		}
		
		guiRenderer.render(g);
	}

}
