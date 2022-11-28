package com.example.safehome.Wall

import org.slf4j.LoggerFactory

class Window(private val type: String, dimensions: List<Coordinates>?) : Segment<Coordinates> {
    private var dimensions: MutableList<Coordinates>? = null

    /**
     * Creates a window segments.
     * @param type the type of window
     * @param dimensions a list of dimension for the window
     */
    init {
        this.dimensions!!.addAll(dimensions!!)
    }

    /**
     * The type of segment this segment represents. Type refers to the
     * makeup of the wall segment. I.e. wood, stone, concrete, or sheetrock.
     *
     * @return the segment type
     */
    override fun type(): String? {
        return type
    }

    /**
     * Renders the segment described by the implementation of this class.
     */
    override fun draw() {
        // TODO: implement a draw function for the window segment on the display canvas
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
        private val log = LoggerFactory.getLogger(Window::class.java)
    }
}