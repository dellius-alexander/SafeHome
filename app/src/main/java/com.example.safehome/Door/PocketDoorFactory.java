package com.example.safehome.Door;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PocketDoorFactory implements DoorFactory<Door> {
    private static final Logger log = LoggerFactory.getLogger(PocketDoorFactory.class);
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