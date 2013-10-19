package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel {

	private static final long serialVersionUID = 3325101737095522920L;
	private BufferedImage image;

	@Override
	public void paint(Graphics g) {
		update(g);
	}

	@Override
	public void update(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}

	public void init() {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/fundo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setBounds(0, 0, image.getWidth(), image.getHeight());
		Game.getInstance().getGameWindow().add(this);
		repaint();
	}

}
