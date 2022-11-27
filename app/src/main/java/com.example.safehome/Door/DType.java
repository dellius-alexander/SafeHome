package com.example.safehome.Door;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * DType policies defines door types
 */
public enum DType {
    BIFOLD("BIFOLD"),
    DOUBLE("DOUBLE"),
    SINGLE("SINGLE"),
    POCKET("POCKET"),
    OPEN("OPEN"),
    SLIDING("SLIDING");

    private static final Logger log = LoggerFactory.getLogger(DType.class);
    private final String label;
    // static inference
    private static final Map<String, DType> BY_LABEL = new HashMap<>();
    /**
     * Create new SType with label = label
     * @param label
     */
    DType(String label){
        this.label = label;
    }
    /**
     * static inference collection of sensor types
     */
    static {
        for (DType e: values()) {
            BY_LABEL.put(e.label, e);
        }
        log.info(BY_LABEL.values().stream().collect(Collectors.toList()).toString());
    }
    /**
     * Static inference: Creates a SType Object with label = label.
     * @param label
     * @return
     */
    public static DType valueOfLabel(String label) {
        DType t = null;
        for (DType type : values()) {
            if (type.label.equals(label)) {
                log.info(type.label);
                t = type;
                return type;
            }
        }
        return t;
    }
//    public static void main(String[] args) {
//        DType type = DType.valueOfLabel("DOOR");
//        System.out.println("TYPE_" + type);
//    }
}