package me.iyansiwik.visnov.engine.gamestates;

import java.awt.Graphics2D;

import me.iyansiwik.visnov.engine.Game;

public interface GameState {

	public void init(Game g);
	public void update(Game g);
	public void render(Game g, Graphics2D g2d);
}
