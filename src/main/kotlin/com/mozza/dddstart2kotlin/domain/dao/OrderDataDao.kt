package com.mozza.dddstart2kotlin.domain.dao

import com.mozza.dddstart2kotlin.domain.model.value.OrderNo
import java.util.Date

interface OrderDataDao {
    fun findById(id: OrderNo): OrderData?
    fun findByOrderer(ordererId: String, fromData: Date, toDate: Date): List<OrderData>
}