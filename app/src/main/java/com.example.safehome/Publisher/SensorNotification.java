package com.example.safehome.Publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of SensorNotification
 * @param <Data>
 */
public class SensorNotification<Data> implements Notification<Data> {
    private static final Logger log = LoggerFactory.getLogger(SensorNotification.class);
    private boolean state;
    private List<Data> listOfData;
    private EventType eventType;


    public SensorNotification(EventType eventType, boolean state, Data data) {
        this.eventType = eventType;
        this.state = state;
        this.listOfData = new ArrayList<>();
        this.listOfData.add(data);
    }

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
    public boolean getState() {
        return false;
    }

    /**
     * sets state in system
     *
     * @param state
     */
    @Override
    public void setState(boolean state) {

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
     * gets type from system
     *
     * @return {@linkplain EventType}
     */
    public EventType getType() {
        return this.eventType;
    }

    /**
     * gets data message received from an event
     * @return Data received from an event
     */
    public Data getData() {
        try{
            return this.listOfData.get(listOfData.size()-1);
        }catch (Exception e){
            log.error("{}", e);
        }
        return null;
    }


    /**
     * gets event from system
     */

    public EventType getEvent() {
        return eventType;
    }
}
