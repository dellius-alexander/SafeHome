package com.example.safehome.Door;

import com.example.safehome.Door.DoorFactory;

public class DoubleDoorFactory implements DoorFactory<Door> {
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