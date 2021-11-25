package com.example.demo.exception

import org.springframework.http.HttpStatus

data class ProductException(val status_code: HttpStatus, val reason: String, val data: Any)
