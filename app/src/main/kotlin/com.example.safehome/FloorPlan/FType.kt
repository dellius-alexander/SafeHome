package com.example.safehome.FloorPlan


import org.slf4j.LoggerFactory
import java.util.HashMap
import java.util.stream.Collectors

/**
 * Defines the FloorPlan Type.
 */
enum class FType
/**
 * Create new SType with label = label
 * @param label
 */(private val label: String) {
    DEFAULT("DEFAULT"), _1D("1D"), _2D("2D"), _3D("3D");

    companion object {
        private val log = LoggerFactory.getLogger(FType::class.java)

        // static inference
        private val BY_LABEL: MutableMap<String, FType> = HashMap()

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
         * @param label the label
         * @return the [FType]
         */
        fun valueOfLabel(label: String): FType? {
            var t: FType? = null
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