import java.util.Map;
import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
		this.weatherMap.put("FOG", "Holy crap I can't see anything!");
		this.weatherMap.put("RAIN", "Damn it! Forgot my umbrella!");
		this.weatherMap.put("SNOW", "I'm freezing like dull boy Jack!");
		this.weatherMap.put("SUN", "It's getting hot in this Helicopter!");
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch(weather)
		{
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				break;
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				break;
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				break;
		}
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
		System.out.println("Tower says: " + this.getClass().getName() + "#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}