package com.example.safehome.Door


interface Door {
    /**
     * detects whether an event has occurred
     */
    fun determineType(): DType?

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