package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import logic.SnakeLogic;

public class Snake {

	private Point position;
	private int width;
	private int height;
	private List<Point> cells;
	private SnakeLogic logic;
	
	public Snake() {
		this.width = 10;
		this.height = 10;
		position = new Point(350, 230);
		cells = new ArrayList<>();
		logic = new SnakeLogic(this);
		getCells().add(new Point(getX(), getY()));
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
		logic.move(lastPress);
	}
	
	public void grow(int lastPress) {
		logic.grow(lastPress);
	}
	
	public boolean collision(Apple apple) {
		return logic.checkCollision(apple);
	}
	
	public boolean gameOver() {
		return logic.checkGameOver();
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	public Point getHead() {
		return new Point(getCells().get(0).x, getCells().get(0).y);
	}
	
	public void setHead(Point position) {
		getCells().set(0, position);
	}

}
