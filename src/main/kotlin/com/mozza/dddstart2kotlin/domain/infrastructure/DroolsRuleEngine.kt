package com.mozza.dddstart2kotlin.domain.infrastructure

import org.apache.poi.ss.formula.functions.T
import org.kie.api.KieServices
import org.kie.api.runtime.KieContainer

class DroolsRuleEngine(private var kContainer: KieContainer) {

    fun DroolsRuleEngine(): DroolsRuleEngine {
        val ks = KieServices.Factory.get()
        kContainer = ks.kieClasspathContainer
        return this
    }

    fun evalute(sessionName: String, facts: List<T>) {
        val kSession = kContainer.newKieSession(sessionName)
        try {
            facts.forEach{x -> kSession.insert(x)}
            kSession.fireAllRules()
        } finally {
            kSession.dispose()
        }
    }
}