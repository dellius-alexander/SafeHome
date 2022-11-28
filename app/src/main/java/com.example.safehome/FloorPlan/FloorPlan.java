package com.example.safehome.FloorPlan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.safehome.Wall.Coordinates;
import com.example.safehome.Wall.Wall;

import java.util.Map;

public class FloorPlan implements FPlan{
    private static final Logger log = LoggerFactory.getLogger(FloorPlan.class);
    private FType type;
    private String name;
    private String dimensions;
    private Map<Coordinates, Wall> walls;
    @Override
    public FType type() {
        return this.type;
    }

    /**
     * Returns a map of coordinates and their corresponding wall segment.
     *
     * @return a map of wall segments
     */
    @Override
    public <Coordinates, Wall> Map<Coordinates, Wall> walls() {
        return null;
    }

    /**
     * Defines the demensions of the floor plan.
     *
     * @return
     */
    @Override
    public String dimensions() {
        return null;
    }
}
