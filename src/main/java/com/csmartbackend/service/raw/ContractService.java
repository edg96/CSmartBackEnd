package com.csmartbackend.service.raw;

import com.csmartbackend.model.Contract;
import com.csmartbackend.repository.ContractRepository;
import com.exception.general.TargetNotFoundException;
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
public class ContractService
{
    private final ContractRepository contractRepository;

    public List<Contract> findAll()
    {
        List<Contract> contractList = contractRepository.findAll();
        if(contractList.isEmpty())
            throw new TargetNotFoundException("The list of contracts is empty.");

        return new ArrayList<>(contractList);
    }

    public Contract findById(UUID contractId) throws TargetNotFoundException
    {
        Optional<Contract> contractOptional = contractRepository.findById(contractId);
        if(contractOptional.isEmpty())
            throw new TargetNotFoundException("No contract with the specified ID was found in the database.");

        return contractOptional.get();
    }

    public Contract save(Contract contract)
    {
        return contractRepository.save(contract);
    }

    public Contract update(UUID contractId, Contract contract)
    {
        Contract extractedContract = contractRepository.getById(contractId);
        extractedContract = contract;
        return contractRepository.save(extractedContract);
    }

    public void deleteAll() throws TargetNotFoundException { contractRepository.deleteAll(); }

    public void deleteSingle(Contract contract) throws TargetNotFoundException { contractRepository.deleteById(contract.getContractId()); }

    public void deleteById(UUID id) throws TargetNotFoundException { contractRepository.deleteById(id); }
}
