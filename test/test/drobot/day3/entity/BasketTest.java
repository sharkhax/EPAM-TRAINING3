package test.drobot.day3.entity;

import com.drobot.day3.entity.Ball;
import com.drobot.day3.entity.Basket;
import com.drobot.day3.exception.BasketException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketTest {

    @Test
    public void addBall_True() {
        Ball ball1 = new Ball(50, 1, 0.2);
        Ball ball2 = new Ball(30, 1, 0.5);
        Ball ball3 = new Ball(40, 1, 0.1);

        Basket basket = new Basket(29);

        boolean condition = false;

        try {
            condition = basket.addBall(ball1, ball2, ball3);
        } catch (BasketException e) {
            fail(e.getMessage());
        }

        assertTrue(condition);
    }

    @Test(expectedExceptions = BasketException.class)
    public void addBall_Exception() throws BasketException {
        Ball ball1 = new Ball(50, 1, 0.2);
        Ball ball2 = new Ball(30, 1, 0.5);
        Ball ball3 = new Ball(40, 1, 0.1);

        Basket basket = new Basket(28);

        basket.addBall(ball1, ball2, ball3);
    }

    @Test
    public void calculateVacantCapacity_True() {
        Ball ball1 = new Ball(50, 1, 0.2);
        Ball ball2 = new Ball(30, 1, 0.5);
        Ball ball3 = new Ball(40, 1, 0.1);

        Basket basket = new Basket(30);

        try {
            basket.addBall(ball1, ball2, ball3);
        } catch (BasketException e) {
            fail(e.getMessage());
        }

        double actual = basket.calculateVacantCapacity();
        double expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    public void calculateVacantCapacity_False() {
        Ball ball1 = new Ball(50, 1, 0.2);
        Ball ball2 = new Ball(30, 1, 0.5);
        Ball ball3 = new Ball(40, 1, 0.1);

        Basket basket = new Basket(30);

        try {
            basket.addBall(ball1, ball2, ball3);
        } catch (BasketException e) {
            fail(e.getMessage());
        }

        double actual = basket.calculateVacantCapacity();
        double expected = 10;

        assertNotEquals(actual, expected);
    }
}
