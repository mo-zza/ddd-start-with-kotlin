package com.mozza.dddstart2kotlin.application

import com.mozza.dddstart2kotlin.domain.dto.ChangePasswordRequest

interface ChangePasswordService {
    fun changePassword(req: ChangePasswordRequest)
}