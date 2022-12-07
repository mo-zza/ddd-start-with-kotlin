package com.mozza.dddstart2kotlin.domain.model.value

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class OrderNo(private val orderNumber: String): Serializable {

    @Column(name = "order_number")
    var number: String = orderNumber
        private set
}