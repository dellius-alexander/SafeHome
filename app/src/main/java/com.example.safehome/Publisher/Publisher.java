package com.example.safehome.Publisher;

import java.util.Map;

public class Publisher {
    private Map<EventType, Notification> notificationSubscribers;
    private Publisher state;

    /**
     * sets notifications
     * @param notification
     * @return {@linkplain Boolean}
     */
    public boolean setNotification(Notification notification) {
        this.notification = notification;
        // their may be different notification types, we used "open" as this type;
        // more can be added for each type of notification
        this.publisher.notify(notification.getType(), this.notification.data);
        return true;
    }

    /**
     * delete notifications
     * @param notification
     * @return {@linkplain Boolean}
     */
    public boolean deleteNotification(Notification notification) {

        for(int i = 0; i < this.publisher.notificationSubscibers.size(); i++)
        {
            Notification savedNotification = this.publisher.notificationSubscribers.get(i);
            if (savedNotification.getType() ==  notification.getType() && savedNotification instanceof Notification)
            {
                this.publisher.notificationSubscribers.remove(i);
            }
        }
        return true;
    }


    /**
     * enable notifications
     * @param notification
     * @return {@linkplain Boolean}
     */
    public boolean enableNotification(Notification notification) {
        return false;
    }

    /**
     * disable notifications
     * @param notification
     * @return {@linkplain Boolean}
     */
    public boolean disableNotification(Notification notification) {
        return false;
    }


    /**
     * save notifications
     * @param notification
     * @return {@linkplain Boolean}
     */
    public boolean saveNotification(Notification notification) {
        return false;
    }



}
