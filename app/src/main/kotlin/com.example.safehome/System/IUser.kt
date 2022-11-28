package com.example.safehome.System

import android.location.Address
import android.provider.ContactsContract.CommonDataKinds.Phone

interface IUser {
    /**
     *
     * @param name
     */
    var name: String?

    /**
     *
     * @param email
     */
    var email: String?

    /**
     *
     * @param addresses
     */
    var addresses: List<Address?>?

    /**
     *
     * @param systemIDs
     */
    var systemIDs: List<String?>?

    /**
     *
     * @param phones
     */
    var phones: List<Phone?>?

    /**
     *
     * @param addresses
     */
    fun setAddresses1(addresses: List<Address?>?)

    /**
     *
     * @param phones
     */
    fun setPhones1(phones: List<Phone?>?)

    /**
     *
     * @param addresses
     */
    fun setAddresses2(addresses: List<Address?>?)

    /**
     *
     * @param phones
     */
    fun setPhones2(phones: List<Phone?>?)

    /**
     *
     * @param addresses
     */
    fun setAddresses3(addresses: List<Address?>?)

    /**
     *
     * @param phones
     */
    fun setPhones4(phones: List<Phone?>?)
}