package com.example.safehome.Publisher;

import com.example.safehome.Sensors.Sensor;
import com.example.safehome.Sensors.SensorInfo;
import com.example.safehome.Sensors.SensorMomento;

import java.util.List;

/**
 * Concrete implementation of CameraNotification
 * @param <Data>
 */
public class CameraNotification<Data> implements Notification<Data> {

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
