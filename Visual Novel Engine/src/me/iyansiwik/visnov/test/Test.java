package me.iyansiwik.visnov.test;

import me.iyansiwik.visnov.engine.Game;
import me.iyansiwik.visnov.engine.Location;
import me.iyansiwik.visnov.engine.Person;
import me.iyansiwik.visnov.engine.gamestates.GSPlay;
import me.iyansiwik.visnov.engine.gamestates.GameState;

public class Test extends Game {

	private GameState gs_play;
	
	private Location location;
	private Person person;
	
	public Test() {
		super("Test Game", 1280, 720, 1);
	}
	
	public void init() {
		location = new Location("location.png");
		person = new Person("person.png");
		
		gs_play = new GSPlay(location, person);
		
		setGameState(gs_play);
	}
	
	public void update() {
		
	}
	
	public static void main(String[] args) {
		Game game = new Test();
		game.start();
	}
}
