package com.example.safehome.ControlPanel

/**
 * Abstract Panel for the [ControlPanel] class.
 */
interface Panel : KeyPad {
    /**
     * Defines the display status. True if display is available,
     * false otherwise.
     * @return boolean
     */
    fun displayStatus(): Boolean

    /**
     * Defines the screen mode to dark mode.
     * @param mode the mode definition string to define the mode.
     * @return boolean
     */
    fun darkMode(mode: String?): Boolean

    /**
     * Sends a control message to initiate a task.
     * @param msg the message string
     * @return boolean
     */
    fun sendControlMsg(msg: String?): Boolean
}