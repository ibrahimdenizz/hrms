package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.service.impl;

import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.domain.EmployeeLeave;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.request.CreateLeaveRequest;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.entity.EmployeeLeaveEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.enums.Status;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.repository.EmployeeLeaveRepository;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.service.EmployeeLeaveService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

    private final EmployeeLeaveRepository employeeLeaveRepository;

    public EmployeeLeaveServiceImpl(EmployeeLeaveRepository employeeLeaveRepository) {
        this.employeeLeaveRepository = employeeLeaveRepository;
    }


    /**
     *
     */
    @Override
    public void createEmployeeLeave(String employeeId, CreateLeaveRequest request) {
        EmployeeLeave employeeLeave = EmployeeLeave.builder()
                .id(UUID.randomUUID().toString())
                .employeeId(employeeId)
                .leaveTypeId(request.leaveTypeId())
                .startDate(request.startDate())
                .endDate(request.endDate())
                .reason(request.reason())
                .status(Status.PENDING)
                .createdAt(LocalDateTime.now())
                .build();

        employeeLeaveRepository.save(employeeLeave.toEntity());
    }

    /**
     *
     */
    @Override
    public List<EmployeeLeave> getAllEmployeeLeaves(String employeeId) {
        List<EmployeeLeaveEntity> employeeLeaveEntities = employeeLeaveRepository.getAllEmployeeLeaves(employeeId);

        return employeeLeaveEntities
                .stream()
                .map(EmployeeLeave::fromEntity)
                .toList();
    }
}
