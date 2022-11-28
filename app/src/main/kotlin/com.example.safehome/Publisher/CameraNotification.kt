package com.example.safehome.Publisher


import org.slf4j.LoggerFactory
import java.lang.Exception
import java.util.ArrayList

/**
 * Concrete implementation of CameraNotification
 * @param <Data>
</Data> */
class CameraNotification(
    private var event: EventType,
    private var state: Boolean,
    data: Data
) : Notification {
    private val listOfData: MutableList<Data>

    init {
        listOfData = ArrayList()
        listOfData.add(data)
    }

    /**
     * enables notifications
     */
    override fun enable(): Boolean {
        return false
    }

    /**
     * disables notifications
     */
    override fun disable(): Boolean {
        return false
    }

    /**
     * updates notification status
     *
     * @param data
     */
    override fun update(data: Data?): Boolean {
        return false
    }

    /**
     * gets state from system
     */
    override fun getState(): Boolean {
        return false
    }

    /**
     * sets state in system
     *
     * @param state
     */
    override fun setState(state: Boolean) {this.state = state}
    /**
     * gets type from system
     *
     * @return [EventType]
     */
    /**
     * sets type of event
     */
    override fun setType(type: EventType?) {
        if (type != null) {
            this.event = type
        }
    }

    /**
     * gets type of event
     * @return EventType
     */
    override fun getType(): EventType? {
        if (event != null) {
            return this.event
        }
        return null
    }


    /**
     * gets data message received from an event
     * @return Data received from an event
     */
    override fun getData(): Data?{
        try {
            return listOfData[listOfData.size - 1]
        } catch (e: Exception) {
            log.error("{}", e)
        }
        return null
    }

    companion object {
        private val log = LoggerFactory.getLogger(CameraNotification::class.java)
    }
}