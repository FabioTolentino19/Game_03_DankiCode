package com.tolentsgames.entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.tolentsgames.main.Game;
import com.tolentsgames.world.World;

public class Player extends Entity {
	
	public boolean isPressed = false;
	
	
	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}
	
		
	public void tick() {
		depth = 2;
		if(!isPressed) {
			y += 1;
		} else {
			y -= 1;
		}
		
		if(y > Game.HEIGHT || y < 0) {
			World.restartGame();
			return;
		}
		
		//Testar colisão
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e != this) {
				if(Entity.isColidding(this, e)) {
					// Game Over
					World.restartGame();
					return;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(!isPressed) {
			g2.rotate(Math.toRadians(45), this.getX() + width/2, this.getY() + height/2);
			super.render(g);
			g2.rotate(Math.toRadians(-45), this.getX() + width/2, this.getY() + height/2);
		} else {
//			g2.rotate(Math.toRadians(-45), this.getX() + width/2, this.getY() + height/2);
			super.render(g);
//			g2.rotate(Math.toRadians(45), this.getX() + width/2, this.getY() + height/2);
		}
	}
}
	
