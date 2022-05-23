package com.csmartbackend.service.raw;

import com.csmartbackend.dto.WorkingPointDto;
import com.csmartbackend.mapper.WorkingPointMapper;
import com.csmartbackend.model.WorkingPoint;
import com.csmartbackend.repository.WorkingPointRepository;
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
public class WorkingPointService
{
    private final WorkingPointRepository workingPointRepository;

    public List<WorkingPointDto> findAll()
    {
        List<WorkingPoint> workingPointList = workingPointRepository.findAll();
        if(workingPointList.isEmpty())
            throw new TargetNotFoundException();

        WorkingPointMapper workingPointMapper = WorkingPointMapper.getInstance();
        return workingPointList.stream()
                .map(workingPointMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public WorkingPointDto save(WorkingPoint workingPoint)
    {
        workingPointRepository.save(workingPoint);

        return WorkingPointMapper.getInstance().entityToDto(workingPoint);
    }

    public void deleteAll() { workingPointRepository.deleteAll(); }

    public void deleteById(UUID id) { workingPointRepository.deleteById(id); }

    public void deleteSingle(WorkingPoint workingPoint) { workingPointRepository.delete(workingPoint); }
}

