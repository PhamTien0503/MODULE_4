package com.example.furama.repository.customer;

import com.example.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where customer_name like %:nameSearch% " +
            "and customer_email like %:emailSearch% and customer_type_id like %:idSearch%",nativeQuery = true)
    Page<Customer>searchCustomer(@Param("nameSearch") String nameSearch, @Param("emailSearch") String emailSearch,
                                 @Param("idSearch") String id, Pageable pageable);
    @Modifying
    @Query(value = "update customer set delete_status = true where customer_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);

}
