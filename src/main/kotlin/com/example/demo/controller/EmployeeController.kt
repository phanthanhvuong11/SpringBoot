package com.example.demo.controller

import com.example.demo.exception.EmployeeException
import com.example.demo.repository.model.Employee
import com.example.demo.service.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@RestController
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping("/employees")
    fun getAllEmployees(): List<Employee> = employeeService.getAllEmployees()

    @GetMapping("/employees/{id}")
    fun getEmployeesById(@PathVariable("id") employeeId: Long): ResponseEntity<Any> {
        return if (employeeService.getEmployeesById(employeeId)) {
            ResponseEntity<Any>(employeeService.findEmployeeById(employeeId), HttpStatus.OK)
        } else {
            ResponseEntity<Any>(EmployeeException(HttpStatus.NOT_FOUND, "No matching employee was found"), HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/employees")
    fun createEmployee(@RequestBody payload: Employee): Employee = employeeService.createEmployee(payload)

    @PutMapping("/employees/{id}")
    fun updateEmployeeById(@PathVariable("id") employeeId: Long, @RequestBody payload: Employee): ResponseEntity<Any> {
        return if (employeeService.updateEmployeeById(employeeId, payload)) {
            ResponseEntity<Any>(Employee(employeeId, payload.userName, payload.firstName, payload.middleName, payload.lastName, payload.emailId, payload.dayOfBirth), HttpStatus.OK)
        }else {
            ResponseEntity<Any>(EmployeeException(HttpStatus.NOT_FOUND, "No matching employee was found"), HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployeesById(@PathVariable("id") employeeId: Long): ResponseEntity<Any> {
        return if (employeeService.deleteEmployeesById(employeeId)) {
            ResponseEntity<Any>(EmployeeException(HttpStatus.OK, "Employee delete successfully"),HttpStatus.OK)
        }else {
            ResponseEntity<Any>(EmployeeException(HttpStatus.NOT_FOUND, "No matching employee was found"), HttpStatus.NOT_FOUND)
        }
    }
}
