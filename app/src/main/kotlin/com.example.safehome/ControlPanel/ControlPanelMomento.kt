package com.example.safehome.ControlPanel


import com.example.safehome.Momento

import org.slf4j.LoggerFactory

/**
 * Saves the current state of the [ControlPanel] object.
 */
class ControlPanelMomento
/**
 * Do not implement constructor
 * @param state the current state of the [ControlPanel]
 */(private var state: ControlPanel?) : Momento<ControlPanel?> {
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
    }

    companion object {
        private val log = LoggerFactory.getLogger(ControlPanelMomento::class.java)
    }
}