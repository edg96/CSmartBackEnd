package com.csmartbackend.service.raw;

import com.csmartbackend.dto.CompanyDto;
import com.csmartbackend.mapper.CompanyMapper;
import com.csmartbackend.model.Company;
import com.csmartbackend.repository.CompanyRepository;
import com.exception.general.TargetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService
{
    private final CompanyRepository companyRepository;

    public List<CompanyDto> findAll()
    {
        List<Company> companyList = companyRepository.findAll();
        if(companyList.isEmpty() || companyList == null)
            throw new TargetNotFoundException();

        CompanyMapper companyMapper = CompanyMapper.getInstance();
        return companyList.stream()
                .map(companyMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public CompanyDto save(Company company)
    {
        companyRepository.save(company);

        return CompanyMapper.getInstance().entityToDto(company);
    }

    public void deleteAll() throws TargetNotFoundException { companyRepository.deleteAll(); }

    public void deleteSingle(Company company) throws TargetNotFoundException { companyRepository.delete(company); }

    public void deleteById(UUID id) throws TargetNotFoundException { companyRepository.deleteById(id); }
}
