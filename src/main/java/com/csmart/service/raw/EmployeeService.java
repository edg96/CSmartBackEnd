package com.csmart.service.raw;

import com.csmart.model.Employee;
import com.csmart.repository.EmployeeRepository;
import com.csmart.service.impl.EmployeeServiceImpl;
import com.exception.general.TargetNotFoundException;
import com.exception.general.CNPNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService implements EmployeeServiceImpl
{
    private final EmployeeRepository employeeRepository;
    private final ContractService contractService;
    private final AddressService addressService;

    public List<Employee> findAll()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        if(employeeList.isEmpty())
            throw new TargetNotFoundException("The list of employees is empty.");

        return new ArrayList<>(employeeList);
    }

    public Employee findById(UUID employeeId) throws TargetNotFoundException
    {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if(employeeOptional.isEmpty())
            throw new TargetNotFoundException("No employee with the specified ID was found in the database.");

        return employeeOptional.get();
    }

    public Employee findByCnp(String Cnp) throws CNPNotFoundException
    {
        Optional<Employee> employeeOptional = employeeRepository.findByCnp(Cnp);
        if(employeeOptional.isEmpty())
            throw new CNPNotFoundException("No employee with the specified CNP was found in the database.");

        return employeeOptional.get();
    }

    public Employee save(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public Employee update(UUID employeeId, Employee employee)
    {
        Employee extractedEmployee = employeeRepository.getById(employeeId);
        extractedEmployee = employee;
        return employeeRepository.save(extractedEmployee);
    }

    public void deleteAll() throws TargetNotFoundException { employeeRepository.deleteAll(); }

    public void deleteSingle(Employee employee) throws TargetNotFoundException
    {
        employeeRepository.deleteById(employee.getEmployeeId());
        contractService.deleteById(employee.getContract().getContractId());
        addressService.deleteById(employee.getAddress().getAddressId());
    }

    public void deleteById(UUID id) throws TargetNotFoundException { employeeRepository.deleteById(id); }
}
