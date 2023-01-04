package com.example.CSmartBackEnd.controller.employee;


import com.csmart.controller.EmployeeController;
import com.csmart.dto.AddressDto;
import com.csmart.dto.ContractDto;
import com.csmart.dto.EmployeeDto;
import com.csmart.model.Address;
import com.csmart.model.Contract;
import com.csmart.model.Employee;
import com.csmart.repository.EmployeeRepository;
import com.csmart.service.raw.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Employee employee;
    private Address address;
    private Contract contract;

    @BeforeEach
    public void cleanUpDatabase()
    {
        Address addressDto = Address.builder()
                .county("Ialomita")
                .locality("Popesti Leordeni")
                .street("Amurgului")
                .streetNumber("7")
                .blockNumber("4")
                .stairNumber("36")
                .floor(1)
                .apartmentNumber(2)
                .build();

        Contract contract = Contract.builder()
                .contractType("FULLTIME")
                .workHoursPerDay(3)
                .legalDaysOff(29)
                .brutSalary(400.0)
                .build();

        Employee employee = Employee.builder()
                .cnp("123456789012")
                .firstName("Popescu")
                .lastName("Ionut")
                .studies("Liceu")
                .role("Instalator")
                .employmentDate(new Date("08/04/2022"))
                .address(address)
                .contract(contract)
                .build();

        employeeRepository.deleteAll();
        employee = employeeRepository.save(employee);
    }

    @Test
    public void testFindAll() throws Exception
    {
        AddressDto addressDto = AddressDto.builder()
                .countyDto("Ialomita")
                .localityDto("Popesti Leordeni")
                .streetDto("Amurgului")
                .streetNumberDto("7")
                .blockNumberDto("4")
                .stairNumberDto("36")
                .floorDto(1)
                .apartmentNumberDto(2)
                .build();

        ContractDto contractDto = ContractDto.builder()
                .contractTypeDto("FULLTIME")
                .workHoursPerDayDto(3)
                .legalDaysOffDto(29)
                .brutSalaryDto(400.0)
                .build();

        EmployeeDto employeeDto = EmployeeDto.builder()
                .cnpDto("123456789012")
                .firstNameDto("Popescu")
                .lastNameDto("Ionut")
                .studiesDto("Liceu")
                .roleDto("Instalator")
                .employmentDateDto(new Date("08/04/2022"))
                .addressDto(addressDto)
                .contractDto(contractDto)
                .build();

        mockMvc.perform(get("/find/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(employeeDto)));
    }
}
