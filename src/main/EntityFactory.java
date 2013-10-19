package main;

public class EntityFactory {

	public static Entity createDeath() {
		Animation animation = new Animation(144, 128); // sprite da morte
		Entity death = new Entity(animation);
		return death;
	}
}
