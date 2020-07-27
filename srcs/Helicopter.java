

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates){
		this.super(name, coordinates);
	}

	public void updateConditions() {}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}