package fr.bjanik.avaj_launcher.Aircrafts;

import fr.bjanik.avaj_launcher.Simulation.Simulation;

import java.util.HashMap;

public class Aircraft {

	private static long idCounter = 0;
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected HashMap<String, String> weatherMap = new HashMap<String, String>();

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = this.nextId();
	}

	private long nextId() {
		this.idCounter += 1;
		return idCounter;
	}

	protected void land(){
		Simulation.writer.println(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") landing.");
		Simulation.writer.println("Tower says: " + this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") unregistered from weather tower.");
	}
}