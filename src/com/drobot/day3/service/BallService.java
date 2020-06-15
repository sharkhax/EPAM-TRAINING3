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

    public boolean addBall(Basket basket, Ball... ball) throws Exception {
        int ballCounter = 0;

        for (Ball i: ball) {
            ballCounter++;

            double ballWeight = i.getWeight();
            double ballRatio = i.getWeightToSizeRatio();
            double ballSize = calculateBallSize(ballWeight, ballRatio);
            double vacantCapacity = basket.getVacantCapacity();

            if (doesBallFitBasket(ballSize, vacantCapacity)) {
                basket.addBall(i);

                vacantCapacity = vacantCapacity - ballSize;
                basket.setVacantCapacity(vacantCapacity);

            } else throw new Exception("Ball number "
                    + ballCounter + " was not added: no capacity");
        }

        return true;
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

    private double calculateBallSize(double ballWeight, double ratio) {
        return (ballWeight * ratio);
    }

    private boolean doesBallFitBasket(double ballSize, double vacantCapacity) {
        return (vacantCapacity >= ballSize);
    }
}
