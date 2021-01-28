package me.iyansiwik.visnov.engine.gamestates;

import java.awt.Graphics2D;

import me.iyansiwik.visnov.engine.Game;
import me.iyansiwik.visnov.engine.Location;
import me.iyansiwik.visnov.engine.Person;

public class GSPlay implements GameState {
	
	private Location location;
	private Person person;
	
	public GSPlay(Location location, Person person) {
		this.location = location;
		this.person = person;
	}

	public void init(Game g) {
		
	}
	
	public void update(Game g) {
		if(location != null) location.update(g);
		if(person != null) person.update(g);
	}
	
	public void render(Game g, Graphics2D g2d) {
		if(location != null) location.render(g, g2d);
		if(person != null) person.render(g, g2d);
	}
}
