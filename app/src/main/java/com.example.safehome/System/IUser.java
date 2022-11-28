package com.example.safehome.System;

import android.location.Address;
import android.provider.ContactsContract;

import java.util.List;

public interface IUser {

	String getName();

	/**
	 * 
	 * @param name
	 */
	void setName(String name);

	String getEmail();

	/**
	 * 
	 * @param email
	 */
	void setEmail(String email);

	List<Address> getAddresses();

	/**
	 * 
	 * @param addresses
	 */
	void setAddresses(List<Address> addresses);

	List<String> getSystemIDs();

	/**
	 * 
	 * @param systemIDs
	 */
	void setSystemIDs(List<String> systemIDs);

	List<ContactsContract.CommonDataKinds.Phone> getPhones();

	/**
	 * 
	 * @param phones
	 */
	void setPhones(List<ContactsContract.CommonDataKinds.Phone> phones);

	/**
	 * 
	 * @param addresses
	 */
	void setAddresses1(List<Address> addresses);

	/**
	 * 
	 * @param phones
	 */
	void setPhones1(List<ContactsContract.CommonDataKinds.Phone> phones);

	/**
	 * 
	 * @param addresses
	 */
	void setAddresses2(List<Address> addresses);

	/**
	 * 
	 * @param phones
	 */
	void setPhones2(List<ContactsContract.CommonDataKinds.Phone> phones);

	/**
	 * 
	 * @param addresses
	 */
	void setAddresses3(List<Address> addresses);

	/**
	 * 
	 * @param phones
	 */
	void setPhones4(List<ContactsContract.CommonDataKinds.Phone> phones);

}