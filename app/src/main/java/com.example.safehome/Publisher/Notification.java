package com.example.safehome.Publisher;

/**
 * Notification represents the abstract of a notification object.
 * All notifications implements this class.
 * @param <Data> represents the data about the event
 */
public interface Notification<Data> {

    /**
     * enables notifications
     */
    boolean enable();

    /**
     * disables notifications
     */
    boolean disable();
    /**

     * updates notification status
     */
    boolean update(Data data);

    /**
     * gets state from system
     */
    boolean getState();

    /**
     * sets state in system
     */
    void setState(boolean state);

    /**
     * sets type in system
     */
    void setType(EventType type);

    /**
     * gets type from system
     * @return {@linkplain EventType}
     */
    EventType getType();

    /**
     * gets data message received from an event
     * @return Data received from an event
     */
    Data getData();
}

