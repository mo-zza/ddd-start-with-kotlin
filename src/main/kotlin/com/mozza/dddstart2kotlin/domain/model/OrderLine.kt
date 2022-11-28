package com.mozza.dddstart2kotlin.domain.model

class OrderLine(
    var product: Product,
    var quantity: Int,
    var price: Int,
    var amounts: Int?,
) {

    fun OrderLine(product: Product, price: Int, quantity: Int) {
        this.product = product
        this.price = price
        this.quantity = quantity
        this.amounts = calculateAmount()
    }

    private fun calculateAmount(): Int {
        return price * quantity
    }

    fun getAmounts(): Int {
        return calculateAmount()
    }
}