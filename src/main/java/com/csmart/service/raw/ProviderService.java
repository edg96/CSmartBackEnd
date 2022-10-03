package com.csmart.service.raw;

import com.csmart.model.Provider;
import com.csmart.repository.ProviderRepository;
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
public class ProviderService
{
    private final ProviderRepository providerRepository;

    public List<Provider> findAll()
    {
        List<Provider> providerList = providerRepository.findAll();
        if(providerList.isEmpty())
            throw new TargetNotFoundException("The list of providers is empty.");

        return new ArrayList<>(providerList);
    }

    public Provider findById(UUID providerId) throws TargetNotFoundException
    {
        Optional<Provider> providerOptional = providerRepository.findById(providerId);
        if(providerOptional.isEmpty())
            throw new TargetNotFoundException("No provider with the specified ID was found in the database.");

        return providerOptional.get();
    }

    public Provider save(Provider provider)
    {
        return providerRepository.save(provider);
    }

    public Provider update(UUID providerId, Provider provider)
    {
        Provider extractedProvider = providerRepository.getById(providerId);
        extractedProvider = provider;
        return providerRepository.save(extractedProvider);
    }

    public void deleteAll() throws TargetNotFoundException { providerRepository.deleteAll(); }

    public void deleteSingle(Provider provider) throws TargetNotFoundException { providerRepository.deleteById(provider.getProviderId()); }

    public void deleteById(UUID id) throws TargetNotFoundException { providerRepository.deleteById(id); }
}
