package com.example.safehome.Wall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    private static final Logger log = LoggerFactory.getLogger(Wall.class);
    private String type;
    private List<Coordinates> wallDimensions = new ArrayList<>();
    private List<Window> listOfWindows = new ArrayList<>();
    private List<WallSegment> listOfWallSegments = new ArrayList<>();

    public Wall(String type, List<Coordinates> wallDimensions, List<Window> listOfWindows, List<WallSegment> listOfWallSegments){
        this.type = type;
        this.wallDimensions.addAll(wallDimensions);
        this.listOfWindows.addAll(listOfWindows);
        this.listOfWallSegments.addAll(listOfWallSegments);
    }

    /**
     * The type of wall composition.
     * @param type the type of wall composition
     */
    public void type(String type){
        this.type = type;
    }

    /**
     * Computes the dimensions of the wall using the wall dimensions and coordinates system.
     * @return the computed dimensions to draw.
     */
    public String computeDimensions(){
        try {
            // TODO: must implement this method to compute wall dimensions
            return null;
        } catch (Exception e) {
            log.error("{}", e);
        }
        return null;
    }

    /**
     * Adds a wall segment to the wall
     * @param wallSegment the wall segment added to the wall
     * @return true if successful, false otherwise
     */
    public boolean addWallSegment(WallSegment wallSegment){
        try {
            this.listOfWallSegments.add(wallSegment);
            return true;
        } catch (Exception e) {
            log.error("{}", e);
        }
        return false;
    }

    /**
     * Adds a window to the wall
     * @param window the window to add to the wall
     * @return true if successful, false otherwise
     */
    public boolean addWindow(Window window){
        try {
            this.listOfWindows.add(window);
            return true;
        } catch (Exception e) {
            log.error("{}", e);
        }
        return false;
    }
}
