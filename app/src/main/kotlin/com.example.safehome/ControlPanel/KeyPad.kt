package com.example.safehome.ControlPanel

/**
 * Represents user input
 */
interface KeyPad {
    /**
     * Defines the input from terminal, screen or key pad
     * @param keyStrokes the String keyStroke input.
     */
    fun readKeyStrokes(keyStrokes: String?)

    /**
     * Decodes keystroke to to utf-8 encoding
     * @return the decoded key String value
     */
    fun decodeKey(): String?
}