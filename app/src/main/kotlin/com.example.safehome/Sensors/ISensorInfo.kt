package com.example.safehome.Sensors

interface ISensorInfo {
    override fun toString(): String

    /**
     *
     * @param name
     */
    var name: String?
    fun getType(): SType?

    /**
     *
     * @param type
     */
    fun setType(type: String?)

    /**
     *
     * @param location
     */
    var location: String?

    /**
     *
     * @param area
     */
    var area: String?

    /**
     *
     * @param characteristics
     */
    var characteristics: String?

    /**
     * used to supply a SensorMemento.class in response to a caretaker (aka a Sensor.class) request. It contains the current state of the Originator (SensorInfo.class) object.
     */
    fun saveState(): SensorMomento?

    /**
     * used to restore the originator SensorInfo.class to a previous state. This state is contained in a SensorMemento.class (that comes as a method argument) from the caretaker Sensor.class. A caretaker Sensor.class sends this SensorMemento object that it saved earlier.
     * @param sensorMomento
     */
    fun restoreState(sensorMomento: SensorMomento?)

    /**
     * set a new state of an originator SensorInfo.
     * @param newState
     */
    fun setState(newState: SensorInfo?)
    val configuration: String?
}