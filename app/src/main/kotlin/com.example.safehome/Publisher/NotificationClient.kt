package com.example.safehome.Publisher

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

/**
 * NotificationClient
 */
class NotificationClient {
    private val publisher: Publisher
    private var notification: Notification<*>? = null

    /**
     * Notification constructor
     */
    init {
        publisher = Publisher()
    }

    /**
     * sets notifications
     * @param notification
     * @return [Boolean]
     */
    fun setNotification(notification: Notification<*>): Boolean {
        this.notification = notification
        // their may be different notification types, we used "open" as this type;
        // more can be added for each type of notification
        publisher.notify(notification.type, this.notification.getData().toString())
        return true
    }

    /**
     * delete notifications
     * @param notification
     * @return [Boolean]
     */
    fun deleteNotification(notification: Notification<*>): Boolean {
        try {
            for (i in 0 until publisher.notificationSubscribers.size) {
                val savedNotification = publisher.notificationSubscribers.get(i)
                if (savedNotification.getType() == notification.type && savedNotification is Notification<*>) {
                    log.info("{}", publisher.notificationSubscribers)
                    publisher.notificationSubscribers.remove(i)
                    log.info("{}", publisher.notificationSubscribers)
                    return true
                }
            }
        } catch (e: Exception) {
            log.error("{}", e)
        }
        return false
    }

    /**
     * enable notifications
     * @param notification
     * @return [Boolean]
     */
    fun enableNotification(notification: Notification<*>?): Boolean {
        return false
    }

    /**
     * disable notifications
     * @param notification
     * @return [Boolean]
     */
    fun disableNotification(notification: Notification<*>?): Boolean {
        return false
    }

    /**
     * save notifications
     * @param notification
     * @return [Boolean]
     */
    fun saveNotification(notification: Notification<*>?): Boolean {
        return false
    }

    companion object {
        private val log = LoggerFactory.getLogger(NotificationClient::class.java)
    }
}