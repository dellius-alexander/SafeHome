package Camera;

public class Camera {

	/**
	 * camera id
	 */
	private string id = null;
	private string type = null;
	/**
	 * camera location
	 */
	private string location = null;
	private string fieldOfView = null;
	private boolean twoWayAudio = null;
	private boolean nightVision = null;
	private string resolution = null;
	/**
	 * Defaults to false.
	 */
	private boolean hasPushNotifications = false;
	private string connectivity = null;
	private ConcreteCamera state;
	/**
	 * Defines the storage object.
	 */
	private Storage storage = null;

	public void setType(string type) {
		this.type = type;
	}

	public void setState(ConcreteCamera state) {
		this.state = state;
	}

	public ConcreteCamera saveState() {
		// TODO - implement Camera.saveState
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cameraMomemto
	 */
	public void restoreState(CameraMomemto cameraMomemto) {
		// TODO - implement Camera.restoreState
		throw new UnsupportedOperationException();
	}

}