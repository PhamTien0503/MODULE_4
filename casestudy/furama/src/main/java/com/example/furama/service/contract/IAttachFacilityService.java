package com.example.furama.service.contract;

import com.example.furama.model.contract.AttachFacility;
import com.example.furama.model.contract.Contract;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();
    AttachFacility findById(int id);
}
