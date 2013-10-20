package main;

import java.awt.Rectangle;

public class Monster {

	private Animation animation;
	private Brain brain = new Brain();
	private Rectangle rectangle = new Rectangle();

	public Monster(Animation animation) {
		this.animation = animation;
	}

	public void init() {
		animation.init();
		Game.getInstance().getGameWindow().add(animation);
		animation.repaint();
	}

	public void update() {
		brain.update();
		rectangle.setLocation(brain.getCurrentPosition());
		animation.setLocation(brain.getCurrentPosition());
		animation.setState(brain.getMovingState());
		if (brain.getMovingState() != MovingState.STANDING)
			animation.advanceFrame();
		animation.repaint();
	}

}
