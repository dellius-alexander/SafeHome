package com.example.safehome.FloorPlan;

import com.example.safehome.Sensors.SType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Defines the FloorPlan Type.
 */
public enum FType {
    DEFAULT("DEFAULT"),
    _1D("1D"),
    _2D("2D"),
    _3D("3D");

    private static final Logger log = LoggerFactory.getLogger(FType.class);
    private final String label;
    // static inference
    private static final Map<String, FType> BY_LABEL = new HashMap<>();
    /**
     * Create new SType with label = label
     * @param label
     */
    FType(String label){
        this.label = label;
    }
    /**
     * static inference collection of sensor types
     */
    static {
        for (FType e: values())
        {
            BY_LABEL.put(e.label, e);
        }
        log.info(BY_LABEL.values().stream().collect(Collectors.toList()).toString());
    }
    /**
     * Static inference: Creates a SType Object with label = label.
     * @param label the label
     * @return the {@linkplain FType}
     */
    public static FType valueOfLabel(String label) {
        FType t = null;
        for (FType type : values()) {
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
