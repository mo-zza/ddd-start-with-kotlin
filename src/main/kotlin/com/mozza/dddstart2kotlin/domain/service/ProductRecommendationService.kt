package com.mozza.dddstart2kotlin.domain.service

import org.apache.commons.math3.stat.descriptive.summary.Product

interface ProductRecommendationService {

    fun getRecommendationOf(id: ProductId): List<Product>
}