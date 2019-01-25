package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Apple;
import model.Snake;

public class Panel extends JPanel implements ActionListener {

	private Apple apple;
	private Snake snake;
	private Timer timer = new Timer(200, this);
	private int lastPress = 38;
	private Color color = Color.BLUE;

	public Panel() {
		timer.start();
		snake = new Snake();
		apple = new Apple();
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

		if(snake.gameOver()) {
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", 300, 250);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			if(snake.collision(apple)) {
				snake.grow(lastPress);
				apple.newApple();
			}
			if(snake.gameOver()) {   
				repaint();
			} else {
				snake.move(lastPress);
				repaint();
			}
		}
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
