package model;

import java.util.concurrent.ThreadLocalRandom;

public class Apple {

	private int x;
	private int y;
	private int diameter;
	
	public Apple() {
		this.diameter = 10;
		int x = ThreadLocalRandom.current().nextInt(10, 780);
		if (x % 10 != 0) {
			x -= x % 10;
			this.x = x;
		} else {
			this.x = x;
		}
		int y = ThreadLocalRandom.current().nextInt(10, 500);
		if (y % 10 != 0) {
			y -= y % 10;
			this.y = y;
		} else {
			this.y = y;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getDiameter() {
		return diameter;
	}
	
}
