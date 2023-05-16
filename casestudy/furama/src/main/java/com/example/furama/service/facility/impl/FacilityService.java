package com.example.furama.service.facility.impl;

import com.example.furama.model.facility.Facility;
import com.example.furama.repository.facility.IFacilityRepository;
import com.example.furama.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public boolean save(Facility facility) {
        try {
            facilityRepository.save(facility);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Page<Facility> searchFacility(String nameSearch, int id, Pageable pageable) {
        return facilityRepository.searchFacility(nameSearch,id,pageable);
    }



    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }
    @Transactional
    @Override
    public void delete(int id) {
        facilityRepository.deleteLogical(id);
    }

    @Override
    public Page<Facility> findByFacilityNameContainingAndDeleteStatus(String name,boolean deleteStatus,Pageable pageable) {
        return facilityRepository.findByFacilityNameContainingAndDeleteStatus(name,deleteStatus,pageable);
    }
}
