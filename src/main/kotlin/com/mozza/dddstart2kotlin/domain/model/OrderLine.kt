package com.mozza.dddstart2kotlin.domain.model

import com.mozza.dddstart2kotlin.domain.model.value.Money
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
class OrderLine(
    private var product: Product,
    private var quantity: Money,
    private var price: Int,
    private var amounts: Money?,
    private var lines: List<OrderLine>
) {

    @Embedded
    var productId: ProductId
        private set

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

    fun changeOrderLines(newLines: List<OrderLine>) {
        this.lines = newLines
    }
}