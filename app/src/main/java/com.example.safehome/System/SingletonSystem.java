package System;

public class SingletonSystem {

	private static System instance = null;

	public System getInstance() {
		return this.instance;
	}

	private SingletonSystem() {
		// TODO - implement SingletonSystem.SingletonSystem
		throw new UnsupportedOperationException();
	}

}