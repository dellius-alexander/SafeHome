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