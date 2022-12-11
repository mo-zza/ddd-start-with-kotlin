package com.mozza.dddstart2kotlin.domain.model

import java.lang.IllegalArgumentException

class Member(
    var pw: String
) {

    private var password: String = pw

    fun changePassword(memberId: String, oldPw: String, newPw: String) {
        if (!matchPassword(oldPw)) throw BadPasswordException()
        setPassword(newPw)
    }

    fun matchPassword(pwd: String): Boolean {
        return passwordEncoder.matches(pwd)
    }

    fun setPassword(newPw: String) {
        if (newPw.isEmpty()) throw IllegalArgumentException("no new password")
        this.password = newPw
    }
}