package com.example.safehome.Door

import org.slf4j.LoggerFactory

class OpenDoor(doorInfo: DoorInfo?) : Door<Any?> {
    private val doorInfo: DoorInfo? = null

    /**
     *
     * @param doorInfo
     */
    init {
        // TODO - implement OpenDoor.OpenDoor
        throw UnsupportedOperationException()
    }

    /**
     * detects whether an event has occurred
     */
    override fun determineType(): DType? {
        return null
    }

    /**
     * identifies the type of door
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
     * reconfigures door
     */
    override fun reconfigure() {}

    /**
     * adds door to system
     */
    override fun addSensorMomento() {}

    /**
     * gets existing doorr from system
     */
    override val sensorMomento: Unit
        get() {}

    companion object {
        private val log = LoggerFactory.getLogger(OpenDoor::class.java)
    }
}