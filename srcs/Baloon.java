

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates){
		this.super(name, coordinates);
		this.weatherTower.put("FOG", "Holy crap I can't see anything!");
		this.weatherTower.put("RAIN", "Damn it! Forgot my umbrella!");
		this.weatherTower.put("SNOW", "I'm freezing like dull boy Jack!");
		this.weatherTower.put("SUN", "It's getting hot in here!");
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
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}