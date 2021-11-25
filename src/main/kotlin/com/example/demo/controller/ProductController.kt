package com.example.demo.controller

import com.example.demo.exception.ProductException
import com.example.demo.repository.ProductRepository
import com.example.demo.repository.model.Product
import com.example.demo.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/v1/Products"])
class ProductController {

    //DI Dependency Injection
    @Autowired
    private lateinit var repository: ProductRepository

    @Autowired
    private lateinit var productService: ProductService

    @GetMapping("/getAllProducts")
    //this is url http://localhost:8080/api/v1/Products/getAllProducts
    fun getAllProducts(): List<Product> = repository.findAll()

//    @GetMapping("/getAllProduct/{id}")
//    fun findById(@PathVariable id: Long): ResponseEntity<ResponseObject?>? {
//        val product: Optional<Product> = repository.findById(id)
//        return if (product.isPresent) {
//            ResponseEntity.status(HttpStatus.OK).body(ResponseObject("True", "Query product successfully", product))
//        } else {
//            ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseObject("false", "Cannot find product with id = $id", null))
//        }
//    }

    @GetMapping("/getAllProducts/{id}")
    fun getEmployeesById(@PathVariable("id") productId: Long): ResponseEntity<Any> {
        return if (productService.findProductById(productId).isPresent) {
            ResponseEntity<Any>(ProductException(HttpStatus.OK, "Success", productService.findProductById(productId)), HttpStatus.OK)
        } else {
            ResponseEntity<Any>(ProductException(HttpStatus.NOT_FOUND, "No matching employee was found", productService.findProductById(productId)), HttpStatus.NOT_FOUND)
        }
    }
}