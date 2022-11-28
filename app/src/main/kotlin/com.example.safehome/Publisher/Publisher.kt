package com.example.safehome.Publisher


import org.slf4j.LoggerFactory
import java.lang.Exception
import java.util.HashMap

class Publisher {
    private val notificationSubscribers: MutableMap<EventType, Notification<*>> = HashMap()
    private var state: Publisher? = null

    /**
     * sets notifications
     * @param notification
     * @param eventType
     * @return [Boolean]
     */
    fun addSubscriber(eventType: EventType, notification: Notification<*>): Boolean {
        return try {
            notificationSubscribers[eventType] = notification
            // their may be different notification types, we used "open" as this type;
            // more can be added for each type of notification
            state!!.notify(notification.type, notification.data.toString())
            true
        } catch (e: Exception) {
            log.error("{}", e)
            false
        }
    }

    /**
     * delete notifications
     * @param notification
     * @param eventType
     * @return [Boolean]
     */
    fun removeSubscriber(eventType: EventType, notification: Notification<*>): Boolean {
        return try {
            notificationSubscribers.remove(eventType, notification)
            // their may be different notification types, we used "open" as this type;
            // more can be added for each type of notification
            true
        } catch (e: Exception) {
            log.error("{}", e)
            false
        }
    }

    /**
     * enable notifications
     * @param eventType
     * @param data
     * @return [Boolean]
     */
    fun notify(eventType: EventType?, data: String?): Boolean {
        for ((_, value) in notificationSubscribers) {
            if (value.type == eventType) {
                value.update(data)
                return true
            }
        }
        return false
    }

    /**
     * disable notifications
     * @param notification
     */
    fun updateState(notification: Notification<*>?) {
        state = this
    }

    /**
     * save notifications
     * @param notification
     * @return [Boolean]
     */
    fun getState(notification: Notification<*>?): Publisher? {
        return state
    }

    /**
     * retrieves Notification Subscriber object
     * @return [,][<]
     */
    fun getNotificationSubscribers(): Map<EventType, Notification<*>> {
        return notificationSubscribers
    }

    companion object {
        private val log = LoggerFactory.getLogger(Publisher::class.java)
    }
}