package com.example.safehome.Door

interface IDoorInfo {
    /**
     *
     * @param type
     * @param startCoordinates
     * @param stopCoordinates
     * @param nextWall
     * @param symbol
     */
    fun DoorInfo(
        type: String?,
        startCoordinates: String?,
        stopCoordinates: String?,
        nextWall: String?,
        symbol: Symbol?
    )

    fun getType()

    /**
     *
     * @param Type
     */
    fun setType(Type: DType?)
    fun getStartCoordinates()

    /**
     *
     * @param startCoordinates
     */
    fun setStartCoordinates(startCoordinates: String?)
    fun getStopCoordniates()

    /**
     *
     * @param stopCoordniates
     */
    fun setStopCoordniates(stopCoordniates: String?)
    fun getNextWall()

    /**
     *
     * @param nextWall
     */
    fun setNextWall(nextWall: String?)

    /**
     *
     * @param symbol
     */
    var symbol: Symbol?
}