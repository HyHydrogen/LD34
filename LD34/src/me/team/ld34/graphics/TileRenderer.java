package me.team.ld34.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import me.team.ld34.core.Game;
import me.team.ld34.core.GameManager;
import me.team.ld34.tiles.Tile;

public class TileRenderer {

	public BufferedImage[] tiles;

	private GameManager gameManager;
	private Game game;
	
	public TileRenderer(Game game, GameManager manager) {
		this.game = game;
		gameManager = manager;

		tiles = new BufferedImage[6];
		try {
			tiles[0] = ImageIO.read(getClass().getResource("/Tile Bridge Top.png"));
			tiles[1] = ImageIO.read(getClass().getResource("/Tile Bridge Left.png"));
			tiles[2] = ImageIO.read(getClass().getResource("/Production Tile.png"));
			tiles[3] = ImageIO.read(getClass().getResource("/Reactor Tile.png"));
			tiles[4] = ImageIO.read(getClass().getResource("/Core Tile.png"));
			tiles[5] = ImageIO.read(getClass().getResource("/Laser Tower.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics2D g, Tile tile) {
		int tileX = tile.getTileX();
		int tileY = tile.getTileY();

		int renderX = (int) (tileX * gameManager.TILE_WIDTH * gameManager.TILE_SCALE) - game.xScroll;
		int renderY = (int) (tileY * gameManager.TILE_HEIGHT * gameManager.TILE_SCALE) - game.yScroll;

		g.drawImage(tiles[tile.getTileType() - 1], renderX, renderY, (int) (gameManager.TILE_WIDTH * gameManager.TILE_SCALE), (int) (gameManager.TILE_HEIGHT * gameManager.TILE_SCALE), null);
	}
	
	public void renderOverlay(Graphics2D g, Tile tile) {
		int tileX = tile.getTileX();
		int tileY = tile.getTileY();
		
		int renderX = (int) (tileX * gameManager.TILE_WIDTH * gameManager.TILE_SCALE) - game.xScroll;
		int renderY = (int) (tileY * gameManager.TILE_HEIGHT * gameManager.TILE_SCALE) - game.yScroll;
		
		boolean collidingUp = false, collidingLeft = false;

		for (Tile tileIter : gameManager.getShipTiles()) {
			if (tileIter.getTileX() == tileX) {

				if (tileIter.getTileY() == tileY)
					continue;

				if (tileIter.getTileY() == tileY - 1)
					collidingUp = true;
			}

			if (tileIter.getTileY() == tileY) {
				if (tileIter.getTileX() == tileX)
					continue;

				if (tileIter.getTileX() == tileX - 1)
					collidingLeft = true;
			}
		}

		if (collidingUp)
			g.drawImage(tiles[1],
					renderX + (int) (gameManager.TILE_TOP_BRIDGE_WIDTH * gameManager.TILE_SCALE / 2),
					renderY - (int) (gameManager.TILE_TOP_BRIDGE_HEIGHT * gameManager.TILE_SCALE / 2),
					(int) (gameManager.TILE_TOP_BRIDGE_WIDTH * gameManager.TILE_SCALE),
					(int) (gameManager.TILE_TOP_BRIDGE_HEIGHT * gameManager.TILE_SCALE),
					null);
					
		if (collidingLeft)
			g.drawImage(tiles[0],
					renderX - (int) (gameManager.TILE_LEFT_BRIDGE_WIDTH * gameManager.TILE_SCALE / 2),
					renderY + (int) (gameManager.TILE_LEFT_BRIDGE_HEIGHT * gameManager.TILE_SCALE / 2),
					(int) (gameManager.TILE_LEFT_BRIDGE_WIDTH * gameManager.TILE_SCALE),
					(int) (gameManager.TILE_LEFT_BRIDGE_HEIGHT * gameManager.TILE_SCALE),
					null);
	}
}
