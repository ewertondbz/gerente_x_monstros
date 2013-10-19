package main;

public enum MovingState {

	UP(0, -1), RIGHT(1, 0), DOWN(0, 1), LEFT(-1, 0), STANDING(0, 0);

	private int x, y;

	private MovingState(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
