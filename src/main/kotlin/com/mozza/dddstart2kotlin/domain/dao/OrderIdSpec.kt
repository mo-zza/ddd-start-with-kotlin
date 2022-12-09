package com.mozza.dddstart2kotlin.domain.dao

import com.mozza.dddstart2kotlin.domain.model.Order
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification

class OrderIdSpec(private var ordererId: String): Specification<OrderSummary> {

    fun OrdererSpec(ordererId: String) {
        this.ordererId = ordererId
    }

    override fun toPredicate(
        root: Root<Order>,
        query: CriteriaQuery<*>,
        criteriaBuilder: CriteriaBuilder
    ): Predicate? {
        return criteriaBuilder.equal(root.get(OrderSummary.ordererId), ordererId)
    }
}