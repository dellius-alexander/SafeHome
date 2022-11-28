package com.example.safehome.Publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
     * NotificationClient
     */
    public class NotificationClient {
        private static final Logger log = LoggerFactory.getLogger(NotificationClient.class);
        private Publisher publisher;
        private Notification notification;

        /**
         * Notification constructor
         */
        public NotificationClient() {
            this.publisher = new Publisher();
        }
        /**
         * sets notifications
         * @param notification
         * @return {@linkplain Boolean}
         */
        public boolean setNotification(Notification notification) {
            this.notification = notification;
        // their may be different notification types, we used "open" as this type;
        // more can be added for each type of notification
            this.publisher.notify(notification.getType(), this.notification.getData().toString());
            return true;
        }

        /**
         * delete notifications
         * @param notification
         * @return {@linkplain Boolean}
         */
        public boolean deleteNotification(Notification notification) {
            try{
                for(int i = 0; i < this.publisher.getNotificationSubscribers().size(); i++)
                {
                    Notification savedNotification = this.publisher.getNotificationSubscribers().get(i);
                    if (savedNotification.getType() ==  notification.getType() && savedNotification instanceof Notification)
                    {
                        log.info("{}", this.publisher.getNotificationSubscribers());
                        this.publisher.getNotificationSubscribers().remove(i);
                        log.info("{}", this.publisher.getNotificationSubscribers());
                        return true;
                    }
                }

            }catch(Exception e) {
                log.error("{}", e);

            }
            return false;
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

