package com.example.safehome.Camera

/**
 * Defines the type of camera used in the security system.
 */
interface AbstractCamera {
    fun id(): String?

    /**
     * Defines the type of camera used in the security system.
     */
    fun type(): String?

    /**
     * The location of the camera.
     */
    fun location(): String?

    /**
     * What is the field of view of the camera:
     *
     * 160 Degrees
     * 140 Degrees
     * 130 Degrees
     * and so on...
     */
    fun fieldOfView(): String?

    /**
     * Does the camera have two-way audio functionality.
     */
    fun twoWayAudio(): Boolean

    /**
     * Does the camera have night vision capabilities.
     */
    fun nightVision(): Boolean

    /**
     * what is the resolution of the camera:
     * 720P
     * 10800P
     * 2K
     * 4K
     */
    fun resolution(): String?

    /**
     * Does the camera have push notifications functionality.
     */
    fun hasPushNotifications(): Boolean

    /**
     * What type of network connectivity function does the camera have?
     *
     * Type of connectivity:
     * Wifi
     * Ethernet
     * and so on...
     */
    fun connectivity(): String?

    /**
     * Defines the storage type class used to persist video capture.
     *
     * Types include:
     * Cloud storage
     * Flash storage
     * NFS storage
     * Local storage: connected to NVR
     * and so on...
     */
    fun storage(): Storage<*>?
}