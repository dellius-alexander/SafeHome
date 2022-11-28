package com.example.safehome.Publisher

/**
 * Notification represents the abstract of a notification object.
 * All notifications implements this class.
 * @param <Data> represents the data about the event
 */

interface Notification {

    /**
     * enables notifications
     */
    fun enable(): Boolean

    /**
     * disables notifications
     */
    fun disable(): Boolean

    /**
     * updates notifications
     * @param data the data
     */
    fun update(data:Data?): Boolean

    /**
     * gets state from system
     */
    fun getState(): Boolean

    /**
     * sets state from system
     */
    fun setState(state:Boolean)

    /**
     * sets type in system
     */
    fun setType(type:EventType?)

    /**
     * gets type from system
     * @return EventType
     */
    fun getType(): EventType?

    /**
     * gets data message received from an event
     * @return Data received from an event
     */
    fun getData(): Data?

}