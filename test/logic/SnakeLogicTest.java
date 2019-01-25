package logic;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Apple;
import model.Snake;

class SnakeLogicTest {

	Snake snake;
	SnakeLogic snakeLogic;
	
	@BeforeEach
	void setUp() throws Exception {
		snake = new Snake();
		snakeLogic = new SnakeLogic(snake);
		
	}

	@Test
	void afterMoveSnakeShouldChangePosition() {
		//given
		int lastPress = 38;
		int yPositionBefore = snake.getY();
		
		//when
		snakeLogic.move(lastPress);
		
		//then
		assertNotSame(yPositionBefore, snake.getY());
	}
	
	@Test
	void samePositionOfAppleAndSnakeShouldMakeCollision() {
		//given
		Apple apple = new Apple();
		apple.setPosition(new Point(100, 100));
		snake.setHead(new Point(100, 100));
		
		//when
		boolean collision = snakeLogic.checkCollision(apple);
		
		//then
		assertTrue(collision);
	}

}
