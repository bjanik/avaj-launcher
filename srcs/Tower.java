import java.utils.List;

public class Tower {
	
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		this.observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		this.observers.remove(flyable);
	}
}
