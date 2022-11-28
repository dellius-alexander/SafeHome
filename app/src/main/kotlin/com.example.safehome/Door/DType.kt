package com.example.safehome.Door


import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.HashMap
import java.util.stream.Collectors

/**
 * DType policies defines door types
 */
enum class DType
/**
 * Create new SType with label = label
 * @param label
 */(  // static inference
    private val label: String
) {
    BIFOLD("BIFOLD"),
    DOUBLE("DOUBLE"),
    SINGLE("SINGLE"),
    POCKET("POCKET"),
    OPEN("OPEN"),
    SLIDING("SLIDING");

    companion object {
        private val log: Logger = LoggerFactory.getLogger(DType::class.java)
        private val BY_LABEL: MutableMap<String, DType> = HashMap()

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
         * @return type
         */
        fun valueOfLabel(label: String): DType? {
            var t: DType? = null
            for (type in values()) {
                if (type.label == label) {
                    log.info(type.label)
                    t = type
                    return type
                }
            }
            return t
        } //    public static void main(String[] args) {
        //        DType type = DType.valueOfLabel("DOOR");
        //        System.out.println("TYPE_" + type);
        //    }
    }
}