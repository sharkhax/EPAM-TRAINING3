package com.drobot.day3.entity;

import com.drobot.day3.exception.BasketException;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Ball> ballList = new ArrayList<>();
    private final double capacity;

    public Basket(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public List<Ball> getBallList() {
        return ballList;
    }

    public boolean addBall(Ball... ball) throws BasketException {
        int ballCounter = 0;
        double ballSize;
        double vacantCapacity = calculateVacantCapacity();

        for (Ball i : ball) {
            ballCounter++;
            ballSize = i.calculateBallSize();

            if (doesBallFitBasket(ballSize, vacantCapacity)) {
                ballList.add(i);
                vacantCapacity = vacantCapacity - ballSize;

            } else {
                throw new BasketException("Ball number "
                        + ballCounter + " was not added: no capacity");
            }
        }

        return true;
    }
    
    public double calculateVacantCapacity() {
        double vacantCapacity = capacity;

        for (Ball ball : ballList) {
            vacantCapacity = vacantCapacity - ball.calculateBallSize();
        }

        return vacantCapacity;
    }

    private boolean doesBallFitBasket(double ballSize, double vacantCapacity) {
        return (vacantCapacity >= ballSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Basket basket = (Basket) o;

        if (Double.compare(basket.capacity, capacity) != 0) {
            return false;
        }

        return ballList.equals(basket.ballList);
    }

    @Override
    public int hashCode() {
        int result = ballList.hashCode();
        long temp = Double.doubleToLongBits(capacity);

        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");

        sb.append("ballList=").append(ballList);
        sb.append(", capacity=").append(capacity);
        sb.append('}');
        return sb.toString();
    }
}
