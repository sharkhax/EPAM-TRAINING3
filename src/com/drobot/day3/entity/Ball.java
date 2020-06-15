package com.drobot.day3.entity;

public class Ball {

    private static final String[] COLOR_LIST = {"BLUE", "PURPLE", "GREEN"};
    private static final double WEIGHT_TO_SIZE_RATIO = 0.2;

    private double weight;
    private int colorCode;

    public Ball(double weight, int color) {
        this.weight = weight;
        this.colorCode = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public String getStringColor() {
        return COLOR_LIST[colorCode];
    }

    public double getWeightToSizeRatio() {
        return WEIGHT_TO_SIZE_RATIO;
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

        if (Double.compare(ball.weight, weight) != 0) {
            return false;
        }

        return colorCode == ball.colorCode;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;

        temp = Double.doubleToLongBits(weight);
        result = (int) (temp ^ (temp >>> 32));

        result = 31 * result + colorCode;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");

        sb.append("weight=").append(weight);
        sb.append(", color=").append(colorCode);
        sb.append('}');

        return sb.toString();
    }
}
