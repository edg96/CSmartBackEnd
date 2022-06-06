package com.csmartbackend.controller;

import com.csmartbackend.model.WorkingPoint;
import com.csmartbackend.service.raw.WorkingPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("workingPoint")
@RequiredArgsConstructor
public class WorkingPointController
{
    private final WorkingPointService workingPointService;

    @GetMapping("find/all")
    public ResponseEntity<List<WorkingPoint>> findAll()
    {
        List<WorkingPoint> listOfWorkingPoints = workingPointService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listOfWorkingPoints);
    }

    @GetMapping("findbyid/{workingPointId}")
    public ResponseEntity<WorkingPoint> findById(@PathVariable("workingPointId") UUID workingPointId)
    {
        WorkingPoint returnedWorkingPoint = workingPointService.findById(workingPointId);
        return ResponseEntity.status(HttpStatus.OK).body(returnedWorkingPoint);
    }

    @PostMapping("save")
    public ResponseEntity<WorkingPoint> save(@RequestBody @Valid WorkingPoint workingPoint)
    {
        WorkingPoint returnedWorkingPoint = workingPointService.save(workingPoint);
        return ResponseEntity.status(HttpStatus.OK).body(returnedWorkingPoint);
    }

    @PutMapping("update/{workingPointId}")
    public ResponseEntity<WorkingPoint> update(@PathVariable("workingPointId") UUID workingPointId, @RequestBody @Valid WorkingPoint workingPoint)
    {
        WorkingPoint returnedWorkingPoint = workingPointService.update(workingPointId, workingPoint);
        return ResponseEntity.status(HttpStatus.OK).body(returnedWorkingPoint);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() { workingPointService.deleteAll(); }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) { workingPointService.deleteById(id); }

    @DeleteMapping("delete/single")
    public void deleteSingle(@RequestBody @Valid WorkingPoint workingPoint) { workingPointService.deleteSingle(workingPoint); }
}
