package com.example.safehome.Sensors

import android.hardware.Sensor
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class WindowSensorFactory : SensorFactory<Sensor?> {
    /**
     * FactoryMethod returns class of type Sensor.
     *
     * @param request
     * @return FactoryMethod returns class of type Sensor.
     */
    override fun factoryMethod(request: Sensor?): Sensor? {
        return null
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(WindowSensorFactory::class.java)
    }
}