package fr.bjanik.avaj_launcher.Interface;

import fr.bjanik.avaj_launcher.Tower.WeatherTower;

public interface Flyable {

	void updateConditions();
	void registerTower(WeatherTower weatherTower);
	void land();
}