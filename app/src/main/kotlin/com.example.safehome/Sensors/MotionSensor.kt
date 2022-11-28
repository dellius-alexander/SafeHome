package com.example.safehome.Sensors

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MotionSensor : Sensor {
    private val sensorMomentoList: Array<List<SensorMomento>> = TODO()
    private val state: SensorInfo? = null

    /**
     * detects whether an event has occurred
     */
    override fun isEventDetected(): Boolean {
        return false
    }


    /**
     * identifies the type of sensor
     */
    override fun identify() {}

    /**
     * enables notifications
     */
    override fun enableNotification() {}

    /**
     * disables notifications
     */
    override fun disableNotification() {}

    /**
     * reconfigures sensor
     */
    override fun reconfigure() {}

    /**
     * adds sensor to system
     */
    override fun addSensorMomento() {}

    /**
     * gets existing sensor from system
     */
    override fun getSensorMomento() {
        
    }


    companion object {
        private val log: Logger = LoggerFactory.getLogger(MotionSensor::class.java)
    }
}