package com.example.safehome.Sensors

import org.slf4j.LoggerFactory

class DoorSensor : Sensor<Any?> {
    private val sensorMomentoList: Array<List<SensorMomento>>
    private val state: SensorInfo? = null

    /**
     * detects whether an event has occurred
     */
    override val isEventDectected: Boolean
        get() = false

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
    override val sensorMomento: Unit
        get() {}

    companion object {
        private val log = LoggerFactory.getLogger(DoorSensor::class.java)
    }
}