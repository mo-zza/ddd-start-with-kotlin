package com.mozza.dddstart2kotlin.domain.dao

import jakarta.persistence.criteria.Root
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Order
import org.springframework.data.jpa.domain.Specification

class OrderSummarySpecs {

    companion object {
        fun orderId(ordererId: String): Specification<Order> {
            return root: Root<Order>, query: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder -> {
                criteriaBuilder(
                    root.get(Order.orderDate), from, to
                )
            }
        }
    }

    fun static Specification<OrderSummary> orderDateBetween (from: LocalDateTime, to: LocalDateTime) {

    }
}