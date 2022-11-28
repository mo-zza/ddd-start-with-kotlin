package com.mozza.dddstart2kotlin.domain.model

import com.mozza.dddstart2kotlin.domain.model.value.Address
import com.mozza.dddstart2kotlin.domain.model.value.Receiver

class ShippingInfo(
    val receiver: Receiver,
    val address: Address
) {
}