package com.mozza.dddstart2kotlin.domain.model.value

class Receiver(
    private var name: String,
    private var phoneNumber: String,
) {

    fun Receiver(name: String, phoneNumber: String) {
        this.name = name
        this.phoneNumber = phoneNumber
    }

    fun getName(): String {
        return name
    }

    fun getPhoneNumber(): String {
        return phoneNumber
    }
}