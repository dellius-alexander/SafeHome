package com.example.safehome.ControlPanel


import com.example.safehome.IMomento
import org.slf4j.Logger

import org.slf4j.LoggerFactory

/**
 * Saves the current state of the [ControlPanel] object.
 */
class ControlPanelIMomento(
    /**
     * Do not implement constructor
     */
    private var state: ControlPanel?) : IMomento<ControlPanel?> {

    /**
     * Retrieves the state of the saved state of the Camera state.
     * @return  the current state of the [ControlPanel]
     */
    override fun getState(): ControlPanel? {
        return state
    }

    /**
     * Saves the state of the Camera object.
     * @param state  the current state of the [ControlPanel]
     */
    override fun setState(state: ControlPanel?) {
        this.state = state
        log.info("{}",this.state)
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ControlPanelIMomento::class.java)
    }
}