package com.mozza.dddstart2kotlin.domain.model

import com.mozza.dddstart2kotlin.domain.enum.OrderState

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class Order(
    private var state: OrderState,
    private var orderLines: MutableList<OrderLine>,
    private var totalAmounts: Money,
    private var shippingInfo: ShippingInfo,
) {

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
        this.totalAmounts = new Money(orderLines.stream()
            .mapToInt(OrderLine::getAmounts)
            .sum())
    }

    @JvmName("setShippingInfo1")
    private fun setShippingInfo(shippingInfo: ShippingInfo) {
        this.shippingInfo = shippingInfo
    }

    fun changeShipped() {
        // TODO: implement
    }

    fun changeShippingInfo(newShippingIngo: ShippingInfo) {
        if (isShippingChangeable().not()) {
            throw IllegalStateException("can't change shipping in " + state)
        }
        this.shippingInfo = newShippingIngo
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