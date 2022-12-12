package com.mozza.dddstart2kotlin.domain.infrastructure

class RabbitMQClient(private val rabbitTemplate: RabbitTemplate): MessageClient {

    override fun send(viewLog: ViewLog) {
        rabbitTemplate.convertAndSend(logQueueName, viewLog)
    }
}