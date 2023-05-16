package com.example.furama.service.customer;

import com.example.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    boolean save (Customer customer);
    Page<Customer> searchCustomer(String nameSearch,  String emailSearch, String id, Pageable pageable);
    Customer findById(int id);
    void delete (int id);

}
