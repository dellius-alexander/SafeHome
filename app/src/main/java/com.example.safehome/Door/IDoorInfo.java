package com.example.safehome.Door;

import com.example.safehome.Door.DType;



public interface IDoorInfo {

	/**
	 * 
	 * @param type
	 * @param startCoordinates
	 * @param stopCoordinates
	 * @param nextWall
	 * @param symbol
	 */
	public void DoorInfo(String type, String startCoordinates, String stopCoordinates, String nextWall, Symbol symbol);

	public void getType();

	/**
	 * 
	 * @param Type
	 */
	public void setType(DType Type);

	public void getStartCoordinates();

	/**
	 * 
	 * @param startCoordinates
	 */
	public void setStartCoordinates(String startCoordinates);

	public void getStopCoordniates();

	/**
	 * 
	 * @param stopCoordniates
	 */
	public void setStopCoordniates(String stopCoordniates);

	public void getNextWall();

	/**
	 * 
	 * @param nextWall
	 */
	public void setNextWall(String nextWall);

	public Symbol getSymbol();

	/**
	 * 
	 * @param symbol
	 */
	public void setSymbol(Symbol symbol);

}