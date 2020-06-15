package test.drobot.day3.service;

import com.drobot.day3.entity.Ball;
import com.drobot.day3.entity.Basket;
import com.drobot.day3.service.BallService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallServiceTest {

    BallService ballService;

    @BeforeTest
    public void setUp() {
        ballService = new BallService();
    }

    @Test
    public void calculateTotalWeight_True() {
        Basket basket = new Basket(5000);
        Ball ball1 = new Ball(50, 2);
        Ball ball2 = new Ball(35, 2);

        try {
            ballService.addBall(basket, ball1, ball2);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        double actual = ballService.calculateTotalWeight(basket);
        double expected = 85;

        assertEquals(actual, expected);
    }

    @Test
    public void calculateTotalWeight_False() {
        Basket basket = new Basket(5000);
        Ball ball1 = new Ball(50, 2);
        Ball ball2 = new Ball(35, 2);

        try {
            ballService.addBall(basket, ball1, ball2);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        double actual = ballService.calculateTotalWeight(basket);
        double expected = 50;

        assertNotEquals(actual, expected);
    }

    @Test
    public void addBall_True() {
        Ball ball1 = new Ball(50, 1);
        Ball ball2 = new Ball(50, 1);
        Ball ball3 = new Ball(50, 1);


        Basket basket = new Basket(30);

        boolean condition = false;

        try {
            condition = ballService.addBall(basket, ball1, ball2, ball3);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertTrue(condition);
    }

    @Test(expectedExceptions = Exception.class)
    public void addBall_Exception() throws Exception {
        Ball ball1 = new Ball(50, 1);
        Ball ball2 = new Ball(50, 1);
        Ball ball3 = new Ball(50, 1);
        Basket basket = new Basket(29);

        ballService.addBall(basket, ball1, ball2, ball3);
    }

    @Test
    public void countBallsByColor_True() {
        Ball ball1 = new Ball(50, 0);
        Ball ball2 = new Ball(50, 1);
        Ball ball3 = new Ball(50, 2);
        Ball ball4 = new Ball(50, 0);

        Basket basket = new Basket(99999);

        try {
            ballService.addBall(basket, ball1, ball2, ball3, ball4);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        int actual = ballService.countBallsByColor(basket, 0);
        int expected = 2;

        assertEquals(actual, expected);
    }

    @Test
    public void countBallsByColor_False() {
        Ball ball1 = new Ball(50, 0);
        Ball ball2 = new Ball(50, 1);
        Ball ball3 = new Ball(50, 2);
        Ball ball4 = new Ball(50, 0);

        Basket basket = new Basket(99999);

        try {
            ballService.addBall(basket, ball1, ball2, ball3, ball4);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        int actual = ballService.countBallsByColor(basket, 0);
        int expected = 1;

        assertNotEquals(actual, expected);
    }
}
