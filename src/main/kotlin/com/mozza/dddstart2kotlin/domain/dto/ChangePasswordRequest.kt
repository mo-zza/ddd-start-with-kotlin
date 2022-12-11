package com.mozza.dddstart2kotlin.domain.dto

data class ChangePasswordRequest(
    private val _memberId: String,
    private val _currentPassword: String,
    private val _newPassword: String
) {
    val memberId: String
        get() = _memberId.ifEmpty { "" }

    val currentPassword: String
        get() = _currentPassword.ifEmpty { "" }

    val newPassword: String
        get() = _newPassword.ifEmpty() { "" }
}
