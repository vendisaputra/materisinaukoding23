package id.sinaukoding23.latihan.service;

import id.sinaukoding23.latihan.model.Customer;
import id.sinaukoding23.latihan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Transactional(readOnly = true)
    public List<Customer> findAll(){
        return repository.findAll();
    }
}
