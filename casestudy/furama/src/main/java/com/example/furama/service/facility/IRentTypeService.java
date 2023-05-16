package com.example.furama.service.facility;

import com.example.furama.model.customer.CustomerType;
import com.example.furama.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
