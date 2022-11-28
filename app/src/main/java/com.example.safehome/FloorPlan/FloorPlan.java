package com.example.safehome.FloorPlan;

import com.example.safehome.Wall.Coordinates;

import java.util.Map;

public class FloorPlan implements FPlan{
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
