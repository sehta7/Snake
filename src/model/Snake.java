package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import logic.Logic;

public class Snake {

	private Point position;
	private int width;
	private int height;
	private List<Point> cells;
	
	public Snake() {
		this.width = 10;
		this.height = 10;
		position = new Point();
		cells = new ArrayList<>();
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public List<Point> getCells() {
		return cells;
	}

	public void setCells(List<Point> cells) {
		this.cells = cells;
	}
	
	public void move(int lastPress) {
		Logic.move(lastPress, this);
	}
	
	public void grow(int lastPress) {
		Logic.grow(lastPress, this);
	}

}
