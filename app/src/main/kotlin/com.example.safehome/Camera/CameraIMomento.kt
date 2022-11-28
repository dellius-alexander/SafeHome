package com.example.safehome.Camera

import com.example.safehome.IMomento
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 *
 */
class CameraIMomento(
    /**
     * Create a momento of the state of on object, save it for
     * later use to restore the state of the object.
     * @param state the state the object
     */
    private var state: Camera?) : IMomento<Camera> {

    /**
     * Retrieves the state of the saved state of the Camera state.
     * @return the saved Object state
     */
    override fun getState(): Camera? {
        return state
    }

    /**
     * Saves the state of the Camera object.
     * @param state the state the object
     */
    override fun setState(state: Camera?) {
        this.state = state
        log.info("{}",this.state)
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(CameraIMomento::class.java)
    }
}