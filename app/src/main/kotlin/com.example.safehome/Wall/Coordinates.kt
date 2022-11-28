package com.example.safehome.Wall

import org.slf4j.LoggerFactory
import java.lang.Exception

class Coordinates(x: Int?, y: Int?) {
    /**
     * Get the x coordinate.
     * @return the x coordinate
     */
    /**
     * Set the x coordinate
     * @param x the x coordinate
     */
    var x: Int? = null
    /**
     * Get the y coordinate
     * @return the y coordinate
     */
    /**
     * Set the y coordinate
     * @param y the y coordinate
     */
    var y: Int? = null

    /**
     * Defines a coordinate system.
     * @param x x coordinate
     * @param y y coordinate
     */
    init {
        try {
            check(!(x == null || y == null)) { "Parameter \"x and y\" are required." }
            this.x = x
            this.y = y
            log.info("{}", this)
        } catch (e: Exception) {
            log.error("{}", e)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(Coordinates::class.java)
    }
}