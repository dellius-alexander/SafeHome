package com.example.safehome.Door

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class DoorInfo(
    /**
     *
     * @param type
     * @param startCoordinates
     * @param stopCoordinates
     * @param nextWall
     * @param symbol
     */
    private var type: String?,
    private var startCoordinates: String?,
    private var stopCoordinates: String?,
    private var nextWall: String?,
    private final var symbol: Symbol?
) : IDoorInfo {






    override fun getType() {
        TODO("Not yet implemented")
    }

    /**
     *
     * @param Type
     */
    override fun setType(Type: DType?) {
        TODO("Not yet implemented")
    }

    override fun getStartCoordinates() {
        TODO("Not yet implemented")
    }

    /**
     *
     * @param startCoordinates
     */
    override fun setStartCoordinates(startCoordinates: String?) {
        TODO("Not yet implemented")
    }

    override fun getStopCoordniates() {
        TODO("Not yet implemented")
    }

    /**
     *
     * @param stopCoordniates
     */
    override fun setStopCoordniates(stopCoordniates: String?) {
        TODO("Not yet implemented")
    }

    override fun getNextWall() {
        TODO("Not yet implemented")
    }

    /**
     *
     * @param nextWall
     */
    override fun setNextWall(nextWall: String?) {
        TODO("Not yet implemented")
    }

    /**
     *
     * @param symbol
     */
    override fun setSymbol(symbol: Symbol?){
        this.symbol = symbol
    }

    /**
     * some symbol
     * @return a symbol
     */
    override fun getSymbol(): Symbol?{
        return this.symbol
    }


    companion object{
        private val log: Logger = LoggerFactory.getLogger(DoorInfo::class.java)
    }
}