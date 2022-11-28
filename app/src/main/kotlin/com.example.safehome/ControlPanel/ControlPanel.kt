package com.example.safehome.ControlPanel

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
import java.net.NetworkInterface

class ControlPanel : Panel {
    private val mode: String? = null
    private val keyPadCharacteristics: Characteristics? = null
    private val speaker: Speaker? = null
    private val networkInterface: NetworkInterface? = null
    private var state: ControlPanel? = null

    /**
     * Defines the input from terminal, screen or key pad
     *
     * @param keyStrokes the String keyStroke input.
     */
    override fun readKeyStrokes(keyStrokes: String?) {
        // TODO: implement the reading of input
    }

    /**
     * Decodes keystroke to to utf-8 encoding
     *
     * @return the decoded key String value
     */
    override fun decodeKey(): String? {
        // TODO: decode the key stroke and return true if successful, false otherwise.
        return null
    }

    /**
     * Defines the display status. True if display is available,
     * false otherwise.
     *
     * @return boolean
     */
    override fun displayStatus(): Boolean {
        // TODO: implement display status process and return true if successful, false otherwise.
        return false
    }

    /**
     * Defines the screen mode to dark mode.
     *
     * @param mode the mode definition string to define the mode.
     * @return boolean
     */
    override fun darkMode(mode: String?): Boolean {
        // TODO: implement darkMode process and return true if successful, false otherwise.
        return false
    }

    /**
     * Sends a control message to initiate a task.
     *
     * @param msg the message string
     * @return boolean
     */
    override fun sendControlMsg(msg: String?): Boolean {
        // TODO: implement sendControlMsg and return true if successful, false otherwise.
        return false
    }

    /**
     * Contains the current state of the [ControlPanel] object.
     * @return [ControlPanelMomento]
     */
    fun saveState(): ControlPanelMomento {
        //println "Originator: Saving to ControlPanelMomento."
        return ControlPanelMomento(state)
    }

    /**
     * Setting a new internal state of the [ControlPanel]
     * @param state the current state of the [ControlPanel]
     */
    fun setState(state: ControlPanel?) {
        this.state = state
    }

    /**
     * Restores the [ControlPanel] to a previous state
     * @param controlPanelMomento the [ControlPanelMomento] containing the
     * state of the [ControlPanel]
     */
    fun restoreState(controlPanelMomento: ControlPanelMomento) {
        state = controlPanelMomento.state
    }

    companion object {
        private val log = LoggerFactory.getLogger(ControlPanel::class.java)
    }
}