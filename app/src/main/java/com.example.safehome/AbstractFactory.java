package com.example.safehome;

/**
 * AbstractFactory is a centralize decision of what factory to instantiate.  The Factory method pattern is responsible for the creation of an object of a specific type.
 */
public interface AbstractFactory<Object> {

	/**
	 * FactoryMethod returns class of type Object.
	 * @param request
	 * @return FactoryMethod returns class of type Object.
	 */
	Object factoryMethod(Object request);

}