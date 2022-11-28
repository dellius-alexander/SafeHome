package com.example.safehome.Publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Publisher {

    private static final Logger log = LoggerFactory.getLogger(Publisher.class);
    private Map<EventType, Notification> notificationSubscribers = new HashMap<>();
    private Publisher state;

    /**
     * sets notifications
     * @param notification
     * @param eventType
     * @return {@linkplain Boolean}
     */
    public boolean addSubscriber(EventType eventType, Notification notification) {
        try {
            this.notificationSubscribers.put(eventType, notification);
            // their may be different notification types, we used "open" as this type;
            // more can be added for each type of notification
            this.state.notify(notification.getType(), notification.getData().toString());
            return true;
        } catch (Exception e){
            log.error("{}",e);
            return false;
        }
    }

    /**
     * delete notifications
     * @param notification
     * @param eventType
     * @return {@linkplain Boolean}
     */
    public boolean removeSubscriber(EventType eventType, Notification notification) {
        try {
            this.notificationSubscribers.remove(eventType, notification);
            // their may be different notification types, we used "open" as this type;
            // more can be added for each type of notification
            return true;
        } catch (Exception e){
            log.error("{}",e);
            return false;
        }
    }


    /**
     * enable notifications
     * @param eventType
     * @param data
     * @return {@linkplain Boolean}
     */
    public boolean notify(EventType eventType, String data) {
        for (Map.Entry<EventType, Notification> entry : this.notificationSubscribers.entrySet())
        {
            if (entry.getValue().getType() == eventType)
            {
                entry.getValue().update(data);
                return true;
            }
        }
        return false;
    }

    /**
     * disable notifications
     * @param notification
     */
    public void updateState(Notification notification) {
        this.state = this;
    }


    /**
     * save notifications
     * @param notification
     * @return {@linkplain Boolean}
     */
    public Publisher getState(Notification notification) {
        return this.state;
    }

    /**
     * retrieves Notification Subscriber object
     * @return {@linkplain Map<EventType, Notification>}
     */
    public Map<EventType, Notification> getNotificationSubscribers() {
        return notificationSubscribers;
    }

}
