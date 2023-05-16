package com.example.furama.controller;

import com.example.furama.dto.IContractDetailDto;
import com.example.furama.repository.contract.IContractDetailRepository;
import com.example.furama.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/contract/v1")
@CrossOrigin("*")
public class ContractDetailController {
    @Autowired
   private IContractDetailService iContractDetailService;
//    @GetMapping("/{id}")
//    public ResponseEntity<List<IContractDetailDto>> showAll(@PathVariable int id) {
//        List<IContractDetailDto> list = iContractDetailService.showAll(id);
//
//        if (list.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<List<IContractDetailDto>> showAll(@PathVariable int id) {
        List<IContractDetailDto>list=iContractDetailService.showAll(id);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }





}
