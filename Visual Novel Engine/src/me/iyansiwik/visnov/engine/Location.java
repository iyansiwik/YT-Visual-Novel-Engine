package me.iyansiwik.visnov.engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Location {
	
	private BufferedImage image;
	
	public Location(String filePath) {
		try {
			image = ImageIO.read(new File("res/"+filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void update(Game g) {
		
	}
	
	public void render(Game g, Graphics2D g2d) {
		g2d.drawImage(image, 0, 0, null);
	}
}
