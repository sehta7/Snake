package logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;

import model.Apple;

class AppleLogicTest {

	@RepeatedTest(5)
	void applePositionShouldBeInsideBoard() {
		//given
		Apple apple = new Apple();
		AppleLogic appleLogic = new AppleLogic(apple);
		
		//when
		appleLogic.newApple();
		
		//then
		assertTrue(apple.getX() >= 10 && apple.getX() <= 780);
		assertTrue(apple.getY() >= 10 && apple.getY() <= 500);
	}

}
