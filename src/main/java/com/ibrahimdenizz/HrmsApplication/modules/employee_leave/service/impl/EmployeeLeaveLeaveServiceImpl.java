package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.service.impl;

import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.domain.EmployeeLeave;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.request.CreateLeaveRequest;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.enums.Status;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.repository.EmployeeLeaveRepository;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.service.EmployeeLeaveService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EmployeeLeaveLeaveServiceImpl implements EmployeeLeaveService {

    private final EmployeeLeaveRepository employeeLeaveRepository;

    public EmployeeLeaveLeaveServiceImpl(EmployeeLeaveRepository employeeLeaveRepository) {
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
                .updatedAt(null)
                .build();

        employeeLeaveRepository.save(employeeLeave.toEntity());
    }

    /**
     *
     */
    @Override
    public void findAllByEmployeeId() {

    }
}
