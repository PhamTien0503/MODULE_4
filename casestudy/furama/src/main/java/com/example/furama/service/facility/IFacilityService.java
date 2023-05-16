package com.example.furama.service.facility;

import com.example.furama.model.customer.Customer;
import com.example.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);
    List<Facility> findAll();
    boolean save (Facility facility);
    Page<Facility> searchFacility(String nameSearch, int id, Pageable pageable);
    Facility findById(int id);
    void delete (int id);
    Page<Facility>findByFacilityNameContainingAndDeleteStatus(String name,boolean deleteStatus,Pageable pageable);

}
