package com.example.safehome.System;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SingletonSystem {
	private static final Logger log = LoggerFactory.getLogger(SingletonSystem.class);
	private static System instance = null;

	public System getInstance() {
		return this.instance;
	}

	private SingletonSystem() {
		// TODO - implement SingletonSystem.SingletonSystem
		throw new UnsupportedOperationException();
	}

}