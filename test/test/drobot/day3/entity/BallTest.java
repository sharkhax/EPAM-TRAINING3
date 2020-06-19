package test.drobot.day3.entity;

import com.drobot.day3.entity.Ball;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallTest {

    @Test
    public void calculateBallSize_True() {
        Ball ball = new Ball(50, 0, 0.2);

        double actual = ball.calculateBallSize();
        double expected = 10;

        assertEquals(actual, expected);
    }

    @Test
    public void calculateBallSize_False() {
        Ball ball = new Ball(50, 0, 0.2);

        double actual = ball.calculateBallSize();
        double expected = 11;

        assertNotEquals(actual, expected);
    }
}
