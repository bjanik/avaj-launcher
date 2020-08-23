import java.util.List;
import java.util.ArrayList;

public class Tower {
	
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (this.observers.contains(flyable) == false)
			this.observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		this.observers.remove(flyable);
	}

	protected void conditionsChanged() {
		for (Flyable obs: observers) {
			obs.updateConditions();
		}
	}
}
