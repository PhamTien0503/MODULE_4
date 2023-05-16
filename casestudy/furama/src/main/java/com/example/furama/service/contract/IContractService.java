package com.example.furama.service.contract;

import com.example.furama.dto.IContractDto;
import com.example.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();
    Page<IContractDto> findAllDto(Pageable pageable);
    void save(Contract contract);
}
