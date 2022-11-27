package System;

public interface IUser {

	string getName();

	/**
	 * 
	 * @param name
	 */
	void setName(string name);

	string getEmail();

	/**
	 * 
	 * @param email
	 */
	void setEmail(string email);

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

	List<Phone> getPhones();

	/**
	 * 
	 * @param phones
	 */
	void setPhones(List<Phone> phones);

	/**
	 * 
	 * @param addresses
	 */
	void setAddresses1(List<Address> addresses);

	/**
	 * 
	 * @param phones
	 */
	void setPhones1(List<Phone> phones);

	/**
	 * 
	 * @param addresses
	 */
	void setAddresses2(List<Address> addresses);

	/**
	 * 
	 * @param phones
	 */
	void setPhones2(List<Phone> phones);

	/**
	 * 
	 * @param addresses
	 */
	void setAddresses3(List<Address> addresses);

	/**
	 * 
	 * @param phones
	 */
	void setPhones4(List<Phone> phones);

}