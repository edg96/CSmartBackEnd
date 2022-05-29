package com.csmartbackend.controller;

import com.csmartbackend.model.Provider;
import com.csmartbackend.service.raw.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("provider")
@RequiredArgsConstructor
public class ProviderController
{
    private final ProviderService providerService;

    @GetMapping("find/all")
    public ResponseEntity<List<Provider>> findAll()
    {
        List<Provider> listOfProviders = providerService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listOfProviders);
    }

    @GetMapping("findbyid/{providerId}")
    public ResponseEntity<Provider> findById(@PathVariable("providerId") UUID providerId)
    {
        Provider returnedProvider = providerService.findById(providerId);
        return ResponseEntity.status(HttpStatus.OK).body(returnedProvider);
    }

    @PostMapping("save")
    public ResponseEntity<Provider> save(@RequestBody @Valid Provider provider)
    {
        Provider returnedProvider = providerService.save(provider);
        return ResponseEntity.status(HttpStatus.OK).body(returnedProvider);
    }

    @PutMapping("update/{providerId}")
    public ResponseEntity<Provider> update(@PathVariable("providerId") UUID providerId, @RequestBody @Valid Provider provider)
    {
        Provider returnedProvider = providerService.update(providerId, provider);
        return ResponseEntity.status(HttpStatus.OK).body(returnedProvider);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() { providerService.deleteAll(); }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) { providerService.deleteById(id); }

    @DeleteMapping("delete/single")
    public void deleteSingle(@RequestBody @Valid Provider provider) { providerService.deleteSingle(provider); }
}
