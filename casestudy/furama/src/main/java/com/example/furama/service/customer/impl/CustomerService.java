package com.example.furama.service.customer.impl;

import com.example.furama.model.customer.Customer;
import com.example.furama.repository.customer.ICustomerRepository;
import com.example.furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean save(Customer customer) {
        try {
            customerRepository.save(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Page<Customer> searchCustomer(String nameSearch, String emailSearch, String id, Pageable pageable) {
        return customerRepository.searchCustomer(nameSearch,emailSearch,id,pageable);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }
    @Transactional
    @Override
    public void delete(int id) {
        customerRepository.deleteLogical(id);
    }
}
