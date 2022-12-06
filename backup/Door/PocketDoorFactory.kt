package com.example.safehome.Door

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PocketDoorFactory : DoorFactory<Door?> {
    /**
     * FactoryMethod returns class of type Door.
     *
     * @param request
     * @return FactoryMethod returns class of type Door.
     */
    override fun factoryMethod(request: Door?): Door? {
        return null
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(PocketDoorFactory::class.java)
    }
}