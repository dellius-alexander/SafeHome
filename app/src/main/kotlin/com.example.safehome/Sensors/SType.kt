package com.example.safehome.Sensors

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.HashMap
import java.util.stream.Collectors

/**
 * SType policies defines sensor types
 */
enum class SType
/**
 * Create new SType with label = label
 * @param label
 */(private val label: String) {
    DOOR("DOOR"),
    WINDOW("WINDOW"),
    MOTION("MOTION"),
    FIRE("FIRE"),
    CARBONMONOXIDE("CARBONMONOXIDE"),
    SMOKEDETECTOR("SMOKEDETECTOR");

    companion object {
        private val log: Logger = LoggerFactory.getLogger(SType::class.java)

        // static inference
        private val BY_LABEL: MutableMap<String, SType> = HashMap()

        /**
         * static inference collection of sensor types
         */
        init {
            for (e in values()) {
                BY_LABEL[e.label] = e
            }
            log.info(BY_LABEL.values.stream().collect(Collectors.toList()).toString())
        }

        /**
         * Static inference: Creates a SType Object with label = label.
         * @param label
         * @return
         */
        fun valueOfLabel(label: String): SType? {
            var t: SType? = null
            for (type in values()) {
                if (type.label == label) {
                    log.info(type.label)
                    t = type
                    return type
                }
            }
            return t
        } //    public static void main(String[] args) {
        //        SType type = SType.valueOfLabel("DOOR");
        //        System.out.println("TYPE_" + type);
        //    }
    }
}