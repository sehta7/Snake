package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Apple;
import model.Snake;

public class Panel extends JPanel implements ActionListener {

	private Apple apple;
	private Snake snake;
	private Timer timer = new Timer(200, this);
	private int lastPress;
	private Color color = Color.BLUE;
	private List<Point> tempCells;

	public Panel() {
		timer.start();
		snake = new Snake();
		snake.setX(350);
		snake.setY(230);
		apple = new Apple();
		snake.getCells().add(new Point(snake.getX(), snake.getY()));
		tempCells = new ArrayList<>();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(color);
		for (Point point : snake.getCells()) {
			g.fillRect((int) point.getX(), (int) point.getY(), snake.getWidth(), snake.getHeight());
		}

		g.setColor(Color.RED);
		g.fillOval(apple.getX(), apple.getY(), apple.getDiameter(), apple.getDiameter());

	}

	public boolean collision() {
		if (apple.getX() == snake.getCells().get(0).x && apple.getY() == snake.getCells().get(0).y) {
			return true;
		}
		return false;
	}

	public void grow() {
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

	public void apple() {
		int x = ThreadLocalRandom.current().nextInt(10, 790);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			if(collision()) {
				grow();
				apple();
			}
			move();
		}
	}
	
	public void move() {
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
		repaint();
	}
	

	public void right() {
		lastPress = 39;
		repaint();
	}

	public void left() {
		lastPress = 37;
		repaint();
	}

	public void up() {
		lastPress = 40;
		repaint();
	}

	public void down() {
		lastPress = 38;
		repaint();
	}

}
