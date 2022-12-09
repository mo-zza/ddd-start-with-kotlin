package com.mozza.dddstart2kotlin.domain.infrastructure

import com.mozza.dddstart2kotlin.domain.dao.Specification
import com.mozza.dddstart2kotlin.domain.model.Order

class MemoryOrderRepository: OrderRepository {

    fun findAll(spec: Specification<Order>): List<Order> {
        val allOrders = findAll()
        return allOrders.stream()
            .filter { order -> spec.isSatisfiedBy(order)}
            .toList()
    }
}