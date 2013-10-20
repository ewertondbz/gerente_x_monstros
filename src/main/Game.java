package main;

public class Game {

	private static Game instance = new Game();
	private GameWindow gameWindow;
	private GameMap gameMap = new GameMap();
	private boolean finished = false;

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
		gameWindow.show();
	}

	public void start() {
		new Thread() {
			public void run() {
				long time = System.currentTimeMillis();
				while (!finished) {
					long currentTime = System.currentTimeMillis();
					long deltaTime = currentTime - time;
					if (deltaTime > 100) {
						gameMap.update(millisecondsToTicks(deltaTime));
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

	private long millisecondsToTicks(long time) {
		return time / 100; // 1 segundo vai ser igual a 10 ticks
	}

	public void notifyFinish() {
		// TODO Auto-generated method stub
		finished = true;
	}

}
