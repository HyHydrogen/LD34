package me.team.ld34.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.team.ld34.core.Game;

public class GuiRenderer {

	private Game game;
	private BufferedImage topGui;
	
	
	public GuiRenderer(Game game) {
		this.game = game;
		try {
			topGui = ImageIO.read(getClass().getResource("/Real Gui.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics2D g) {
		g.drawImage(topGui, 0, 0, 800, 41, null);
		
		int units = game.getGameManager().getResourceManager().getUnits().getAmount();
		int power = game.getGameManager().getResourceManager().getEnergy().getAmount();

		int unitsPerSecond = game.getGameManager().getResourceManager().getUnits().getPassiveGain();
		
		//game.getRenderer().getTileRenderer().tiles[Tile.TILE_PRODUCTION];
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Calibri", Font.BOLD, 19));
		
		g.drawString("" + units, 40, 24);
		g.drawString("" + power, 182, 24);
	}

}
