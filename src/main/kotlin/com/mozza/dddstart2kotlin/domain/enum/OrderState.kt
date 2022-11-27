package com.mozza.dddstart2kotlin.domain.enum

enum class OrderState {
    PAYMENT_WAITING,
    PREPARING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED;
}