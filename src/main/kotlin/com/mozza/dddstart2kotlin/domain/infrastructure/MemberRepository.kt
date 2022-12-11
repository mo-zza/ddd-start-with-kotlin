package com.mozza.dddstart2kotlin.domain.infrastructure

import com.mozza.dddstart2kotlin.domain.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, String> {
    fun countsById(id: String): Int
}