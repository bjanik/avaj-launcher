package fr.bjanik.avaj_launcher.Tower;

import fr.bjanik.avaj_launcher.Aircrafts.Coordinates;
import fr.bjanik.avaj_launcher.WeatherProvider.WeatherProvider;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	public void changeWeather() {
		this.conditionsChanged();
	}
}