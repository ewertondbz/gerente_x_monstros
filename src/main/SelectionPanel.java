package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SelectionPanel extends JPanel {

	private static final long serialVersionUID = -4217370914065178386L;
	private static final int WIDTH = 24, HEIGHT = 24;

	@Override
	public void paint(Graphics g) {
		update(g);
	}

	@Override
	public void update(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	public void select(Point locationOnScreen) {
		locationOnScreen.y -= 24;
		if (locationIsValid(adjust(locationOnScreen)))
			setLocation(adjust(locationOnScreen));
	}

	private boolean locationIsValid(Point point) {
		return !Path.getInstance().intersects(new Rectangle(point.x, point.y, WIDTH, HEIGHT)) && point.x <= 576;
	}

	public void init() {
		Game.getInstance().getGameWindow().add(this);
		setSize(WIDTH, HEIGHT);
	}

	private Point adjust(Point point) {
		return new Point((point.x / WIDTH) * WIDTH, (point.y / HEIGHT) * HEIGHT);
	}

	public void allowAddTurret() {
		addMouseListener((new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO continua daqui
			}
		}));
	}
}
