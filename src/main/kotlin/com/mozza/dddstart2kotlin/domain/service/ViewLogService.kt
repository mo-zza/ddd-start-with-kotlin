package com.mozza.dddstart2kotlin.domain.service

import java.time.LocalDateTime

class ViewLogService(private val messageClient: MessageClient) {

    fun appendViewLog(memberId: String, productId: String, time: LocalDateTime) {
        messageClient.send(ViewLog(memberId, productId, time))
    }
}