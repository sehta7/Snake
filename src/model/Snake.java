package model;

public class Snake {

	private int x;
	private int y;
	private int width;
	private int height;
	
	public Snake() {
		this.width = 10;
		this.height = 10;
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
}