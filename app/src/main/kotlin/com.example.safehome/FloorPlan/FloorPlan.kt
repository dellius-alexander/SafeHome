package com.example.safehome.FloorPlan


import com.example.safehome.Wall.Coordinates
import com.example.safehome.Wall.Wall
import com.example.safehome.FloorPlan.FPlan

import org.slf4j.LoggerFactory

class FloorPlan : FPlan {
    private val type: FType? = null
    private val name: String? = null
    private val dimensions: String? = null
    private val walls: Map<Coordinates, Wall>? = null
    fun type(): FType? {
        return type
    }

    /**
     * Returns a map of coordinates and their corresponding wall segment.
     *
     * @return a map of wall segments
     */
    fun <Coordinates, Wall> walls(): Map<Coordinates, Wall>? {
        return null
    }

    /**
     * Defines the demensions of the floor plan.
     *
     * @return
     */
    fun dimensions(): String? {
        return null
    }

    companion object {
        private val log = LoggerFactory.getLogger(FloorPlan::class.java)
    }
}