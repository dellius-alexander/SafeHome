package com.example.safehome.Wall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Coordinates {
    private static final Logger log = LoggerFactory.getLogger(Coordinates.class);
    Integer x;
    Integer y;

    /**
     * Defines a coordinate system.
     * @param x x coordinate
     * @param y y coordinate
     */
    public Coordinates(Integer x, Integer y) {
        try {
            if (x == null|| y == null){
                throw new IllegalStateException("Parameter \"x and y\" are required.");
            }
            this.x = x;
            this.y = y;
            log.info("{}",this);
        } catch (Exception e){
            log.error("{}", e);
        }

    }

    /**
     * Get the x coordinate.
     * @return the x coordinate
     */
    public Integer getX() {
        return x;
    }

    /**
     * Set the x coordinate
     * @param x the x coordinate
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * Get the y coordinate
     * @return the y coordinate
     */
    public Integer getY() {
        return y;
    }
    /**
     * Set the y coordinate
     * @param y the y coordinate
     */
    public void setY(Integer y) {
        this.y = y;
    }



}
