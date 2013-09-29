package main;

public class Entity {

	private Animation animation;
	private Brain brain = new Brain();

	public Entity(Animation animation) {
		this.animation = animation;
	}

	public void init() {
		animation.init();
		Game.getInstance().getGameWindow().add(animation);
		animation.repaint();
	}

	public void update() {
		brain.update();
		animation.setLocation(brain.getCurrentPosition());
		animation.setState(brain.getMovingState());
		if (brain.getMovingState() != MovingState.STANDING)
			animation.advanceFrame();
		animation.repaint();
	}

}
