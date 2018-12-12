package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener{

	private int xPosition = 345, yPosition = 220;
	private int xSnake = xPosition, ySnake = yPosition;
	private int xApple, yApple, diameter = 10;
	private int width = 10, height = 10;
	private Color color = Color.BLUE;
	private Timer timer = new Timer(500, this);
	private Timer appleTimer = new Timer(5000, this);
	private int lastPress;
	
	public Panel() {
		timer.start();
		appleTimer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(color);
		g.fillRect(xPosition, yPosition, width, height);

		//g.fillRect(xSnake, ySnake, width, height);
		
		g.setColor(Color.RED);
		g.fillOval(xApple, yApple, diameter, diameter);

	}
	
	public void apple() {
		Random random = new Random();
		xApple = random.nextInt(800);
		yApple = random.nextInt(550);
	}

	public void right() {
		xPosition += 10;
		lastPress = 39;
		repaint();
	}

	public void left() {
		xPosition -= 10;
		lastPress = 37;
		repaint();
	}

	public void up() {
		yPosition += 10;
		lastPress = 40;
		repaint();
	}

	public void down() {
		yPosition -= 10;
		lastPress = 38;
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			switch (lastPress) {
			case 37:
				xPosition -= 10;
				ySnake = yPosition;
				break;
			case 38:
				yPosition -= 10;
				ySnake = yPosition;
				break;
			case 39:
				xPosition += 10;
				ySnake = yPosition;
				break;
			case 40:
				yPosition += 10;
				ySnake = yPosition;
				break;
			default:
				yPosition -= 10;
				ySnake = yPosition;
				break;
			}
		    repaint();
	    }
		if(e.getSource() == appleTimer){
			apple();
		}
		
	}

}
