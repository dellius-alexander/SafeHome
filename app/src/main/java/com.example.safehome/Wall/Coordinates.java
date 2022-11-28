package com.example.safehome.Wall;

public class Coordinates {
    int x;
    int y;

    /**
     * Defines a coordinate system.
     * @param x x coordinate
     * @param y y coordinate
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate.
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x coordinate
     * @param x the x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the y coordinate
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }
    /**
     * Set the y coordinate
     * @param y the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }



}
