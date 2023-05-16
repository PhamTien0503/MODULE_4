package com.example.furama.repository.facility;

import com.example.furama.model.customer.Customer;
import com.example.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select * from facility where facility_name like %:nameSearch% " +
            "and facility_type_id =:idSearch and delete_status=false",nativeQuery = true)
    Page<Facility>searchFacility(@Param("nameSearch") String nameSearch,
                                 @Param("idSearch") int id, Pageable pageable);
    @Modifying
    @Query(value = "update facility set delete_status = true where facility_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);

    Page<Facility>findByFacilityNameContainingAndDeleteStatus( String name,boolean deleteStatus,Pageable pageable);

}
