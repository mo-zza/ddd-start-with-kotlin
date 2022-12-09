package com.mozza.dddstart2kotlin.domain.dao

interface Specification<T> {
    fun isSatisfiedBy(agg: T): Boolean
}