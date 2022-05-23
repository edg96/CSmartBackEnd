package com.csmartbackend.controller;

import com.csmartbackend.dto.WorkingPointDto;
import com.csmartbackend.service.raw.WorkingPointService;
import com.csmartbackend.model.WorkingPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("workingpoint")
@RequiredArgsConstructor
public class WorkingPointController
{
    private final WorkingPointService workingPointService;

    @GetMapping("find/all")
    public List<WorkingPointDto> findAllWorkingPoints() { return workingPointService.findAll(); }

    @PostMapping("save")
    public WorkingPointDto saveWorkingPoint(@RequestBody @Valid WorkingPoint workingPoint) { return workingPointService.save(workingPoint); }

    @DeleteMapping("delete/all")
    public void deleteAllWorkingPoints() { workingPointService.deleteAll(); }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) { workingPointService.deleteById(id); }

    @DeleteMapping("delete/single")
    public void deleteWorkingPoint(@RequestBody @Valid WorkingPoint workingPoint) { workingPointService.deleteSingle(workingPoint); }
}
