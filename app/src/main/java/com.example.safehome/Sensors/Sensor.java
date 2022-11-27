package com.example.safehome.Sensors;

public interface Sensor <Object> {

    /**
     * detects whether an event has occurred
      */
    boolean isEventDectected();

    /**
     * identifies the type of sensor
     */
    void identify();


    /**
     * enables notifications
     */
    void enableNotification();

    /**
     * disables notifications
     */
    void disableNotification();

    /**
     * reconfigures sensor
     */
    void reconfigure();

    /**
     * adds sensor to system
     */
    void addSensorMomento();

    /**
     * gets existing sensor from system
     */
    void getSensorMomento();
}
