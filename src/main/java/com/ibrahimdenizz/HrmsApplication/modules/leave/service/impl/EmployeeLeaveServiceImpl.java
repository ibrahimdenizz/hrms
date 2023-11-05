package com.ibrahimdenizz.HrmsApplication.modules.leave.service.impl;

import com.ibrahimdenizz.HrmsApplication.modules.leave.model.domain.Leave;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.entity.LeaveEntity;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.enums.LeaveStatus;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.request.CreateLeaveRequest;
import com.ibrahimdenizz.HrmsApplication.modules.leave.repository.LeaveRepository;
import com.ibrahimdenizz.HrmsApplication.modules.leave.service.EmployeeLeaveService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

    private final LeaveRepository leaveRepository;

    public EmployeeLeaveServiceImpl(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }


    /**
     *
     */
    @Override
    public void createEmployeeLeave(String employeeId, CreateLeaveRequest request) {
        Leave leave = Leave.builder()
                .id(UUID.randomUUID().toString())
                .employeeId(employeeId)
                .leaveTypeId(request.leaveTypeId())
                .startDate(request.startDate())
                .endDate(request.endDate())
                .reason(request.reason())
                .status(LeaveStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();

        leaveRepository.save(leave.toEntity());
    }

    /**
     *
     */
    @Override
    public List<Leave> getAllEmployeeLeaves(String employeeId) {
        List<LeaveEntity> employeeLeaveEntities = leaveRepository.findAllByEmployeeId(employeeId);

        return employeeLeaveEntities
                .stream()
                .map(Leave::fromEntity)
                .toList();
    }
}
