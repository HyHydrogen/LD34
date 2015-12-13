package me.team.ld34.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.team.ld34.core.Game;
import me.team.ld34.tiles.Tile;

public class GuiRenderer {

	private Game game;
	private BufferedImage topGui, topIcon1, topIcon2, topIcon3, topIcon4, topIcon5;
	
	public GuiRenderer(Game game) {
		this.game = game;
		try {
			topIcon1 = ImageIO.read(getClass().getResource("/Production Tile.png"));
			topIcon2 = ImageIO.read(getClass().getResource("/Reactor Tile.png"));
			topIcon3 = ImageIO.read(getClass().getResource("/Laser Tower.png"));
			topIcon4 = ImageIO.read(getClass().getResource("/Core Tile.png"));
			topIcon5 = ImageIO.read(getClass().getResource("/Production Tile.png"));
			topGui = ImageIO.read(getClass().getResource("/Real Gui.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics2D g) {
		g.drawImage(topGui, 0, 0, 800, 41, null);
		
		g.drawImage(game.getRenderer().getTileRenderer().tiles[Tile.TILE_PRODUCTION - 1], 566, 2, 30, 30, null);
		g.drawImage(topIcon2, 613, 2, 30, 30, null);
		g.drawImage(topIcon3, 660, 2, 30, 30, null);
		g.drawImage(topIcon4, 707, 2, 30, 30, null);
		g.drawImage(topIcon5, 754, 2, 30, 30, null);
		
		int units = game.getGameManager().getResourceManager().getUnits().getAmount();
		int power = game.getGameManager().getResourceManager().getEnergy().getAmount();

		int unitsPerSecond = game.getGameManager().getResourceManager().getUnits().getPassiveGain();
		
		//game.getRenderer().getTileRenderer().tiles[Tile.TILE_PRODUCTION];
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Calibri", Font.BOLD, 19));
		
		g.drawString("" + units, 40, 24);
		g.drawString("" + power, 180, 24);
	}

}
