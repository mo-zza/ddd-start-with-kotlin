package com.mozza.dddstart2kotlin.domain.service

import com.mozza.dddstart2kotlin.domain.model.OrderLine
import com.mozza.dddstart2kotlin.domain.model.value.Money

interface RuleDiscounter {
    fun applyRules(customer: Customer, orderLines: List<OrderLine>): Money
}