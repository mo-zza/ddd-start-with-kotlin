package com.mozza.dddstart2kotlin.domain.service

import com.mozza.dddstart2kotlin.domain.infrastructure.OrderRepository
import org.springframework.transaction.annotation.Transactional

open class CancelOrderService(private val orderRepository: OrderRepository) {

    @Transactional
    open fun cancelOrder(orderId: String) {
        val order = orderRepository.findById(orderId)
            .orElseThrow()
        order.cancel()
    }
}