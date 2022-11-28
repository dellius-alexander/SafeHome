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
    override fun type(): String {
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
        get() = dimensions!![0]
        set(startCoordinates) {
            dimensions!![0] = startCoordinates
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
        get() = dimensions!![1]
        set(stopCoordinates) {
            dimensions!![1] = stopCoordinates
        }

    companion object {
        private val log = LoggerFactory.getLogger(Window::class.java)
    }
}