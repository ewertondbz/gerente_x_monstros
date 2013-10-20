package main;

import java.util.HashSet;
import java.util.Set;

public class TurretControl implements ControlComponent {

	private Set<Turret> turrets = new HashSet<Turret>();

	public void update(long deltaTicks) {
		for (Turret turret : turrets) {
			turret.update(deltaTicks);
		}
	}

	public void init() {
		// TODO Auto-generated method stub
	}

	public void addTurret(Turret turret) {
		Game.getInstance().getGameWindow().notifyAddTurret(turret);
	}

}
