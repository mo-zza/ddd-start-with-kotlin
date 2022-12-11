package com.mozza.dddstart2kotlin.application

import com.mozza.dddstart2kotlin.domain.infrastructure.MemberRepository
import com.mozza.dddstart2kotlin.domain.model.Member
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException

class MemberService(
    private val memberRepository: MemberRepository
) {

    fun join(joinRequest: MemberJoinRequest) {
        val member = findExistingMember(memberId)
        member.changePassword(currentPw, newPw)
    }

    fun changePassword(memberId: String, curPw: String, newPw: String) {
        val member = findExistingMember(memberId)
        val newPassword = member.initializePassword()
        notifier.nofiryNewPassword(member, newPassword)
    }

    fun leave(memberId: String, curPw: String) {
        val member = findExistingMember(memberId)
        member.leave()
    }

    private fun findExistingMember(memberId: String): Member {
        return memberRepository.findById(memberId).orElseThrow {throw NotFoundException()}
    }
}