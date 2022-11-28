package com.example.safehome.Wall;

import java.util.List;

/**
 * Defines a segment of a wall represented by a coordinate system marking the start
 * coordinate and ending coordinates of the segment. A segment can contain a wall
 * segment, a window, door or any object that is part of a wall in the 2D coordinate
 * system.
 * @param <Coordinates> represent coordinates system for the segment.
 */
public interface Segment<Coordinates> {
    /**
     * The type of segment this segment represents.
     * @return the segment type
     */
    fun type(): String?

    /**
     * Renders the segment described by the implementation of this class.
     */
    fun draw()

    /**
     * The dimension of the segment. Dimensions are defined as the vertical and
     * horizontal coordinates of the segment.
     * @param dimensions the dimensions of the segment.
     */
    fun setDimensions(dimensions : MutableList<Coordinates>?)

    /**
     * The start coordinates of the segment.
     * @return the start coordinates of the segment
     */
    fun getStartCoordinates():Coordinates?

    /**
     * Set the start coordinates for the segment.
     * @param startCoordinates the start coordinates
     */
    fun setStartCoordinates(startCoordinates:Coordinates?);

    /**
     * The stop coordinates of the segment.
     * @return the stop coordinates of the segment
     */
    fun getStopCoordinates() :Coordinates?

    /**
     * Set the stop coordinates for the segment.
     * @param stopCoordinates the stop coordinates
     */
    fun setStopCoordinates(stopCoordinates:Coordinates?);

}
