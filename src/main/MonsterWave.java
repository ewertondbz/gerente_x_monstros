package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MonsterWave {

	private static final int MAX_NUMBER_OF_MONSTERS_MINUS_ONE = 6;
	private final static long MAX_TICKS_TO_GENERATE_A_MONSTER = 50;
	private final static long MIN_TICKS_TO_GENERATE_A_MONSTER = 15;
	private final int NUMBER;
	private final int NUMBER_OF_MONSTERS;
	private Set<Monster> monsters = new HashSet<Monster>();
	private List<Long> timesToGenerateAMonster = new ArrayList<Long>();
	private long ticks = 0;

	public MonsterWave(int number) {
		this.NUMBER = number;
		this.NUMBER_OF_MONSTERS = number * MAX_NUMBER_OF_MONSTERS_MINUS_ONE;
		for (int i = 0; i < NUMBER_OF_MONSTERS; i++) {
			timesToGenerateAMonster.add((long) (Math.random() * (MAX_TICKS_TO_GENERATE_A_MONSTER - MIN_TICKS_TO_GENERATE_A_MONSTER)) + MIN_TICKS_TO_GENERATE_A_MONSTER);
		}
	}

	private void generateMonster() {
		Monster monster = MonsterFactory.createMonster(1, NUMBER);
		monster.init();
		monsters.add(monster);
	}

	public void update(long deltaTicks) {
		if (!timesToGenerateAMonster.isEmpty()) {
			ticks += deltaTicks;
			long time = timesToGenerateAMonster.get(0);
			if (ticks >= time) {
				ticks -= time;
				generateMonster();
				timesToGenerateAMonster.remove(0);
			}
		}
		for (Monster monster : monsters)
			monster.update();
	}

	public synchronized boolean isFinished() {
		return monsters.isEmpty();
	}

	public int getNumber() {
		return NUMBER;
	}

	public void init() {
		generateMonster();
	}

}
