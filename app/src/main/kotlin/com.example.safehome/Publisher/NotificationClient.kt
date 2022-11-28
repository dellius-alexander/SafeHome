package com.example.safehome.Publisher

import android.support.v4.os.IResultReceiver._Parcel
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.Exception

/**
 * NotificationClient
 */
class NotificationClient {
    private val publisher: Publisher
    private var notification: Notification? = null

    /**
     * Notification constructor
     */
    init {
        publisher = Publisher()
    }

    /**
     * sets notifications
     * @param notification
     * @return [Boolean]
     */
    fun setNotification(notification: Notification): Boolean {
        this.notification = notification
        // their may be different notification types, we used "open" as this type;
        // more can be added for each type of notification
        publisher.notify(notification.getType(), notification.getData())
        return true
    }

    /**
     * delete notifications
     * @param notification
     * @return [Boolean]
     */
    fun deleteNotification(notification: Notification): Boolean {
        var notificationSubscribers: MutableMap<EventType, Notification>?
        try {

            for (entry in this.publisher.getNotificationSubscribers())
            {
                if (entry.value.getType() == notification.getType() && entry.value is Notification) {
                    log.info("{}", publisher.getNotificationSubscribers())
                    publisher.getNotificationSubscribers().remove(entry.key)
                    log.info("{}", publisher.getNotificationSubscribers())
                    return true
                }
            }

        } catch (e: Exception) {
            log.error("{}", e)
        }
        return false
    }

    /**
     * enable notifications
     * @param notification
     * @return [Boolean]
     */
    fun enableNotification(notification: Notification?): Boolean {
        return false
    }

    /**
     * disable notifications
     * @param notification
     * @return [Boolean]
     */
    fun disableNotification(notification: Notification?): Boolean {
        return false
    }

    /**
     * save notifications
     * @param notification
     * @return [Boolean]
     */
    fun saveNotification(notification: Notification?): Boolean {
        return false
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(NotificationClient::class.java)
    }
}


