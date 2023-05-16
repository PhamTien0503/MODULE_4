package com.example.furama.service.contract.impl;

import com.example.furama.dto.IContractDto;
import com.example.furama.model.contract.Contract;
import com.example.furama.repository.contract.IContractRepository;
import com.example.furama.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Page<IContractDto> findAllDto(Pageable pageable) {
        return contractRepository.findAllDto(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
