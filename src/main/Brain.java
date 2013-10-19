package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Brain {

	private List<Point> path = new ArrayList<Point>();
	private Point currentPosition = new Point(-20, 480);
	private static int ADVANCE = 3;
	private MovingState state = MovingState.DOWN;

	public Brain() {
		path.add(new Point(490, 480));
		path.add(new Point(490, 180));
		path.add(new Point(290, 180));
		path.add(new Point(290, 280));
		path.add(new Point(90, 280));
		path.add(new Point(90, 80));
		path.add(new Point(600, 80));
		updateMovingState(path.get(0));
	}

	public Point getCurrentPosition() {
		return currentPosition;
	}

	public MovingState getMovingState() {
		return state;
	}

	private void updateMovingState(Point point) {
		if (currentPosition.x != point.x && currentPosition.y == point.y) {
			if (point.x - currentPosition.x > 0) {
				state = MovingState.RIGHT;
			} else {
				state = MovingState.LEFT;
			}
		} else if (currentPosition.x == point.x && currentPosition.y != point.y) {
			if (point.y - currentPosition.y > 0) {
				state = MovingState.DOWN;
			} else {
				state = MovingState.UP;
			}
		}
	}

	public void update() {
		if (path.isEmpty()) {
			state = MovingState.STANDING;
		} else {
			walk();
		}
	}

	private void walk() {
		updateMovingState(path.get(0));
		currentPosition.translate(state.getX() * ADVANCE, state.getY() * ADVANCE);
		adjustIfOutOfPath(path.get(0));
		if (currentPosition.equals(path.get(0))) {
			System.out.println(path.get(0));
			path.remove(0);
		}
	}

	private void adjustIfOutOfPath(Point point) {
		switch (state) {
		case LEFT:
			if (currentPosition.x < point.x) {
				currentPosition.x = point.x;
			}
			break;
		case RIGHT:
			if (currentPosition.x > point.x) {
				currentPosition.x = point.x;
			}
			break;
		case UP:
			if (currentPosition.y < point.y) {
				currentPosition.y = point.y;
			}
			break;
		case DOWN:
			if (currentPosition.y > point.y) {
				currentPosition.y = point.y;
			}
			break;
		default:
			break;
		}
	}
}
