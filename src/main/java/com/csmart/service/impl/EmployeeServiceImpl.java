package com.csmart.service.impl;

import com.csmart.model.Employee;
import com.exception.general.TargetNotFoundException;
import com.exception.general.CNPNotFoundException;
import com.exception.general.InvalidIdException;

import java.util.List;
import java.util.UUID;

public interface EmployeeServiceImpl
{
    List<Employee> findAll() throws TargetNotFoundException;
    Employee findById(UUID employeeId) throws InvalidIdException;
    Employee save(Employee employee);
    void deleteAll() throws TargetNotFoundException;
    void deleteSingle(Employee employee) throws TargetNotFoundException;
    void deleteById(UUID id) throws InvalidIdException;
    Employee findByCnp(String CNP) throws CNPNotFoundException;
}
