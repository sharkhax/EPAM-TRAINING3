package com.drobot.day3.entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Ball> ballList = new ArrayList<>();

    private double initialCapacity;
    private double vacantCapacity;

    public Basket(double initialCapacity) {
        this.initialCapacity = initialCapacity;
        vacantCapacity = initialCapacity;
    }

    public double getInitialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(double initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public double getVacantCapacity() {
        return vacantCapacity;
    }

    public void setVacantCapacity(double vacantCapacity) {
        this.vacantCapacity = vacantCapacity;
    }

    public List<Ball> getBallList() {
        return ballList;
    }

    public void addBall(Ball ball) {
        ballList.add(ball);
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

        if (Double.compare(basket.initialCapacity, initialCapacity) != 0) {
            return false;
        }

        if (Double.compare(basket.vacantCapacity, vacantCapacity) != 0) {
            return false;
        }

        return ballList.equals(basket.ballList);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ballList.hashCode();

        temp = Double.doubleToLongBits(initialCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(vacantCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");

        sb.append("balls=").append(ballList.size());
        sb.append(", initial capacity=").append(initialCapacity);
        sb.append(", vacant capacity=").append(vacantCapacity);
        sb.append('}');

        return sb.toString();
    }
}
