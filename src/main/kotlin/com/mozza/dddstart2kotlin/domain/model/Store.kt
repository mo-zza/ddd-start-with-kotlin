package com.mozza.dddstart2kotlin.domain.model

class Store {

    fun createProduct(newProductId: ProductId): Product {
        if (isBlocked()) throw StoreBockedException()
        return Product()
    }
}