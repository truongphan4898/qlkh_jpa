package org.example.qlkh_jpa.service;

import org.example.qlkh_jpa.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id);
    void save (Customer t);
    void remove(Long id);
    Page<Customer> findCustomerByNameContaining(String name, Pageable pageable);

}
