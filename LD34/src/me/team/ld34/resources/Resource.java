package me.team.ld34.resources;

public class Resource {

	private String	name;
	private int		amount;
	private int		passiveGain;

	public Resource(String name, int amount, int passiveGain) {
		this.name = name;
		this.amount = amount;
		this.passiveGain = passiveGain;
	}

	public void tick() {
		amount += passiveGain;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setPassiveGain(int passiveGain) {
		this.passiveGain = passiveGain;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public int getPassiveGain() {
		return passiveGain;
	}

}
