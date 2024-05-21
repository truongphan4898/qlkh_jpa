package org.example.qlkh_jpa.repository;

import org.example.qlkh_jpa.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepo extends JpaRepository<Customer, Long> {
//    Page<Customer> findCustomerByNameContaining(String name, Pageable pageable);
    Page<Customer> findCustomerByNameContaining(String name, Pageable pageable);
    Page<Customer> findCustomerByNamContaining(String name, Pageable pageable);


    @Query(value = "select * from customer where name like : name1",nativeQuery = true)
    Page<Customer> searchByName1(@Param("name1") String name, Pageable pageable);
}
