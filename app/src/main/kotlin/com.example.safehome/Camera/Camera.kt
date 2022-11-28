package com.example.safehome.Camera

import org.slf4j.LoggerFactory

class Camera {
    /**
     * camera id
     */
    private val id: String? = null
    private var type: String? = null

    /**
     * camera location
     */
    private val location: String? = null
    private val fieldOfView: String? = null
    private val twoWayAudio = false
    private val nightVision = false
    private val resolution: String? = null

    /**
     * Defaults to false.
     */
    private val hasPushNotifications = false
    private val connectivity: String? = null
    private var state: Camera? = null

    /**
     * Defines the storage object.
     */
    private val storage: Storage<*>? = null

    /**
     * Defines the camera type.
     * @param type the camera type.
     */
    fun setType(type: String?) {
        this.type = type
    }

    /**
     * Saves a new state of the Object.
     * @param newState the Object state to save
     */
    fun setState(newState: Camera?) {
        state = newState
    }

    /**
     * Retrieve the save state of the Object
     * @return the saved state of the Object
     */
    fun saveState(): Camera? {
        return state
    }

    /**
     * Create a restore state from the CameraMomento.
     * @param cameraMomemto the saved state of an Object.
     */
    fun restoreState(cameraMomemto: CameraMomento?) {
        // TODO - implement Camera.restoreState
//		throw new UnsupportedOperationException();
    }

    companion object {
        private val log = LoggerFactory.getLogger(Camera::class.java)
    }
}