package com.example.demo.exception

import org.springframework.http.HttpStatus

data class EmployeeException(val status_code: HttpStatus, val reason: String)
