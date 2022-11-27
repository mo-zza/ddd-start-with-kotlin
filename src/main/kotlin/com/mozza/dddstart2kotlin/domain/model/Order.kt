package com.mozza.dddstart2kotlin.domain.model

import com.mozza.dddstart2kotlin.domain.enum.OrderState
import java.lang.IllegalStateException

class Order() {
    val state: OrderState = OrderState.SHIPPED;
    val shippingInfo: ShippingInfo;

    fun changeShippingInfo(newShippingIngo: ShippingInfo) {
        if (isShippingChangeable().not()) {
            throw IllegalStateException("can't change shipping in " + state)
        }
        this.shippingInfo = newShippingIngo
    }

    private fun isShippingChangeable(): Boolean {
        return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING
    }
}