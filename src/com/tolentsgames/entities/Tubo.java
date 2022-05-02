package com.tolentsgames.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.tolentsgames.main.Game;

public class Tubo extends Entity {
	
	private boolean gotPoint = false;
	
	public Tubo(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		x--;
		if((x + width) <= (Game.WIDTH/2 - 30))
			if(!gotPoint) {
				Game.score += 0.5;
				gotPoint = true;
			}
		
		if((x + width) <= 0) {
			//System.out.println("Tubo Destruido");
			Game.entities.remove(this);
			return;			
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, this.getX(), this.getY(), width, height, null);
		}
}
