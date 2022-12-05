package com.mozza.dddstart2kotlin.domain.infrastructure

import com.mozza.dddstart2kotlin.domain.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, String> {
    fun findByOrderNumber(number: String): Order?

    fun save(order: Order)

    override fun delete(order: Order)
}