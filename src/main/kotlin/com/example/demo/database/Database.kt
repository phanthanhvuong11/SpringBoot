package com.example.demo.database

import com.example.demo.repository.ProductRepository
import com.example.demo.repository.model.Product
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Database {
    //logger

    @Bean
    fun initDatabase(productRepository: ProductRepository): CommandLineRunner? {
        return CommandLineRunner {
            val productA = Product(1L, "Macbook Air", 2017, 27000.0, "ssda")
            val productB = Product(2L, "Macbook", 2019, 26000.0, "")
            productRepository.save(productA)
            productRepository.save(productB)
        }
    }
}