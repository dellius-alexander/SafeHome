package com.example.safehome.Wall


import org.slf4j.LoggerFactory
import java.lang.Exception
import java.util.ArrayList

class Wall(
    private var type: String,
    wallDimensions: List<Coordinates>?,
    listOfWindows: List<Window>?,
    listOfWallSegments: List<WallSegment>?
) {
    private val wallDimensions: MutableList<Coordinates> = ArrayList()
    private val listOfWindows: MutableList<Window> = ArrayList()
    private val listOfWallSegments: MutableList<WallSegment> = ArrayList()

    init {
        this.wallDimensions.addAll(wallDimensions!!)
        this.listOfWindows.addAll(listOfWindows!!)
        this.listOfWallSegments.addAll(listOfWallSegments!!)
    }

    /**
     * The type of wall composition.
     * @param type the type of wall composition
     */
    fun type(type: String) {
        this.type = type
    }

    /**
     * Computes the dimensions of the wall using the wall dimensions and coordinates system.
     * @return the computed dimensions to draw.
     */
    fun computeDimensions(): String? {
        try {
            // TODO: must implement this method to compute wall dimensions
            return null
        } catch (e: Exception) {
            log.error("{}", e)
        }
        return null
    }

    /**
     * Adds a wall segment to the wall
     * @param wallSegment the wall segment added to the wall
     * @return true if successful, false otherwise
     */
    fun addWallSegment(wallSegment: WallSegment): Boolean {
        try {
            listOfWallSegments.add(wallSegment)
            return true
        } catch (e: Exception) {
            log.error("{}", e)
        }
        return false
    }

    /**
     * Adds a window to the wall
     * @param window the window to add to the wall
     * @return true if successful, false otherwise
     */
    fun addWindow(window: Window): Boolean {
        try {
            listOfWindows.add(window)
            return true
        } catch (e: Exception) {
            log.error("{}", e)
        }
        return false
    }

    companion object {
        private val log = LoggerFactory.getLogger(Wall::class.java)
    }
}