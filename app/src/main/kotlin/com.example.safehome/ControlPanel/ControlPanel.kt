package com.example.safehome.ControlPanel


import org.slf4j.LoggerFactory
import java.net.NetworkInterface

class ControlPanel : Panel {
    private val mode: String? = null
    private val keyPadCharacteristics: Characteristics? = null
    private val speaker: Speaker? = null
    private val networkInterface: NetworkInterface? = null
    private var state: ControlPanel? = null

    /**
     * Defines the input from terminal, screen or key pad
     *
     * @param keyStrokes the String keyStroke input.
     */
    override fun readKeyStrokes(keyStrokes: String?) {
        // TODO: implement the reading of input
    }

    /**
     * Decodes keystroke to to utf-8 encoding
     *
     * @return the decoded key String value
     */
    override fun decodeKey(): String? {
        // TODO: decode the key stroke and return true if successful, false otherwise.
        return null
    }

    /**
     * Defines the display status. True if display is available,
     * false otherwise.
     *
     * @return boolean
     */
    override fun displayStatus(): Boolean {
        // TODO: implement display status process and return true if successful, false otherwise.
        return false
    }

    /**
     * Defines the screen mode to dark mode.
     *
     * @param mode the mode definition string to define the mode.
     * @return boolean
     */
    override fun darkMode(mode: String?): Boolean {
        // TODO: implement darkMode process and return true if successful, false otherwise.
        return false
    }

    /**
     * Sends a control message to initiate a task.
     *
     * @param msg the message string
     * @return boolean
     */
    override fun sendControlMsg(msg: String?): Boolean {
        // TODO: implement sendControlMsg and return true if successful, false otherwise.
        return false
    }

    /**
     * Contains the current state of the [ControlPanel] object.
     * @return [ControlPanelMomento]
     */
    fun saveState(): ControlPanelMomento {
        //println "Originator: Saving to ControlPanelMomento."
        return ControlPanelMomento(state)
    }

    /**
     * Setting a new internal state of the [ControlPanel]
     * @param state the current state of the [ControlPanel]
     */
    fun setState(state: ControlPanel?) {
        this.state = state
    }

    /**
     * Restores the [ControlPanel] to a previous state
     * @param controlPanelMomento the [ControlPanelMomento] containing the
     * state of the [ControlPanel]
     */
    fun restoreState(controlPanelMomento: ControlPanelMomento) {
        state = controlPanelMomento.getState()
    }

    companion object {
        private val log = LoggerFactory.getLogger(ControlPanel::class.java)
    }
}