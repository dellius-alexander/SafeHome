package com.example.safehome.Wall

import com.example.safehome.Door.DType
import com.example.safehome.Door.Door
import com.example.safehome.Door.OpenDoor
import com.example.safehome.Door.BiFoldDoor
import com.example.safehome.Door.DoubleDoor
import com.example.safehome.Door.PocketDoor
import com.example.safehome.Door.SingleDoor
import com.example.safehome.AbstractFactory
import com.example.safehome.Door.SlidingDoor
import com.example.safehome.Door.DoorFactory
import com.example.safehome.Door.OpenDoorFactory
import com.example.safehome.Door.BiFoldDoorFactory
import com.example.safehome.Door.DoubleDoorFactory
import com.example.safehome.Door.PocketDoorFactory
import com.example.safehome.Door.SingleDoorFactory
import com.example.safehome.Door.SlidingDoorFactory
import com.example.safehome.Wall.Coordinates
import com.example.safehome.Wall.WallSegment
import com.example.safehome.Wall.Wall
import com.example.safehome.Camera.CameraMomento
import com.example.safehome.Momento
import com.example.safehome.Camera.SingletonCamera
import com.example.safehome.Camera.AbstractCamera
import android.provider.ContactsContract.CommonDataKinds.Phone
import com.example.safehome.System.SingletonSystem
import com.example.safehome.Sensors.SType
import com.example.safehome.Sensors.DoorSensor
import com.example.safehome.Sensors.MotionSensor
import com.example.safehome.Sensors.WindowSensor
import com.example.safehome.Sensors.SensorFactory
import com.example.safehome.Sensors.DoorSensorFactory
import com.example.safehome.Sensors.MotionSensorFactory
import com.example.safehome.Sensors.WindowSensorFactory
import com.example.safehome.FloorPlan.FType
import com.example.safehome.FloorPlan.FPlan
import com.example.safehome.FloorPlan.FloorPlan
import com.example.safehome.Publisher.CameraNotification
import com.example.safehome.Publisher.NotificationClient
import com.example.safehome.Publisher.SensorNotification
import com.example.safehome.ControlPanel.KeyPad
import com.example.safehome.ControlPanel.ControlPanel
import com.example.safehome.ControlPanel.ControlPanelMomento
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
    private var dimensions: MutableList<Coordinates>
    private val type: String

    /**
     * Creates a wall segment.
     * @param color the color of the wall segment
     * @param type the type of wall segment. I.e, sheetrock, concrete, wood, etc.
     * @param startCoordinate the start coordinate
     * @param stopCoordinate the stop coordinate
     */
    init {
        dimensions = ArrayList()
        dimensions.add(startCoordinate)
        dimensions.add(stopCoordinate)
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
    override fun setDimensions(dimensions: MutableList<Coordinates>) {
        this.dimensions = dimensions
    }
    /**
     * The start coordinates of the segment.
     *
     * @return the start coordinates of the segment
     */
    /**
     * Set the start coordinates for the segment.
     *
     * @param startCoordinates the start coordinates
     */
    override var startCoordinates: Coordinates
        get() = dimensions[0]
        set(startCoordinates) {
            dimensions[0] = startCoordinates
        }
    /**
     * The stop coordinates of the segment.
     *
     * @return the stop coordinates of the segment
     */
    /**
     * Set the stop coordinates for the segment.
     *
     * @param stopCoordinates the stop coordinates
     */
    override var stopCoordinates: Coordinates
        get() = dimensions[1]
        set(stopCoordinates) {
            dimensions[1] = stopCoordinates
        }

    companion object {
        private val log = LoggerFactory.getLogger(WallSegment::class.java)
    }
}