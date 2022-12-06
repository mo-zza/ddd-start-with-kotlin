package com.mozza.dddstart2kotlin.domain.model

import com.mozza.dddstart2kotlin.domain.enum.OrderState
import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Entity
import jakarta.persistence.Table

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD)
class Order(
    private val number: OrderNo,
    private val orderNumber: String,
    private var state: OrderState,
    private var orderLines: MutableList<OrderLine>,
    private var totalAmounts: Money,
    private var shippingInfo: ShippingInfo,
) {

    var number: OrderNo = number
    private set

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Order

        if (orderNumber != other.orderNumber) return false

        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + getOrderNumber()
        return result
    }

    private fun getOrderNumber(): Int {
        return when {
            orderNumber.isEmpty() -> 0
            else -> orderNumber.hashCode()
        }
    }

    fun Order(orderLines: MutableList<OrderLine>, shippingInfo: ShippingInfo) {
        verifyNotYetShipped()
        setOrderLines(orderLines)
        setShippingInfo(shippingInfo)
    }

    @JvmName("setOrderLines1")
    private fun setOrderLines(orderLines: MutableList<OrderLine>) {
        verifyAtLeastOneOrMoreOrderLines(orderLines)
        this.orderLines = orderLines
        calculateTotalAmounts()
    }

    private fun verifyAtLeastOneOrMoreOrderLines(orderLines: MutableList<OrderLine>) {
        if (orderLines.isEmpty()) {
            throw IllegalArgumentException("no OrderLine")
        }
    }

    private fun calculateTotalAmounts() {
        val sum = orderLines.stream()
            .mapToInt { value -> value.getAmounts() * value.getAmounts() }
            .sum()
        this.totalAmounts = Money(sum)
    }

    @JvmName("setShippingInfo1")
    private fun setShippingInfo(newShippingInfo: ShippingInfo) {
        this.shippingInfo = newShippingInfo
    }

    fun changeShipped() {
        // TODO: implement
    }

    fun changeShippingInfo(newShippingIngo: ShippingInfo) {
        checkShippingInfoChangeable();
        if (isShippingChangeable().not()) {
            throw IllegalStateException("can't change shipping in " + state)
        }
        this.shippingInfo = newShippingIngo
    }

    private fun checkShippingInfoChangeable() {
        // ...
    }

    fun cancel() {
        verifyNotYetShipped()
        this.state = OrderState.CANCELED
    }

    private fun verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw IllegalStateException("already shipped")
        }
    }

    fun completePayment() {
        // TODO: implement
    }

    private fun isShippingChangeable(): Boolean {
        return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING
    }
}