package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Animation extends JPanel {

	private static final long serialVersionUID = 3325101737095522920L;
	private BufferedImage image;
	private static final int WIDTH = 24, HEIGHT = 32, MAX_FRAMES = 3;
	private MovingState state = MovingState.DOWN;
	private Rectangle frameRectangle = new Rectangle();
	private int currentFrame = 0;

	public Animation(int baseX, int baseY) {
		frameRectangle.setBounds(baseX, baseY, WIDTH, HEIGHT);
	}

	@Override
	public void paint(Graphics g) {
		update(g);
	}

	@Override
	public void update(Graphics g) {
		int dx1 = 0;
		int dy1 = 0;
		int dx2 = WIDTH;
		int dy2 = HEIGHT;
		int sx1 = (int) frameRectangle.getX() + currentFrame * WIDTH;
		int sy1 = (int) frameRectangle.getY() + HEIGHT * state.ordinal();
		int sx2 = (int) frameRectangle.getX() + (currentFrame + 1) * WIDTH;
		int sy2 = (int) frameRectangle.getY() + HEIGHT * (state.ordinal() + 1);
		g.drawImage(image, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
	}

	public void init() {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Monster.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setBounds(0, 0, WIDTH, HEIGHT);
	}

	public void advanceFrame() {
		currentFrame = (currentFrame + 1) % MAX_FRAMES;
	}

	public void setState(MovingState state) {
		if (state == MovingState.STOPPED) {
			currentFrame = 0;
		} else if (this.state != state) {
			this.state = state;
			currentFrame = 0;
		}
	}
}
