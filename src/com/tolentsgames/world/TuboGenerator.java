package com.tolentsgames.world;

import com.tolentsgames.entities.Entity;
import com.tolentsgames.entities.Tubo;
import com.tolentsgames.main.Game;

public class TuboGenerator {
	
	public int time = 0;
	public int targetTime = 60;
	
	public void tick() {
		time++;
		if(time == targetTime) {
			// criar tubo e resetar contador
			int altura1 = Entity.rand.nextInt(50 - 30) + 30;
			Tubo tubo1 = new Tubo(Game.WIDTH, 0, 20, altura1, 1, Game.spritesheet.getSprite(32, 32, 16, 16));
			
			Game.entities.add(tubo1);
			
			int altura2 = Entity.rand.nextInt(50 - 30) + 30;
			Tubo tubo2 = new Tubo(Game.WIDTH, Game.HEIGHT - altura2, 20, altura2, 1, Game.spritesheet.getSprite(48, 32, 16, 16));
			
			Game.entities.add(tubo2);
			time = 0;
		}
	}

}
