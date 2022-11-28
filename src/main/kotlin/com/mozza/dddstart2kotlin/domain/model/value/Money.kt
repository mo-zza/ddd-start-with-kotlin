package com.mozza.dddstart2kotlin.domain.model.value

class Money(
    private var value: Int,
) {

    fun Money(value: Int) {
        this.value = value
    }

    fun getValue(): Int {
        return value
    }

    fun add(money: Money) {
        return Money(value + money.getValue())
    }

    fun multiply(multiplier: Int) {
        return Money(value * multiplier)
    }
}