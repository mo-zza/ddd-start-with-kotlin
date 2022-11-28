package com.mozza.dddstart2kotlin.domain.model

import com.mozza.dddstart2kotlin.domain.model.value.Money

class OrderLine(
    var product: Product,
    var quantity: Money,
    var price: Int,
    var amounts: Money?,
) {

    fun OrderLine(product: Product, price: Int, quantity: Money) {
        this.product = product
        this.price = price
        this.quantity = quantity
        this.amounts = Money(calculateAmount())
    }

    private fun calculateAmount(): Int {
        return price * quantity.getValue()
    }

    fun getAmounts(): Int {
        return calculateAmount()
    }
}