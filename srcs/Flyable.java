

public interface Flyable {

	void updateConditions();
	void registerTower(WeatherTower weatherTower);
	void land();
}