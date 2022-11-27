package com.example.safehome.Camera;

public interface Storage<Object> {

	/**
	 * 
	 * @param storage
	 */
	void addStorage(Object storage);

	Object getStorage();

}