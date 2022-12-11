package com.mozza.dddstart2kotlin.application

class OrderListService {

    fun getOrderList(ordererId: String): List<OrderView> {
        return orderViewDao.selectByORderer(ordererId)
    }
}