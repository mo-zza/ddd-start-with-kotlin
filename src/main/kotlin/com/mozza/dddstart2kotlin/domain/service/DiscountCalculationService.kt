package com.mozza.dddstart2kotlin.domain.service

import com.mozza.dddstart2kotlin.domain.model.OrderLine
import com.mozza.dddstart2kotlin.domain.model.value.Money

class DiscountCalculationService {

    fun calculateDiscountAmounts( orderLines: List<OrderLine>, coupons: List<coupons>, grade: MemberGrade) {
        val couponDiscount = coupons.stream()
            .map {coupon -> calculateDiscount(coupon)}
            .reduce {Money(0), (v1, v2) -> v1.add(v2)}
        val membershipDiscount = calculateDiscount(orderer.getMember().getGrade())
        return couponDiscount.add(membershipDiscount)
    }

    private fun calculateDiscount(coupon: Coupon): Money {
        // ...
    }

    private fun calculateDiscount(grade: MemberGrade): Money {
        // ...
    }
}