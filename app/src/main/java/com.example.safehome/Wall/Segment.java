package com.example.safehome.Wall;

import java.util.List;

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

    /**
     * The dimension of the segment. Dimensions are defined as the vertical and
     * horizontal coordinates of the segment.
     * @param dimensions the dimensions of the segment.
     */
    void setDimensions(List<Coordinates> dimensions);

    /**
     * The start coordinates of the segment.
     * @return the start coordinates of the segment
     */
    Coordinates getStartCoordinates();

    /**
     * Set the start coordinates for the segment.
     * @param startCoordinates the start coordinates
     */
    void setStartCoordinates(Coordinates startCoordinates);

    /**
     * The stop coordinates of the segment.
     * @return the stop coordinates of the segment
     */
    Coordinates getStopCoordinates();

    /**
     * Set the stop coordinates for the segment.
     * @param stopCoordinates the stop coordinates
     */
    void setStopCoordinates(Coordinates stopCoordinates);


}
