package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import model.Apple;
import model.Snake;

public class Logic {
	
	public static void move(int lastPress, Snake snake) {
		List<Point> tempCells = new ArrayList<>();
		tempCells.clear();
		tempCells.addAll(snake.getCells());
		snake.getCells().clear();
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
		default:
			snake.setY(tempCells.get(0).y - snake.getWidth());
			snake.getCells().add(new Point(snake.getX(), snake.getY()));
			break;
		}
		if(tempCells.size() > 1) {
			for (int i = 0; i <= tempCells.size() - 2; i++) {
				snake.getCells().add(tempCells.get(i));
			}
		}
	}

	public static boolean collision(Apple apple, Snake snake) {
		if (apple.getX() == snake.getCells().get(0).x && apple.getY() == snake.getCells().get(0).y) {
			return true;
		}
		return false;
	}
	
	public static void grow(int lastPress, Snake snake) {
		buttonPress(lastPress, snake);
	}
	
	private static void buttonPress(int lastPress, Snake snake) {
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
	
	public static boolean end(Snake snake) {
		if(snake.getCells().get(0).x == 0 || snake.getCells().get(0).x == 770 ||
			snake.getCells().get(0).y == 0 || snake.getCells().get(0).y == 510) {
			return true;
		}
		for (int i = 1; i < snake.getCells().size(); i++) {
			if(snake.getCells().get(0).x == snake.getCells().get(i).x && snake.getCells().get(0).y == snake.getCells().get(i).y) {
				return true;
			}
		}
		return false;
	}

	public static void apple(Apple apple) {
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
