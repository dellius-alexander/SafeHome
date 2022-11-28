package com.example.safehome.Camera

interface Storage<Object> {
    /**
     *
     * @param storage
     */
    fun addStorage(storage: Object)
    val storage: Object
}