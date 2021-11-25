package com.example.demo.service

import com.example.demo.repository.ProductRepository
import com.example.demo.repository.model.Product
import org.springframework.stereotype.Service
import java.util.*

/**
 * Service for interactions with employee domain object
 */
@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getProduct(): List<Product> = productRepository.findAll()

    fun getProductById(productId: Long): Boolean {
        return productRepository.existsById(productId)
    }

    fun findProductById(productId: Long): Optional<Product> = productRepository.findById(productId)

    fun createProduct(product: Product): Product = productRepository.save(product)

    fun updateEmployeeById(productId: Long, product: Product): Boolean {
        return if (productRepository.existsById(productId)) {
            productRepository.save(
                    Product(
                            id = productId,
                            productName = product.productName,
                            year = product.year,
                            price = product.price,
                            url = product.url
                    )
            )
            true
        } else false
    }

    fun deleteProductById(productId: Long): Boolean {
        return if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId)
            true
        } else false
    }
}
