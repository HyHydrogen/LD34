package me.team.ld34.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import me.team.ld34.graphics.Renderer;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = -1468256372886744451L;

	private boolean	running;
	private Thread	gameThread;

	public final int	WIDTH	= 4;
	public final int	HEIGHT	= 3;
	public final int	SCALE	= 200;

	public static final int	TICK_RATE	= 60;
	public static int		DELTA_TIME	= 0;

	private final String TITLE = "LD34 Game";

	private JFrame frame;

	private GameManager gameManager;
	private Renderer renderer;
	private LD34KeyListener keyListener;
	
	public int xScroll = 0;
	public int yScroll = 0;
	
	public Game() {
		running = false;
		gameThread = new Thread(this);
		keyListener = new LD34KeyListener(this);
		
		frame = new JFrame(TITLE);

		frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		
		addKeyListener(keyListener);
		addMouseWheelListener(keyListener);
		
		frame.add(this);
		
		gameManager = new GameManager(this);
		renderer = new Renderer(this);
	}

	public void run() {

		int frames = 0;
		int ticks = 0;

		double delta = 0d;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double ns = 1000000000.0 / TICK_RATE;

		System.out.println("Running");
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta > 1) {
				tick();
				delta--;
				ticks++;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - 1000 > timer) {
				timer += 1000;
				System.out.printf("Ticks: %s\tFrames: %s\n", ticks, frames);

				ticks = 0;
				frames = 0;
			}

			
			try {
				gameThread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		stop();
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		int tS = 128;

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		
		renderer.render(g);
		
		g.dispose();

		bs.show();

	}

	private void tick() {
		keyListener.tick();
	}

	public void start() {
		if (running & !gameThread.isAlive())
			return;

		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void stop() {
		if (!running | gameThread == null)
			return;

		running = false;

		try {
			gameThread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
	public GameManager getGameManager() {
		return gameManager;
	}
}
