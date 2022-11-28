package com.example.safehome.Wall;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Window implements Segment<Coordinates>{
    private static final Logger log = LoggerFactory.getLogger(Window.class);
    private String type;
    private List<Coordinates> dimensions;

    /**
     * Creates a window segments.
     * @param type the type of window
     * @param dimensions a list of dimension for the window
     */
    public Window(String type, List<Coordinates> dimensions) {
        this.type = type;
        this.dimensions.addAll(dimensions);
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
        // TODO: implement a draw function for the window segment on the display canvas
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


}
