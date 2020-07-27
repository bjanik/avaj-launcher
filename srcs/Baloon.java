

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates){
		this.super(name, coordinates);
	}

	public void updateConditions() {}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}