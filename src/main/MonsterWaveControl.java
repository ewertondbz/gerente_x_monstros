package main;

public class MonsterWaveControl {

	private static final int NUMBER_OF_WAVES = 4;
	private MonsterWave currentMonsterWave;

	public MonsterWaveControl() {
		currentMonsterWave = new MonsterWave(1);
	}

	public void init() {
		currentMonsterWave.init();
	}

	public void update(long ticks) {
		currentMonsterWave.update(ticks);
		if (currentMonsterWave.isFinished()) {
			if (currentMonsterWave.getNumber() < NUMBER_OF_WAVES) {
				currentMonsterWave = new MonsterWave(currentMonsterWave.getNumber() + 1);
				currentMonsterWave.init();
			} else {
				Game.getInstance().notifyFinish();
			}
		}
	}

}
