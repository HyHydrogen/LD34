package me.team.ld34.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashSet;

public class LD34KeyListener implements KeyListener, MouseWheelListener {

	private Game				game;
	private HashSet<Integer>	keysPressed;

	public LD34KeyListener(Game game) {
		this.game = game;
		keysPressed = new HashSet<Integer>();
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_W | event.getKeyCode() == KeyEvent.VK_A | event.getKeyCode() == KeyEvent.VK_S | event.getKeyCode() == KeyEvent.VK_D) {
			keysPressed.add(event.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_W | event.getKeyCode() == KeyEvent.VK_A | event.getKeyCode() == KeyEvent.VK_S | event.getKeyCode() == KeyEvent.VK_D) {
			keysPressed.remove(event.getKeyCode());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	int speed = (int) (3 * GameManager.TILE_SCALE);

	public void tick() {
		if (keysPressed.contains(KeyEvent.VK_W)) {
			game.yScroll -= speed;
		}

		if (keysPressed.contains(KeyEvent.VK_S)) {
			game.yScroll += speed;
		}

		if (keysPressed.contains(KeyEvent.VK_A)) {
			game.xScroll -= speed;
		}

		if (keysPressed.contains(KeyEvent.VK_D)) {
			game.xScroll += speed;
		}
	}


	double minScale = 0.4;
	double maxScale = 5;
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		GameManager.TILE_SCALE -= event.getPreciseWheelRotation() / 10;

		if (GameManager.TILE_SCALE < minScale)
			GameManager.TILE_SCALE = minScale;
		else if (GameManager.TILE_SCALE > maxScale)
			GameManager.TILE_SCALE = maxScale;
		else {
			game.xScroll -= event.getPreciseWheelRotation() * 15;
			game.yScroll -= event.getPreciseWheelRotation() * 15;
		}
	}

}
