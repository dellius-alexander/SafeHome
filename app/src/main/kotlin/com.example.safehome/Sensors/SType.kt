package com.example.safehome.Sensors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * SType policies defines sensor types
 */
public enum SType {
    DOOR("DOOR"),
    WINDOW("WINDOW"),
    MOTION("MOTION"),
    FIRE("FIRE"),
    CARBONMONOXIDE("CARBONMONOXIDE"),
    SMOKEDETECTOR("SMOKEDETECTOR");

    private static final Logger log = LoggerFactory.getLogger(SType.class);
    private final String label;
    // static inference
    private static final Map<String, SType> BY_LABEL = new HashMap<>();
    /**
     * Create new SType with label = label
     * @param label
     */
    SType(String label){
        this.label = label;
    }
    /**
     * static inference collection of sensor types
     */
    static {
        for (SType e: values()) {
            BY_LABEL.put(e.label, e);
        }
        log.info(BY_LABEL.values().stream().collect(Collectors.toList()).toString());
    }
    /**
     * Static inference: Creates a SType Object with label = label.
     * @param label
     * @return
     */
    public static SType valueOfLabel(String label) {
        SType t = null;
        for (SType type : values()) {
            if (type.label.equals(label)) {
                log.info(type.label);
                t = type;
                return type;
            }
        }
        return t;
    }
//    public static void main(String[] args) {
//        SType type = SType.valueOfLabel("DOOR");
//        System.out.println("TYPE_" + type);
//    }
}