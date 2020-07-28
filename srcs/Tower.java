import java.utils.List;

public class Tower {
	
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		this.observers.add(flyable);
		System.out.println("Tower says: " + flyable.getClass().getName() + "#" + flyable.name + "(" + flyable.id + ") registered to weather tower.");
	}

	public void unregister(Flyable flyable) {
		this.observers.remove(flyable);
		System.out.println("Tower says: " + flyable.getClass().getName() + "#" + flyable.name + "(" + flyable.id + ") unregistered to weather tower.");
	}

	protected void conditionsChanged() {
		for (Flyable obs: observers) {
			obs.updateCondtions();
		}
	}
}
