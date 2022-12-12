package com.mozza.dddstart2kotlin.domain.infrastructure

import com.mozza.dddstart2kotlin.domain.model.Product
import com.mozza.dddstart2kotlin.domain.service.ProductRecommendationService

class RecSystemClient(private val productRepository: ProductRepository): ProductRecommendationService {

    override fun getRecommendationOf(id: ProductId): List<Product> {
        val items = getRecItems(id.value)
        return toProducts(items)
    }

    private fun getRecItems(itemId: String): List<RecommendationItem> {
        return extenalRecClient.getRecs(itemId)
    }

    private fun toProducts(items: List<RecommendationItem>): List<Product> {
        return items.stream()
            .map { item -> toProductId(item.itemId) }
            .map { prodId -> productRepository.findById(prodId) }
            .collect(Collection::toList)
    }

    private fun toProductId(itemId: String): ProductId {
        return ProductId(itemId)
    }
}