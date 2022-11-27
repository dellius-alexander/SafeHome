package Door;

public abstract class IDoorInfo {

	/**
	 * 
	 * @param type
	 * @param startCoordinates
	 * @param stopCoordinates
	 * @param nextWall
	 * @param symbol
	 */
	public abstract void DoorInfo(string type, string startCoordinates, string stopCoordinates, string nextWall, Symbol symbol);

	public abstract void getType();

	/**
	 * 
	 * @param Type
	 */
	public abstract void setType(DType Type);

	public abstract void getStartCoordinates();

	/**
	 * 
	 * @param startCoordinates
	 */
	public abstract void setStartCoordinates(string startCoordinates);

	public abstract void getStopCoordniates();

	/**
	 * 
	 * @param stopCoordniates
	 */
	public abstract void setStopCoordniates(string stopCoordniates);

	public abstract void getNextWall();

	/**
	 * 
	 * @param nextWall
	 */
	public abstract void setNextWall(string nextWall);

	public abstract Symbol getSymbol();

	/**
	 * 
	 * @param symbol
	 */
	public abstract void setSymbol(Symbol symbol);

}