package me.iyansiwik.visnov.engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import me.iyansiwik.visnov.engine.gamestates.GameState;

public abstract class Game implements Runnable {

	private String name;
	private int width, height;
	private double scale;
	
	private JFrame frame;
	private Canvas canvas;
	
	private BufferedImage image;
	
	private Thread thread;
	
	private GameState gamestate;
	
	private boolean running = false;
	
	public Game(String name, int width, int height, double scale) {
		this.name = name;
		this.width = width;
		this.height = height;
		this.scale = scale;
		
		canvas = new Canvas();
		canvas.setSize((int)(width*scale), (int)(height*scale));

		frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(canvas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		canvas.requestFocus();
		
		thread = new Thread(this);
	}
	
	public void start() {
		if(running) return;
		
		running = true;
		thread.start();
	}
	
	public void stop() {
		running = false;
	}
	
	public void run() {
		game_init();
		while(running) {
			game_update();
			game_render();
		}
		
		try {
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void game_init() {
		gamestate = null;
		init();
		if(gamestate == null) {
			//do nothing but later this is gonna be an error and crash
		}
		gamestate.init(this);
	}
	
	private void game_update() {
		update();
		if(gamestate != null) gamestate.update(this);
	}
	
	private void game_render() {
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(new Color(0x000000));
		g2d.fillRect(0, 0, width, height);
		if(gamestate != null) gamestate.render(this, g2d);
		g2d.dispose();
		Graphics g = canvas.getGraphics();
		g.drawImage(image, 0, 0, (int)(width*scale), (int)(height*scale), null);
		g.dispose();
	}

	public abstract void init();
	public abstract void update();
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setGameState(GameState state) {
		gamestate = state;
	}
}
