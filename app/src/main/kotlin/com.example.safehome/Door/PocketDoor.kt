package com.example.safehome.Door

import org.slf4j.LoggerFactory

class PocketDoor(doorInfo: DoorInfo?) : Door {
    private val doorInfo: DoorInfo? = null

    /**
     *
     * @param doorInfo
     */
    init {
        // TODO - implement PocketDoor.PocketDoor
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
     * gets existing sensor from system
     */
    override fun getSensorMomento() {
        TODO("Not yet implemented")
    }

    /**
     * gets existing door from system
     */
    val sensorMomento: Unit
        get() {}

    companion object {
        private val log = LoggerFactory.getLogger(PocketDoor::class.java)
    }
}