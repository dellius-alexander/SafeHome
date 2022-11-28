package com.example.safehome.Sensors

interface Sensor{


    /**
     * detects whether an event has occurred
     */
    fun isEventDetected(): Boolean

    /**
     * identifies the type of sensor
     */
    fun identify()


    /**
     * enables notifications
     */
    fun enableNotification()

    /**
     * disables notifications
     */
    fun disableNotification()

    /**
     * reconfigures sensor
     */
    fun reconfigure()

    /**
     * adds sensor to system
     */
    fun addSensorMomento()

    /**
     * gets existing sensor from system
     */
    fun getSensorMomento()

}