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
import java.util.HashMap

class Publisher {
    private val notificationSubscribers: MutableMap<EventType, Notification<*>> = HashMap()
    private var state: Publisher? = null

    /**
     * sets notifications
     * @param notification
     * @param eventType
     * @return [Boolean]
     */
    fun addSubscriber(eventType: EventType, notification: Notification<*>): Boolean {
        return try {
            notificationSubscribers[eventType] = notification
            // their may be different notification types, we used "open" as this type;
            // more can be added for each type of notification
            state!!.notify(notification.type, notification.data.toString())
            true
        } catch (e: Exception) {
            log.error("{}", e)
            false
        }
    }

    /**
     * delete notifications
     * @param notification
     * @param eventType
     * @return [Boolean]
     */
    fun removeSubscriber(eventType: EventType, notification: Notification<*>): Boolean {
        return try {
            notificationSubscribers.remove(eventType, notification)
            // their may be different notification types, we used "open" as this type;
            // more can be added for each type of notification
            true
        } catch (e: Exception) {
            log.error("{}", e)
            false
        }
    }

    /**
     * enable notifications
     * @param eventType
     * @param data
     * @return [Boolean]
     */
    fun notify(eventType: EventType?, data: String?): Boolean {
        for ((_, value) in notificationSubscribers) {
            if (value.type == eventType) {
                value.update(data)
                return true
            }
        }
        return false
    }

    /**
     * disable notifications
     * @param notification
     */
    fun updateState(notification: Notification<*>?) {
        state = this
    }

    /**
     * save notifications
     * @param notification
     * @return [Boolean]
     */
    fun getState(notification: Notification<*>?): Publisher? {
        return state
    }

    /**
     * retrieves Notification Subscriber object
     * @return [,][<]
     */
    fun getNotificationSubscribers(): Map<EventType, Notification<*>> {
        return notificationSubscribers
    }

    companion object {
        private val log = LoggerFactory.getLogger(Publisher::class.java)
    }
}