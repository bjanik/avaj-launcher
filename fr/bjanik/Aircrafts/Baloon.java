package fr.bjanik.avaj_launcher.Aircrafts;

import fr.bjanik.avaj_launcher.Interface.Flyable;
import fr.bjanik.avaj_launcher.Tower.WeatherTower;
import fr.bjanik.avaj_launcher.Simulation.Simulation;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates){
		super(name, coordinates);
		this.weatherMap.put("FOG", "Holy crap I can't see anything!");
		this.weatherMap.put("RAIN", "Damn it! Forgot my umbrella!");
		this.weatherMap.put("SNOW", "I'm freezing like dull boy Jack!");
		this.weatherMap.put("SUN", "It's getting hot in this baloon!");
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch(weather)
		{
			case "FOG":
				this.coordinates.setHeight(this.coordinates.getHeight() - 3);
				break;
			case "RAIN":
				this.coordinates.setHeight(this.coordinates.getHeight() - 5);
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 15);
				break;
			case "SUN":
				this.coordinates.setHeight(this.coordinates.getHeight() + 4);
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
				break;
		}
		Simulation.writer.println(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + "): " + this.weatherMap.get(weather));
		if (this.coordinates.getHeight() == 0)
			this.land();
	}

	public void land() {
		super.land();
		this.weatherTower.unregister(this);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Simulation.writer.println("Tower says: " + this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}