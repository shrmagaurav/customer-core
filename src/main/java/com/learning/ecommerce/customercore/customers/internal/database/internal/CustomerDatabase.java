package com.learning.ecommerce.customercore.customers.internal.database.internal;

import com.learning.ecommerce.customercore.customers.internal.database.api.CustomerEntity;
import com.learning.ecommerce.customercore.customers.internal.database.api.CustomerReader;
import com.learning.ecommerce.customercore.customers.internal.database.api.CustomerWriter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerDatabase implements CustomerReader, CustomerWriter {

    private final CustomerRepository repository;

    public CustomerDatabase(CustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<CustomerEntity> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<CustomerEntity> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public CustomerEntity save(CustomerEntity entity) {
        return repository.save(entity);
    }
}
