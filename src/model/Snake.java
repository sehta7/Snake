package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {

	private int x;
	private int y;
	private int width;
	private int height;
	private List<Point> cells;
	
	public Snake() {
		this.width = 10;
		this.height = 10;
		cells = new ArrayList<>();
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

}
