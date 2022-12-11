package com.mozza.dddstart2kotlin.domain.dto

data class JoinRequest(
    private val _id: String,
    private val _name: String,
    private val _password: String
) {
    val id: String
        get() = _id.ifEmpty { "" }

    val name: String
        get() = _name.ifEmpty { "" }

    val password: String
        get() = _password.ifEmpty { "" }

    fun getConfirmPassword(): String {
        return this.password
    }
}
