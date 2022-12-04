package com.mozza.dddstart2kotlin.domain.service

import com.mozza.dddstart2kotlin.domain.infrastructure.DroolsRuleEngine
import com.mozza.dddstart2kotlin.domain.model.OrderLine
import com.mozza.dddstart2kotlin.domain.model.value.Money

class CalculateDiscountService(private var ruleEngine: DroolsRuleEngine) {

    fun CalculateDiscountService() {
        ruleEngine = DroolsRuleEngine()
    }

    fun calculateDiscount(orderLines: List<OrderLine>, customerId: String): Money {
        val customer = findCustomer(customerId)

        // ...
    }
}