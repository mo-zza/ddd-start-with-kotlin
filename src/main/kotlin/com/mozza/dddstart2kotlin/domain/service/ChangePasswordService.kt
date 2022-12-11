package com.mozza.dddstart2kotlin.domain.service

import java.lang.IllegalArgumentException

class ChangePasswordService(private val memberRepository: MemberRepository) {

    fun changePassword(memberId: String, oldPw: String, newPw: String) {
        val member = memberRepository.findById(memberId)
        checkMemberExists(member)
        member.changePassword(oldPw, newPw)
    }
}