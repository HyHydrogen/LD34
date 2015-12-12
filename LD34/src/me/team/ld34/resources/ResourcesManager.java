package me.team.ld34.resources;

import me.team.ld34.core.Game;

public class ResourcesManager {
	private Resource	units;
	private Resource	power;

	private int timer;

	public ResourcesManager() {
		this.timer = 0;

		this.units = new Resource("Units", 10000, 10);
		this.power = new Resource("Power", 150, 0);
	}

	public void tick() {
		if (timer % Game.TICK_RATE == 0) {
			units.tick();
			power.tick();
		}
	}

	public Resource getUnits() {
		return units;
	}

	public Resource getEnergy() {
		return power;
	}

}
