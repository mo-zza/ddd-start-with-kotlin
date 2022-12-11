package com.mozza.dddstart2kotlin.lock

class LockId(private var _value: String) {

    fun LockId(value: String) {
        this._value = value
    }

    val value: String
        get() = _value.ifEmpty { "" }
}