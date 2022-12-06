package com.example.safehome.FloorPlan


import com.example.safehome.Wall.Coordinates
import com.example.safehome.Wall.Wall
import com.example.safehome.FloorPlan.FPlan
import org.slf4j.Logger

import org.slf4j.LoggerFactory

class FloorPlan(
        private val type: FType?,
        private val name: String?,
        private val dimensions: String?,
        private val walls: Map<Coordinates, Wall>?
) : FPlan {

    override fun type(): FType? {
        return type
    }

    /**
     * Returns a map of coordinates and their corresponding wall segment.
     *
     * @return a map of wall segments
     */
    override fun walls(): Map<Coordinates, Wall>? {
        return null
    }

    /**
     * Defines the demensions of the floor plan.
     *
     * @return
     */
    override fun dimensions(): String? {
        return null
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(FloorPlan::class.java)
    }
}