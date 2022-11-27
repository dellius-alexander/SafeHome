package com.example.safehome.Wall;

/**
 * Defines a segment of a wall represented by a coordinate system marking the start
 * coordinate and ending coordinates of the segment. A segment can contain a wall
 * segment, a window, door or any object that is part of a wall in the 2D coordinate
 * system.
 * @param <Object> represent type of segment implemented by this class.
 */
public interface Segment<Object> {
    /**
     * The type of segment this segment represents.
     * @return the segment type
     */
    String type();

    /**
     * Renders the segment described by the implementation of this class.
     */
    void draw();


}
