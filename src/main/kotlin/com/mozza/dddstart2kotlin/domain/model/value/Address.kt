package com.mozza.dddstart2kotlin.domain.model.value

class Address(
    private var address1: String,
    private var address2: String,
    private var zipCode: String,
) {

    fun Address(address1: String, address2: String, zipCode: String) {
        this.address1 = address1
        this.address2 = address2
        this.zipCode = zipCode
    }

    fun getAddress1(): String {
        return address1
    }

    fun getAddress2(): String {
        return address2
    }

    fun getZipCode(): String {
        return zipCode
    }
}