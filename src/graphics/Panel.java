package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener{

	private int xPosition = 345, yPosition = 220;
	private int xSnake = xPosition, ySnake = yPosition;
	private int width = 10, height = 10;
	private Color color = Color.BLUE;
	private Timer timer = new Timer(500, this);
	
	public Panel() {
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(color);
		g.fillRect(xPosition, yPosition, width, height);

		//g.fillRect(xSnake, ySnake, width, height);

	}

	public void right() {
		repaint();
	}

	public void left() {
		repaint();
	}

	public void up() {
		repaint();
	}

	public void down() {
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			yPosition -= 10;
			ySnake = yPosition;
			height += 10;
		    repaint();
	    }
		
	}

}
