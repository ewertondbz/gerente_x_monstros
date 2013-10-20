package main;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Path {

	private List<Point> path = new ArrayList<Point>();

	private static Path instance = new Path();

	private Path() {
		path.add(new Point(0, 480));
		path.add(new Point(490, 480));
		path.add(new Point(490, 180));
		path.add(new Point(290, 180));
		path.add(new Point(290, 280));
		path.add(new Point(90, 280));
		path.add(new Point(90, 80));
		path.add(new Point(600, 80));
	}

	public static Path getInstance() {
		return instance;
	}

	public List<Point> getPointsList() {
		return new ArrayList<Point>(path);
	}

	public boolean intersects(Rectangle rectangle) {
		// TODO
		return true;
	}

}
