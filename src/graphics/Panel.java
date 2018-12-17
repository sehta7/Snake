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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import logic.Logic;
import model.Apple;
import model.Snake;

public class Panel extends JPanel implements ActionListener {

	private Apple apple;
	private Snake snake;
	private Timer timer = new Timer(200, this);
	private int lastPress;
	private Color color = Color.BLUE;

	public Panel() {
		timer.start();
		snake = new Snake();
		snake.setX(350);
		snake.setY(230);
		apple = new Apple();
		snake.getCells().add(new Point(snake.getX(), snake.getY()));
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

		if(Logic.end(snake)) {
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", 300, 250);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			if(Logic.collision(apple, snake)) {
				Logic.grow(lastPress, snake);
				Logic.apple(apple);
			}
			if(Logic.end(snake)) {   
				
			} else {
				Logic.move(lastPress, snake);
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
