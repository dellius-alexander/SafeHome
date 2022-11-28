package com.example.safehome.Camera

import com.example.safehome.Momento
import org.slf4j.LoggerFactory

class CameraMomento: Momento<Camera> {
    /**
     * Create a momento of the state of on object, save it for
     * later use to restore the state of the object.
     * @param state the state the object
     */
    private lateinit var state: Camera
    /**
     * Retrieves the state of the saved state of the Camera state.
     * @return the saved Object state
     */
    override fun getState(): Camera {
        return state
    }

    /**
     * Saves the state of the Camera object.
     * @param state the state the object
     */
    override fun setState(state: Camera) {
        this.state = state
    }

    companion object {
        private val log = LoggerFactory.getLogger(CameraMomento::class.java)
    }
}