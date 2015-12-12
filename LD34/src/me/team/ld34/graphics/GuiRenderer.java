package me.team.ld34.graphics;;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import me.team.ld34.core.Game;

public class GuiRenderer {

	private Game game;

	public GuiRenderer(Game game) {
		this.game = game;
	}

	public void render(Graphics2D g) {
		int units = game.getGameManager().getResourceManager().getUnits().getAmount();
		int power = game.getGameManager().getResourceManager().getEnergy().getAmount();

		int unitsPerSecond = game.getGameManager().getResourceManager().getUnits().getPassiveGain();

		g.setColor(Color.WHITE);
		g.setFont(new Font("Calibri", Font.BOLD, 16));
		
		g.drawString("" + units, 80, 16);
		g.drawString("" + power, 180, 16);
	}

}
