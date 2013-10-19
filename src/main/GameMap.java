package main;

public class GameMap {

	private Background background = new Background();
	private Entity monster = EntityFactory.createDeath();

	public void init() {
		monster.init();
		background.init();
	}

	public void update() {
		monster.update();
	}

}
