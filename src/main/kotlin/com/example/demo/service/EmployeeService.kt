package com.example.demo.service

import com.example.demo.repository.EmployeeRepository
import com.example.demo.repository.model.Employee
import org.springframework.stereotype.Service
import java.util.*

/**
 * Service for interactions with employee domain object
 */
@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    fun getEmployeesById(employeeId: Long): Boolean {
        return employeeRepository.existsById(employeeId)
    }

    fun findEmployeeById(employeeId: Long): Optional<Employee> = employeeRepository.findById(employeeId)

    fun createEmployee(employee: Employee): Employee = employeeRepository.save(employee)

    fun updateEmployeeById(employeeId: Long, employee: Employee): Boolean {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.save(
                    Employee(
                            id = employeeId,
                            userName = employee.userName,
                            firstName = employee.firstName,
                            middleName = employee.middleName,
                            lastName = employee.lastName,
                            emailId = employee.emailId,
                            dayOfBirth = employee.dayOfBirth
                    )
            )
            true
        } else false
    }

    fun deleteEmployeesById(employeeId: Long): Boolean {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId)
            true
        } else false
    }
}
