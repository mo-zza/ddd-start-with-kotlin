package com.mozza.dddstart2kotlin.domain.service

import com.mozza.dddstart2kotlin.domain.infrastructure.DroolsRuleEngine
import com.mozza.dddstart2kotlin.domain.infrastructure.RuleDiscounter
import com.mozza.dddstart2kotlin.domain.model.OrderLine
import com.mozza.dddstart2kotlin.domain.model.value.Money

class CalculateDiscountService(private var ruleDiscounter: RuleDiscounter) {

    fun CalculateDiscountService(ruleDiscounter: RuleDiscounter): CalculateDiscountService {
        this.ruleDiscounter = ruleDiscounter
        return this
    }

    fun calculateDiscount(orderLines: List<OrderLine>, customerId: String): Money {
        val customer = findCustomer(customerId)
        return ruleDiscounter.applyRules(customer, orderLines)

        // ...
    }
}