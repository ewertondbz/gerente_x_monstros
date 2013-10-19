package main;

public class Game {

	private static Game instance = new Game();
	private GameWindow gameWindow;
	private GameMap gameMap = new GameMap();

	// private Entity zombie;
	// private Animation animation;

	public static Game getInstance() {
		return instance;
	}

	public GameWindow getGameWindow() {
		return gameWindow;
	}

	public void init() {
		gameWindow = new GameWindow();
		gameWindow.init();
		gameMap.init();
	}

	public void start() {
		new Thread() {
			public void run() {
				long time = System.currentTimeMillis();
				while (true) {
					long currentTime = System.currentTimeMillis();
					if (currentTime - time > 100) {
						gameMap.update();
						time = currentTime;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.run();
	}

}
