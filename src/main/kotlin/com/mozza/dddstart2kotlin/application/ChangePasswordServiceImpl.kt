package com.mozza.dddstart2kotlin.application

import com.mozza.dddstart2kotlin.domain.dto.ChangePasswordRequest
import com.mozza.dddstart2kotlin.domain.infrastructure.MemberRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.transaction.annotation.Transactional

open class ChangePasswordServiceImpl(private val memberRepository: MemberRepository):
    ChangePasswordService {

    @Transactional
    @PreAuthorize("hasRole('ADMIN)")
    override fun changePassword(req: ChangePasswordRequest) {
        val memberId = req.memberId
        val member = memberRepository.findById(memberId).orElseThrow { throw NotFoundException() }
        member.changePassword(memberId, req.currentPassword, req.newPassword)
    }
}