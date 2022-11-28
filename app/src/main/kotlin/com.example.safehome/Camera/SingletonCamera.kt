package com.example.safehome.Camera

import org.slf4j.LoggerFactory
import org.slf4j.Logger

/**
 * Creates one instance of the camera
 */
object SingletonCamera {
    private val log: Logger = LoggerFactory.getLogger(SingletonCamera::class.java)
    @JvmStatic
    private lateinit var instance: Camera

    init {
        log.info("Initializing SingletonCamera object...")
    }

    /**
     * Get the [SingletonCamera]
     */
    @JvmStatic
    fun getInstance(): AbstractCamera{
        log.info("{}", instance)
        if (instance == null) {
            instance = Camera()
            return instance
        }
        return instance!!
    }

}
