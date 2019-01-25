package logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Snake;

class SnakeLogicTest {

	Snake snake;
	
	@BeforeEach
	void setUp() throws Exception {
		snake = new Snake();
	}

	@Test
	void afterMoveSnakeShouldChangePosition() {
		//given
		int lastPress = 38;
		int yPositionBefore = snake.getY();
		
		//when
		snake.move(lastPress);
		
		//then
		assertNotSame(yPositionBefore, snake.getY());
	}

}
