package com.example.safehome.Publisher;

/**
 * Concrete implementation of SensorNotification
 * @param <Data>
 */
public class SensorNotification<Data> implements Notification<Data> {

    boolean state;
    Data data;
    EventType eventType;

    /**
     * enables notifications
     */
    @Override
    public boolean enable() {
        return false;
    }

    /**
     * disables notifications
     */
    @Override
    public boolean disable() {
        return false;
    }

    /**
     * updates notification status
     *
     * @param data
     */
    @Override
    public boolean update(Data data) {
        return false;
    }

    /**
     * gets state from system
     */
    @Override
    public boolean getstate() {
        return false;
    }

    /**
     * sets state in system
     *
     * @param state
     */
    @Override
    public void setstate(boolean state) {

    }

    /**
     * sets type in system
     *
     * @param type
     */
    @Override
    public void setType(EventType type) {

    }

    /**
     * gets event from system
     */
    @Override
    public EventType getEvent() {
        return null;
    }
}