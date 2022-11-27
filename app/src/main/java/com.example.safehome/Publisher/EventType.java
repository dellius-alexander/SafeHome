package com.example.safehome.Publisher;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * EventType policies defines event types
 */
public enum EventType {
    MOTIONDETECTED("MOTIONDETECTED"),
    POWER("POWER"),
    CONNECTIVITY("CONNECTIVITY"),
    TRIGGERED("TRIGGERED"),

    private static final Logger log = LoggerFactory.getLogger(EventType.class);
    private final String label;
    // static inference
    private static final Map<String, EventType> BY_LABEL = new HashMap<>();
    /**
     * Create new SType with label = label
     * @param label
     */
    EventType(String label){
        this.label = label;
    }
    /**
     * static inference collection of event types
     */
    static {
        for (EventType e: values()) {
            BY_LABEL.put(e.label, e);
        }
        log.info(BY_LABEL.values().stream().collect(Collectors.toList()).toString());
    }
    /**
     * Static inference: Creates a EventType Object with label = label.
     * @param label
     * @return
     */
    public static EventType valueOfLabel(String label) {
        EventType t = null;
        for (EventType type : values()) {
            if (type.label.equals(label)) {
                log.info(type.label);
                t = type;
                return type;
            }
        }
        return t;
    }
//    public static void main(String[] args) {
//        EventType type = EventType.valueOfLabel("DOOR");
//        System.out.println("TYPE_" + type);
//    }
}