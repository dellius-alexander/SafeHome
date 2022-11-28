package com.example.safehome.Sensors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MotionSensorFactory implements SensorFactory<Sensor> {
    private static final Logger log = LoggerFactory.getLogger(MotionSensorFactory.class);
    /**
     * FactoryMethod returns class of type Sensor.
     *
     * @param request
     * @return FactoryMethod returns class of type Sensor.
     */
    @Override
    public Sensor factoryMethod(Sensor request) {
        return null;
    }
}