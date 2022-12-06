package com.mozza.dddstart2kotlin.domain.model

import jakarta.persistence.CollectionTable
import jakarta.persistence.ElementCollection
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class Product(
    private val id: ProductId,
) {

    @Embedded
    var id: ProductId = id
    private set

    @ElementCollection
    @CollectionTable(name = "proudct_category", joinColumns = @JoinColumn(name = "product_id"))
    var categoryIds: Set<CategoryId>
    private set
}