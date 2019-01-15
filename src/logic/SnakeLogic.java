package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import model.Apple;
import model.Snake;

public class SnakeLogic {
	
	Snake snake;
	
	public SnakeLogic(Snake snake) {
		this.snake = snake;
	}
	
	public void move(int lastPress) {
		choseMoveDirection(lastPress, snake);
	}

	private static void choseMoveDirection(int lastPress, Snake snake) {
		List<Point> tempCells = createTempCells(snake);
		setSnakeEntry(lastPress, snake, tempCells);
		resetCells(tempCells, snake);
	}

	private static List<Point> createTempCells(Snake snake) {
		List<Point> tempCells = new ArrayList<>();
		tempCells.clear();
		tempCells.addAll(snake.getCells());
		snake.getCells().clear();
		return tempCells;
	}

	private static void setSnakeEntry(int lastPress, Snake snake, List<Point> tempCells) {
		switch (lastPress) {
		case 37:
			snake.setX(tempCells.get(0).x - snake.getWidth());
			snake.getCells().add(new Point(snake.getX(), snake.getY()));
			break;
		case 38:
			snake.setY(tempCells.get(0).y - snake.getWidth());
			snake.getCells().add(new Point(snake.getX(), snake.getY()));
			break;
		case 39:
			snake.setX(tempCells.get(0).x + snake.getWidth());
			snake.getCells().add(new Point(snake.getX(), snake.getY()));
			break;
		case 40:
			snake.setY(tempCells.get(0).y + snake.getWidth());
			snake.getCells().add(new Point(snake.getX(), snake.getY()));
			break;
		}
	}
	
	private static void resetCells(List<Point> cells, Snake snake) {
		if(cells.size() > 1) {
			for (int i = 0; i <= cells.size() - 2; i++) {
				snake.getCells().add(cells.get(i));
			}
		}
	}

	public boolean checkCollision(Apple apple) {
		if (apple.getX() == snake.getCells().get(0).x && apple.getY() == snake.getCells().get(0).y) {
			return true;
		}
		return false;
	}
	
	public void grow(int lastPress) {
		choseGrowthDirection(lastPress, snake);
	}
	
	private static void choseGrowthDirection(int lastPress, Snake snake) {
		switch (lastPress) {
		case 37:
			snake.setX(snake.getCells().get(snake.getCells().size() - 1).x + snake.getWidth());
			snake.getCells().add(new Point(snake.getX(), snake.getY()));
			break;
		case 38:
			snake.setY(snake.getCells().get(snake.getCells().size() - 1).y + snake.getWidth());
			snake.getCells().add(new Point(snake.getX(), snake.getY()));
			break;
		case 39:
			snake.setX(snake.getCells().get(snake.getCells().size() - 1).x - snake.getWidth());
			snake.getCells().add(new Point(snake.getX(), snake.getY()));
			break;
		case 40:
			snake.setY(snake.getCells().get(snake.getCells().size() - 1).y - snake.getWidth());
			snake.getCells().add(new Point(snake.getX(), snake.getY()));
			break;
		default:
			snake.setY(snake.getCells().get(snake.getCells().size() - 1).y + snake.getWidth());
			snake.getCells().add(new Point(snake.getX(), snake.getY()));
			break;
		}
	}
	
	public boolean checkGameOver() {
		if(snake.getCells().get(0).x == 0 || snake.getCells().get(0).x == 770 ||
		   snake.getCells().get(0).y == 0 || snake.getCells().get(0).y == 510) {
				return true;
			}
			for (int i = 1; i < snake.getCells().size(); i++) {
				if(snake.getCells().get(0).x == snake.getCells().get(i).x &&
				   snake.getCells().get(0).y == snake.getCells().get(i).y) {
					return true;
				}
			}
			return false;
	}
}
