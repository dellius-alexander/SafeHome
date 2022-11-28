package com.example.safehome.System

/**
 * Represents the Security system
 */
interface ISystem {
    /**
     * initializes some screen or object to enable you to program the system. This could be an admin function.
     */
    fun program()

    /**
     * displays the system information
     */
    fun display()

    /**
     * resets the system and returns true upon completion.
     */
    fun reset(): Boolean

    /**
     *
     * @param queryString
     */
    fun query(queryString: String?): String?

    /**
     * arm the system
     */
    fun arm(): Boolean

    /**
     * disarm the system
     */
    fun disarm(): Boolean

    /**
     * Arm the system
     * @return
     */
    val isArmed: Boolean
}