package com.example.safehome.FloorPlan

interface FPlan {

    fun <FType> type(): FType

    /**
     * Returns a map of coordinates and their corresponding wall segment.
     * @param <Coordinates> the coordinates for the wall segment
     * @param <Wall> the wall segment
     * @return a map of wall segments
    </Wall></Coordinates> */
    fun <Coordinates, Wall> walls(): Map<Coordinates, Wall>?

    /**
     * Defines the dimensions of the floor plan.
     * @return
     */
    fun dimensions(): String?
}