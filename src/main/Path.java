package main;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Path {

	private List<Point> path = new ArrayList<Point>();
	public List<Rectangle> rectanglePath = new ArrayList<Rectangle>();

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
		ListIterator<Point> iterator = path.listIterator();
		while (iterator.hasNext()) {
			Point p = iterator.next();
			if (iterator.hasNext()) {
				Point p2 = iterator.next();
				rectanglePath.add(createRectangle(p, p2));
				iterator.previous();
			}
		}
	}

	private Rectangle createRectangle(Point p, Point p2) {
		Point upperLeftCorner = p.x < p2.x ? p : (p.x == p2.x ? (p.y > p2.y ? p2 : p) : p2);
		return new Rectangle(upperLeftCorner.x, upperLeftCorner.y + 7, Math.abs(p2.x - p.x) + 24, Math.abs(p2.y - p.y) + 24);
	}

	public static Path getInstance() {
		return instance;
	}

	public List<Point> getPointsList() {
		return new ArrayList<Point>(path);
	}

	public boolean intersects(Rectangle rectangle) {
		for (Rectangle r : rectanglePath)
			if (rectangle.intersects(r))
				return true;
		return false;
	}

}
