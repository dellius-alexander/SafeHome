package com.example.safehome.Sensors

import org.slf4j.LoggerFactory

class DoorSensorFactory : SensorFactory<Sensor<*>?> {
    /**
     * FactoryMethod returns class of type Sensor.
     *
     * @param request
     * @return FactoryMethod returns class of type Sensor.
     */
    override fun factoryMethod(request: Sensor<*>): Sensor<*>? {
        return null
    }

    companion object {
        private val log = LoggerFactory.getLogger(DoorSensorFactory::class.java)
    }
}