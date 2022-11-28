package com.example.safehome.Wall;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates a wall segment using the coordinates to place the segment on the canvas.
 */
public class WallSegment implements Segment<Coordinates>{
    private static final Logger log = LoggerFactory.getLogger(WallSegment.class);
    private String color;
    private List<Coordinates> dimensions;
    private String type;

    /**
     * Creates a wall segment.
     * @param color the color of the wall segment
     * @param type the type of wall segment. I.e, sheetrock, concrete, wood, etc.
     * @param startCoordinate the start coordinate
     * @param stopCoordinate the stop coordinate
     */
    public WallSegment(
            String color,
            String type,
            Coordinates startCoordinate,
            Coordinates stopCoordinate){
        this.dimensions = new ArrayList<>();
        this.dimensions.add(startCoordinate);
        this.dimensions.add(stopCoordinate);
        this.color = color;
        this.type = type;
        log.info(this.toString());
    }

    /**
     * The type of segment this segment represents. Type refers to the
     * makeup of the wall segment. I.e. wood, stone, concrete, or sheetrock.
     *
     * @return the segment type
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Renders the segment described by the implementation of this class.
     */
    @Override
    public void draw() {
        // TODO: implement a draw function for the wall segment on the display canvas
    }

    /**
     * The dimension of the segment. Dimensions are defined as the vertical and
     * horizontal coordinates of the segment.
     *
     * @param dimensions the dimensions of the segment.
     */
    @Override
    public void setDimensions(List<Coordinates> dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * The start coordinates of the segment.
     *
     * @return the start coordinates of the segment
     */
    @Override
    public Coordinates getStartCoordinates() {
        return this.dimensions.get(0);
    }

    /**
     * Set the start coordinates for the segment.
     *
     * @param startCoordinates the start coordinates
     */
    @Override
    public void setStartCoordinates(Coordinates startCoordinates) {
        this.dimensions.set(0, startCoordinates);
    }

    /**
     * The stop coordinates of the segment.
     *
     * @return the stop coordinates of the segment
     */
    @Override
    public Coordinates getStopCoordinates() {
        return this.dimensions.get(1);
    }

    /**
     * Set the stop coordinates for the segment.
     *
     * @param stopCoordinates the stop coordinates
     */
    @Override
    public void setStopCoordinates(Coordinates stopCoordinates) {
        this.dimensions.set(1, stopCoordinates);
    }

    /**
     * Get the color of the wall segment.
     * @return the color of the wall segment
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Set the color fo the wall segment.
     * @param color the color of the wall segment
     */
    public void setColor(String color) {
        this.color = color;
    }
}
