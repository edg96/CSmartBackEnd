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
    public List<Provider> findAll() { return providerService.findAll(); }

    @GetMapping("findbyid/{id}")
    public ResponseEntity<Provider> findById(@PathVariable("id") UUID id)
    {
        Provider provider = providerService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(provider);
    }

    @PostMapping("save")
    public void saveProvider(@RequestBody Provider provider) { providerService.save(provider); }

    @PutMapping("update/{providerId}")
    public void updateProvider(@PathVariable("providerId") UUID providerId, @RequestBody @Valid Provider provider) { providerService.update(providerId, provider); }

    @DeleteMapping("delete/all")
    public void deleteAll() { providerService.deleteAll(); }

    @DeleteMapping("delete/single")
    public void deleteSingleEmployee(@RequestBody @Valid Provider provider) { providerService.deleteSingle(provider); }

    @DeleteMapping("delete/{id}")
    public void deleteEmployeeById(@PathVariable("id") UUID id) { providerService.deleteById(id); }
}
