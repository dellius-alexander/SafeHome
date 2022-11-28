package com.example.safehome.Camera

interface Storage<Object> {

    /**
     * Represents adding a storage device
     * @param storage the storage device
     */
    fun addStorage(storage: Object)
    val storage: Object
}