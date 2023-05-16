package com.example.furama.service.contract.impl;

import com.example.furama.model.contract.AttachFacility;
import com.example.furama.repository.contract.IAttachFacilityRepository;
import com.example.furama.repository.employee.IEmployeeRepository;
import com.example.furama.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findById(int id) {
        return attachFacilityRepository.findById(id).get();
    }
}
