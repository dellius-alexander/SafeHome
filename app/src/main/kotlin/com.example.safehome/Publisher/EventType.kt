package com.example.safehome.Publisher


import android.util.Log.e
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.HashMap
import java.util.stream.Collectors

/**
 * EventType policies defines event types
 */
enum class EventType
/**
 * Create new SType with label = label
 * @param label
 */(private val label: String) {

    MOTIONDETECTED("MOTIONDETECTED"),
    POWER("POWER"),
    CONNECTIVITY("CONNECTIVITY"),
    TRIGGERED("TRIGGERED");

    companion object {
        private val log: Logger = LoggerFactory.getLogger(EventType::class.java)

        // static inference
        @JvmStatic
        private val BY_LABEL: MutableMap<String, EventType> = HashMap()

        /**
         * static inference collection of event types
         */
        init {
            for (e in values()) {
                BY_LABEL[e.label] = e
            }
            log.info(BY_LABEL.values.stream().collect(Collectors.toList()).toString())
        }

        /**
         * Static inference: Creates a EventType Object with label = label.
         * @param label
         * @return
         */
        fun valueOfLabel(label: String): EventType? {
            var t: EventType? = null
            for (type in values()) {
                if (type.label == label) {
                    log.info(type.label)
                    t = type
                    return type
                }
            }
            return t
        } //    public static void main(String[] args) {
        //        EventType type = EventType.valueOfLabel("DOOR");
        //        System.out.println("TYPE_" + type);
        //    }
    }
}