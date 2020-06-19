package com.drobot.day3.entity;

public class Ball {

    private static final String[] COLOR_LIST = {"BLUE", "PURPLE", "GREEN"};

    private final double density;
    private final double weight;
    private final int colorCode;

    public Ball(double weight, int colorCode, double density) {
        this.weight = weight;
        this.colorCode = colorCode;
        this.density = density;
    }

    public double getWeight() {
        return weight;
    }

    public int getColorCode() {
        return colorCode;
    }

    public String getStringColor() {
        return COLOR_LIST[colorCode];
    }

    public double getDensity() {
        return density;
    }

    public double calculateBallSize() {
        return (weight * density);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ball ball = (Ball) o;

        if (Double.compare(ball.density, density) != 0) {
            return false;
        }

        if (Double.compare(ball.weight, weight) != 0) {
            return false;
        }
        return colorCode == ball.colorCode;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(density);
        int result = (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(weight);

        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + colorCode;

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");

        sb.append("density=").append(density);
        sb.append(", weight=").append(weight);
        sb.append(", colorCode=").append(colorCode);
        sb.append('}');
        return sb.toString();
    }
}
