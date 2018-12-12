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
	private Timer appleTimer = new Timer(10000, this);
	private int lastPress;
	private Color color = Color.BLUE;
	
	public Panel() {
		timer.start();
		appleTimer.start();
		snake = new Snake();
		snake.setX(350);
		snake.setY(230);
		apple = new Apple();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(color);
		g.fillRect(snake.getX(), snake.getY(), snake.getWidth(), snake.getHeight());
		//g.fillRect(xSnake, ySnake, width, height);
		
		g.setColor(Color.RED);
		g.fillOval(apple.getX(), apple.getY(), apple.getDiameter(), apple.getDiameter());

	}
	
	public void collision() {
		if(apple.getX() == snake.getX() && apple.getY() == snake.getY()) {
			grow();
		}
	}
	
	public void grow() {
		color = Color.GREEN;
	}
	
	public void apple() {
		Random random = new Random();
		int x = random.nextInt(800);
		if(x%10 != 0) {
			System.out.println(x);
			x -= x%10;
			apple.setX(x);
		} else {
			apple.setX(x);
		}
		int y = random.nextInt(550);
		if(y%10 != 0) {
			y -= y%10;
			apple.setY(y);
		} else {
			apple.setY(y);
		}
	}

	public void right() {
		snake.setX(snake.getX() + snake.getWidth());
		lastPress = 39;
		repaint();
	}

	public void left() {
		snake.setX(snake.getX() - snake.getWidth());
		lastPress = 37;
		repaint();
	}

	public void up() {
		snake.setY(snake.getY() + snake.getWidth());
		lastPress = 40;
		repaint();
	}

	public void down() {
		snake.setY(snake.getY() - snake.getWidth());
		lastPress = 38;
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			switch (lastPress) {
			case 37:
				snake.setX(snake.getX() - snake.getWidth());
				collision();
				break;
			case 38:
				snake.setY(snake.getY() - snake.getWidth());
				collision();
				break;
			case 39:
				snake.setX(snake.getX() + snake.getWidth());
				collision();
				break;
			case 40:
				snake.setY(snake.getY() + snake.getWidth());
				collision();
				break;
			default:
				snake.setY(snake.getY() - snake.getWidth());
				collision();
				break;
			}
		    repaint();
	    }
		if(e.getSource() == appleTimer){
			apple();
		}
		
	}

}
