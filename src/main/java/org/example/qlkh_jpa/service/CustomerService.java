package org.example.qlkh_jpa.service;

import org.example.qlkh_jpa.model.Customer;
import org.example.qlkh_jpa.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Page<Customer> findCustomerByNameContaining(String name, Pageable pageable) {
        return customerRepo.findCustomerByNameContaining(name, pageable);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        customerRepo.deleteById(id);
    }
}
