package com.mozza.dddstart2kotlin.domain.service

import com.mozza.dddstart2kotlin.domain.infrastructure.OrderRepository
import com.mozza.dddstart2kotlin.domain.model.ShippingInfo
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.transaction.annotation.Transactional

class ChangeOrderService(private val orderRepository: OrderRepository) {

    @Transactional
    fun changeShippingInfo(no: OrderNo, newShippingInfo: ShippingInfo) {
        val order = orderRepository.findById(no).orElseThrow {throw NotFoundException()}
        order.changeShippingInfo(newShippingInfo)
    }
}
