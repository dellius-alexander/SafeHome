package com.example.safehome.FloorPlan

import com.example.safehome.Wall.Coordinates
import com.example.safehome.Wall.Wall

interface FPlan {

    fun type(): FType?

    /**
     * Returns a map of coordinates and their corresponding wall segment.
     * @param <Coordinates> the coordinates for the wall segment
     * @param <Wall> the wall segment
     * @return a map of wall segments
    </Wall></Coordinates> */
    fun  walls(): Map<Coordinates, Wall>?

    /**
     * Defines the dimensions of the floor plan.
     * @return
     */
    fun dimensions(): String?
}