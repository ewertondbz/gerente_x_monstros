package main;

public class GameMap {

	private MonsterWaveControl monsterWaveControl = new MonsterWaveControl();

	public void init() {
		monsterWaveControl.init();
	}

	public void update(long ticks) {
		monsterWaveControl.update(ticks);
	}

}
