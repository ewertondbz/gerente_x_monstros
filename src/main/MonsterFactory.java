package main;

public class MonsterFactory {

	public static Monster createMonster(int i, int number) {
		int monsterIndex = (int) (Math.random() * number) + i;
		return createMonster(monsterIndex);
	}

	private static Monster createMonster(int monsterIndex) {
		switch (monsterIndex) {
		case 1:
			return createDeath();
		case 2:
			return createSkeleton();
		case 3:
			return createPhantom();
		case 4:
			return createZombie();
			// case 5:
			// return null;
			// case 6:
			// return null;
		default:
			return null;
		}
	}

	private static Monster createDeath() {
		return new Monster(new Animation(144, 128));
	}

	private static Monster createSkeleton() {
		return new Monster(new Animation(0, 128));
	}

	private static Monster createPhantom() {
		return new Monster(new Animation(216, 0));
	}

	private static Monster createZombie() {
		return new Monster(new Animation(72, 128));
	}
}
