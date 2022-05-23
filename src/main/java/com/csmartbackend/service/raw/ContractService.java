package com.csmartbackend.service.raw;

import com.csmartbackend.dto.ContractDto;
import com.csmartbackend.mapper.ContractMapper;
import com.csmartbackend.model.Contract;
import com.csmartbackend.repository.ContractRepository;
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
public class ContractService
{
    private final ContractRepository contractRepository;

    public List<ContractDto> findAll()
    {
        List<Contract> contractList = contractRepository.findAll();
        if(contractList.isEmpty() || contractList == null)
            throw new TargetNotFoundException();

        ContractMapper contractMapper = ContractMapper.getInstance();
        return contractList.stream()
                .map(contractMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public ContractDto save(Contract contract)
    {
        contractRepository.save(contract);
        return ContractMapper.getInstance().entityToDto(contract);
    }

    public void deleteById(UUID id) { contractRepository.deleteById(id); }
}
