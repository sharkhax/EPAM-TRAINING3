package com.drobot.day3.service;

import com.drobot.day3.entity.Ball;
import com.drobot.day3.entity.Basket;

import java.util.List;

public class BallService {

    public double calculateTotalWeight(Basket basket) {
        List<Ball> ballList = basket.getBallList();
        double totalWeight = 0;

        for (Ball i : ballList) {
            totalWeight += i.getWeight();
        }

        return totalWeight;
    }

    public int countBallsByColor(Basket basket, int colorCode) {
        int counter = 0;
        List<Ball> ballList = basket.getBallList();

        for (Ball currentBall : ballList) {
            if (doesBallHaveColor(currentBall, colorCode)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean doesBallHaveColor(Ball ball, int colorCode) {
        return (ball.getColorCode() == colorCode);
    }
}
