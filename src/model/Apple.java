package model;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

import logic.Logic;

public class Apple {

	private Point position;
	private int diameter;
	
	public Apple() {
		this.diameter = 10;
		position = new Point();
		int x = ThreadLocalRandom.current().nextInt(10, 780);
		if (x % 10 != 0) {
			x -= x % 10;
			this.position.x = x;
		} else {
			this.position.x = x;
		}
		int y = ThreadLocalRandom.current().nextInt(10, 500);
		if (y % 10 != 0) {
			y -= y % 10;
			this.position.y = y;
		} else {
			this.position.y = y;
		}
	}
	
	public int getX() {
		return position.x;
	}
	
	public void setX(int x) {
		this.position.x = x;
	}
	
	public int getY() {
		return position.y;
	}
	
	public void setY(int y) {
		this.position.y = y;
	}

	public int getDiameter() {
		return diameter;
	}
	
	public void newApple() {
		Logic.newApple(this);
	}
	
}
