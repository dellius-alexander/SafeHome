package com.example.safehome

interface IMomento<Object> {
    /**
     * Retrieves the state of the saved state of the Camera state.
     * @return the saved Object state
     */
    fun getState(): Object?

    /**
     * Saves the state of the Camera object.
     * @param state the state the object
     */
    fun setState(state: Object?)
}