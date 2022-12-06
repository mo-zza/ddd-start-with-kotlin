package com.mozza.dddstart2kotlin.domain.service

import com.mozza.dddstart2kotlin.domain.model.Product

class RegisterProductService {

    fun registerNewProduct(req: NewProductRequest) {
        val store = storeRepository.findById(req.storeId)
        checkNull(store)
        val id = productRepository.nextId()
        val product = store.createProduct(id, store.id)
        productRepository.save(product)
        return id
    }
}