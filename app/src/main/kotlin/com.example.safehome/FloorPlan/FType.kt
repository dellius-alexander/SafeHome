package com.example.safehome.FloorPlan

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
import java.util.HashMap
import java.util.stream.Collectors

/**
 * Defines the FloorPlan Type.
 */
enum class FType
/**
 * Create new SType with label = label
 * @param label
 */(private val label: String) {
    DEFAULT("DEFAULT"), _1D("1D"), _2D("2D"), _3D("3D");

    companion object {
        private val log = LoggerFactory.getLogger(FType::class.java)

        // static inference
        private val BY_LABEL: MutableMap<String, FType> = HashMap()

        /**
         * static inference collection of sensor types
         */
        init {
            for (e in values()) {
                BY_LABEL[com.example.safehome.FloorPlan.e.label] = com.example.safehome.FloorPlan.e
            }
            log.info(BY_LABEL.values.stream().collect(Collectors.toList()).toString())
        }

        /**
         * Static inference: Creates a SType Object with label = label.
         * @param label the label
         * @return the [FType]
         */
        fun valueOfLabel(label: String): FType? {
            var t: FType? = null
            for (type in values()) {
                if (type.label == label) {
                    log.info(type.label)
                    t = type
                    return type
                }
            }
            return t
        } //    public static void main(String[] args) {
        //        SType type = SType.valueOfLabel("DOOR");
        //        System.out.println("TYPE_" + type);
        //    }
    }
}