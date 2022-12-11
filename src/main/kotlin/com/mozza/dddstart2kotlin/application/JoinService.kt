package com.mozza.dddstart2kotlin.application

import com.mozza.dddstart2kotlin.domain.dto.JoinRequest
import com.mozza.dddstart2kotlin.domain.infrastructure.MemberRepository
import org.springframework.transaction.annotation.Transactional
import kotlin.IllegalArgumentException

open class JoinService(private val memberRepository: MemberRepository) {

    @Transactional
    open fun join(joinReq: JoinRequest) {
        checkEmpty(joinReq.id, "id")
        checkEmpty(joinReq.name, "name")
        checkEmpty(joinReq.password, "password")
        if (joinReq.password.equals(joinReq.getConfirmPassword()))
            throw IllegalArgumentException("confirmPassword")
    }

    private fun checkEmpty(value: String?, propertyName: String) {
        if (value.isNullOrEmpty()) throw IllegalArgumentException(propertyName)
    }

    private fun checkDuplicatedId(id: String) {
        val count = memberRepository.countsById(id)
        if (count > 0) throw IllegalArgumentException()
    }
}