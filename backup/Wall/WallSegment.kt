package com.example.safehome.Wall


import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.ArrayList

/**
 * Creates a wall segment using the coordinates to place the segment on the canvas.
 */
class WallSegment(
    color: String,
    type: String,
    startCoordinate: Coordinates,
    stopCoordinate: Coordinates
) : Segment<Coordinates> {
    /**
     * Get the color of the wall segment.
     * @return the color of the wall segment
     */
    /**
     * Set the color fo the wall segment.
     * @param color the color of the wall segment
     */
    var color: String
    private var dimensions: MutableList<Coordinates>?
    private val type: String

    /**
     * Creates a wall segment.
     * @param color the color of the wall segment
     * @param type the type of wall segment. I.e, sheetrock, concrete, wood, etc.
     * @param startCoordinate the start coordinate
     * @param stopCoordinate the stop coordinate
     */
    init {
        dimensions = ArrayList<Coordinates>()
        (dimensions as ArrayList<Coordinates>).add(startCoordinate)
        (dimensions as ArrayList<Coordinates>).add(stopCoordinate)
        this.color = color
        this.type = type
        log.info(this.toString())
    }

    /**
     * The type of segment this segment represents. Type refers to the
     * makeup of the wall segment. I.e. wood, stone, concrete, or sheetrock.
     *
     * @return the segment type
     */
    override fun type(): String {
        return type
    }

    /**
     * Renders the segment described by the implementation of this class.
     */
    override fun draw() {
        // TODO: implement a draw function for the wall segment on the display canvas
    }

    /**
     * The dimension of the segment. Dimensions are defined as the vertical and
     * horizontal coordinates of the segment.
     *
     * @param dimensions the dimensions of the segment.
     */
    override fun setDimensions(dimensions: MutableList<Coordinates>?) {
        this.dimensions = dimensions
    }
    /**
     * The start coordinates of the segment.
     *
     * @return the start coordinates of the segment
     */




    /**
     * The start coordinates of the segment.
     * @return the start coordinates of the segment
     */
    override fun getStartCoordinates():Coordinates? {return this.dimensions?.get(0)
    }

    /**
     * Set the start coordinates for the segment.
     * @param startCoordinates the start coordinates
     */
    override fun setStartCoordinates(startCoordinates:Coordinates?) {this.dimensions?.add(0, startCoordinates!!)
    }



    /**
     * The start coordinates of the segment.
     * @return the start coordinates of the segment
     */
    override fun getStopCoordinates():Coordinates? {return this.dimensions?.get(1)
    }

    /**
     * Set the start coordinates for the segment.
     * @param startCoordinates the start coordinates
     */
    override fun setStopCoordinates(stopCoordinates:Coordinates?) {this.dimensions?.add(1, stopCoordinates!!)
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(WallSegment::class.java)
    }



}