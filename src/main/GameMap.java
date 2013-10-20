package main;

import java.util.HashSet;
import java.util.Set;

public class GameMap {

	private Set<ControlComponent> controlComponents = new HashSet<ControlComponent>();

	public GameMap() {
		controlComponents.add(new MonsterWaveControl());
		controlComponents.add(new TurretControl());
		controlComponents.add(SelectionControl.getInstance());
	}

	public void init() {
		for (ControlComponent controlComponent : controlComponents)
			controlComponent.init();
	}

	public void update(long deltaTicks) {
		for (ControlComponent controlComponent : controlComponents)
			controlComponent.update(deltaTicks);
	}

}
