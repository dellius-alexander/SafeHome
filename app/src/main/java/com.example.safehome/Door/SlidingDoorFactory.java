package com.example.safehome.Door;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SlidingDoorFactory implements DoorFactory<Door> {
    private static final Logger log = LoggerFactory.getLogger(SlidingDoorFactory.class);
    /**
     * FactoryMethod returns class of type Door.
     *
     * @param request
     * @return FactoryMethod returns class of type Door.
     */
    @Override
    public Door factoryMethod(Door request) {
        return null;
    }
}