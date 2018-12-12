package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Apple;
import model.Snake;

public class Panel extends JPanel implements ActionListener{

	private Apple apple;
	private Snake snake;
	private Timer timer = new Timer(500, this);
	private Timer appleTimer = new Timer(5000, this);
	private int lastPress;
	
	public Panel() {
		timer.start();
		appleTimer.start();
		snake = new Snake();
		snake.setX(345);
		snake.setY(220);
		apple = new Apple();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLUE);
		g.fillRect(snake.getX(), snake.getY(), snake.getWidth(), snake.getHeight());

		//g.fillRect(xSnake, ySnake, width, height);
		
		g.setColor(Color.RED);
		g.fillOval(apple.getX(), apple.getY(), apple.getDiameter(), apple.getDiameter());

	}
	
	public void apple() {
		Random random = new Random();
		apple.setX(random.nextInt(800));
		apple.setY(random.nextInt(550));
	}

	public void right() {
		snake.setX(snake.getX() + 10);
		lastPress = 39;
		repaint();
	}

	public void left() {
		snake.setX(snake.getX() - 10);
		lastPress = 37;
		repaint();
	}

	public void up() {
		snake.setY(snake.getY() + 10);
		lastPress = 40;
		repaint();
	}

	public void down() {
		snake.setY(snake.getY() - 10);
		lastPress = 38;
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			switch (lastPress) {
			case 37:
				snake.setX(snake.getX() - 10);
				break;
			case 38:
				snake.setY(snake.getY() - 10);
				break;
			case 39:
				snake.setX(snake.getX() + 10);
				break;
			case 40:
				snake.setY(snake.getY() + 10);
				break;
			default:
				snake.setY(snake.getY() - 10);
				break;
			}
		    repaint();
	    }
		if(e.getSource() == appleTimer){
			apple();
		}
		
	}

}
