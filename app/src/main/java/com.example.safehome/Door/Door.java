package com.example.safehome.Door;

import android.icu.lang.UCharacter;

public interface Door <Object> {

    /**
     * detects whether an event has occurred
     */
    DType determineType();

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
