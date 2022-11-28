package com.example.safehome.System

import org.slf4j.LoggerFactory

class SingletonSystem private constructor() {
    private lateinit var instance: System;

    init {
        // TODO - implement SingletonSystem.SingletonSystem
        throw UnsupportedOperationException()
    }

    companion object {
        private val log = LoggerFactory.getLogger(SingletonSystem::class.java)
        private val instance: System? = null
    }
}