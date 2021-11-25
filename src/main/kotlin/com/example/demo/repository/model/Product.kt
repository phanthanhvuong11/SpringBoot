package com.example.demo.repository.model

import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        @Column(name = "product_name", unique = true, nullable = false)
        val productName: String,
        @Column(name = "year", nullable = false)
        val year: Int,
        @Column(name = "price", nullable = false)
        val price: Double,
        @Column(name = "url", nullable = false)
        val url: String,
) {
    override fun toString(): String {
        return "Product{\nid=$id\nproductName=$productName\nyear=$year\nprice=$price\nurl=$url\n}"
    }
}
