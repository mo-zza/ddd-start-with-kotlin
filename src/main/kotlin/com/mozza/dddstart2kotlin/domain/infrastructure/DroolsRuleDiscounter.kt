package com.mozza.dddstart2kotlin.domain.infrastructure

import com.mozza.dddstart2kotlin.domain.model.OrderLine
import com.mozza.dddstart2kotlin.domain.model.value.Money
import org.kie.api.KieServices
import org.kie.api.runtime.KieContainer

class DroolsRuleDiscounter(private var kContainer: KieContainer) : RuleDiscounter {

    fun DroolsRuleEngine() {
        val ks = KieServices.Factory.get()
        kContainer = ks.kieClasspathContainer
    }

    override fun applyRules(customer: Customer, orderLines: List<OrderLine>): Money {
        val kSession = kContainer.newKieSession("discountSession")
        try {
            kSession.fireAllRules()
        } finally {
            kSession.dispose()
        }

        return money.toImmutableMoney();
    }
}