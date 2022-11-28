package com.example.safehome.Camera

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Camera : AbstractCamera{
    /**
     * camera id
     */
    private var id: String? = null
    private var type: String? = null

    /**
     * camera location
     */
    private var location: String? = null
    private var fieldOfView: String? = null
    private var twoWayAudio = false
    private var nightVision = false
    private var resolution: String? = null

    /**
     * Defaults to false.
     */
    private var hasPushNotification = false
    private var connectivity: String? = null
    private var state: Camera? = null

    /**
     * Defines the storage object.
     */
    private var storage: Storage<*>? = null

//    constructor(
//        id: String?,
//        type: String?,
//        location: String?,
//        fieldOfView: String?,
//        twoWayAudio: Boolean,
//        nightVision: Boolean,
//        resolution: String?,
//        hasPushNotification: Boolean,
//        connectivity: String?
//    ){
//        this.id = id
//        this.type = type
//        this.location = location
//        this.fieldOfView = fieldOfView
//        this.twoWayAudio = twoWayAudio
//        this.nightVision = nightVision
//        this.resolution = resolution
//        this.hasPushNotification = hasPushNotification
//        this.connectivity = connectivity
//
//    }

    /**
     * Defines the camera type.
     * @param type the camera type.
     */
    fun setType(type: String?) {
        this.type = type
    }

    /**
     * Saves a new state of the Object.
     * @param newState the Object state to save
     */
    fun setState(newState: Camera?) {
        state = newState
    }

    /**
     * Retrieve the save state of the Object
     * @return the saved state of the Object
     */
    fun saveState(): Camera? {
        return state
    }

    /**
     * Create a restore state from the CameraMomento.
     * @param cameraMomemto the saved state of an Object.
     */
    fun restoreState(cameraMomemto: CameraIMomento?) {
        this.state = cameraMomemto?.getState()
    }


    override fun id(): String? {
        return this.id
    }

    /**
     * Defines the type of camera used in the security system.
     */
    override fun type(): String? {
        return this.type
    }

    /**
     * The location of the camera.
     */
    override fun location(): String? {
        return this.location
    }

    /**
     * What is the field of view of the camera:
     *
     * 160 Degrees
     * 140 Degrees
     * 130 Degrees
     * and so on...
     */
    override fun fieldOfView(): String? {
        return this.fieldOfView
    }

    /**
     * Does the camera have two-way audio functionality.
     */
    override fun twoWayAudio(): Boolean {
        return this.twoWayAudio
    }

    /**
     * Does the camera have night vision capabilities.
     */
    override fun nightVision(): Boolean {
        return this.nightVision
    }

    /**
     * what is the resolution of the camera:
     * 720P
     * 10800P
     * 2K
     * 4K
     */
    override fun resolution(): String? {
        return this.resolution
    }

    /**
     * Does the camera have push notifications functionality.
     */
    override fun hasPushNotifications(): Boolean {
        return this.hasPushNotification
    }

    /**
     * What type of network connectivity function does the camera have?
     *
     * Type of connectivity:
     * Wifi
     * Ethernet
     * and so on...
     */
    override fun connectivity(): String? {
        return this.connectivity
    }

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
    override fun storage(): Storage<*>? {
        return this.storage
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(Camera::class.java)
    }

}