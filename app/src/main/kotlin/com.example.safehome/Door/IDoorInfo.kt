package com.example.safehome.Door

interface IDoorInfo {
    /**
     * Get the door type
     */
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
    fun setSymbol(symbol: Symbol?)

    fun getSymbol(): Symbol?
}