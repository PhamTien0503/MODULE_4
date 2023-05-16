package com.example.furama.service.facility;

import com.example.furama.model.customer.CustomerType;
import com.example.furama.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
}
