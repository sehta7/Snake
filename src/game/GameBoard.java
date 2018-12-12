package game;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import graphics.Panel;

public class GameBoard {

	private JFrame frame;
	private Panel panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameBoard window = new GameBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GameBoard() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Panel();
		
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				switch (keyCode) {
				case 37:
					panel.left();
					break;
				case 40:
					panel.up();
					break;
				case 39:
					panel.right();
					break;
				case 38:
					panel.down();
					break;
				default:
					break;
				}
				
			}
		});

		frame.add(panel);
		frame.setVisible(true);
	}

}
