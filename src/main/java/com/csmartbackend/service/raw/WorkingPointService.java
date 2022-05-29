package com.csmartbackend.service.raw;

import com.csmartbackend.model.WorkingPoint;
import com.csmartbackend.repository.WorkingPointRepository;
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
public class WorkingPointService
{
    private final WorkingPointRepository workingPointRepository;

    public List<WorkingPoint> findAll()
    {
        List<WorkingPoint> workingPointList = workingPointRepository.findAll();
        if(workingPointList.isEmpty())
            throw new TargetNotFoundException("The list of working points is empty.");

        return new ArrayList<>(workingPointList);
    }

    public WorkingPoint findById(UUID workingPointId) throws TargetNotFoundException
    {
        Optional<WorkingPoint> workingPointOptional = workingPointRepository.findById(workingPointId);
        if(workingPointOptional.isEmpty())
            throw new TargetNotFoundException("No working point with the specified ID was found in the database.");

        return workingPointOptional.get();
    }

    public WorkingPoint save(WorkingPoint workingPoint)
    {
        return workingPointRepository.save(workingPoint);
    }

    public WorkingPoint update(UUID workingPointId, WorkingPoint workingPoint)
    {
        WorkingPoint extractedWorkingPoint = workingPointRepository.getById(workingPointId);
        extractedWorkingPoint = workingPoint;
        return workingPointRepository.save(extractedWorkingPoint);
    }

    public void deleteAll() throws TargetNotFoundException { workingPointRepository.deleteAll(); }

    public void deleteSingle(WorkingPoint workingPoint) throws TargetNotFoundException { workingPointRepository.deleteById(workingPoint.getWorkingPointId()); }

    public void deleteById(UUID id) throws TargetNotFoundException { workingPointRepository.deleteById(id); }
}

