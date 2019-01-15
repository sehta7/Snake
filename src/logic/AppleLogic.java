package logic;

import java.util.concurrent.ThreadLocalRandom;

import model.Apple;

public class AppleLogic {

	private Apple apple;
	
	public AppleLogic(Apple apple) {
		this.apple = apple;
	}
	
	public void newApple() {
		int x = ThreadLocalRandom.current().nextInt(10, 780);
		if (x % 10 != 0) {
			x -= x % 10;
			apple.setX(x);
		} else {
			apple.setX(x);
		}
		int y = ThreadLocalRandom.current().nextInt(10, 500);
		if (y % 10 != 0) {
			y -= y % 10;
			apple.setY(y);
		} else {
			apple.setY(y);
		}
	}
}
