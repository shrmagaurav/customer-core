package com.learning.ecommerce.customercore.customers.internal;

import com.learning.ecommerce.customercore.customers.api.Customer;
import com.learning.ecommerce.customercore.customers.api.CustomerService;
import com.learning.ecommerce.customercore.customers.api.Gender;
import com.learning.ecommerce.customercore.customers.api.PasswordUtils;
import com.learning.ecommerce.customercore.customers.api.Role;
import com.learning.ecommerce.customercore.customers.api.parameters.CustomerParameters;
import com.learning.ecommerce.customercore.customers.internal.database.api.CustomerEntity;
import com.learning.ecommerce.customercore.customers.internal.database.api.CustomerReader;
import com.learning.ecommerce.customercore.customers.internal.database.api.CustomerWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultCustomerService implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCustomerService.class);

    private final CustomerReader reader;
    private final CustomerWriter writer;

    public DefaultCustomerService(CustomerReader reader, CustomerWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public Customer registerCustomer(CustomerParameters parameters) {
        // Check if email or username already exists
        if (reader.findByEmail(parameters.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already taken");
        }
        if (reader.findByUsername(parameters.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        // Convert DTO to Entity
        CustomerEntity customer = new CustomerEntity();
        customer.setUsername(parameters.getUsername());
        customer.setPassword(PasswordUtils.hashPassword(parameters.getPassword())); // Hash password
        customer.setFirstName(parameters.getFirstName());
        customer.setLastName(parameters.getLastName());
        customer.setMiddleName(parameters.getMiddleName());
        customer.setNickname(parameters.getNickname());
        customer.setEmail(parameters.getEmail());
        customer.setMobilePhone(parameters.getMobilePhone());
        customer.setMobilePhonePrefix(parameters.getMobilePhonePrefix());

        // Convert Strings to Enums
        customer.setGender(Gender.valueOf(parameters.getGender().toUpperCase()));
        customer.setRole(Role.valueOf(parameters.getRole().toUpperCase()));

        var result = writer.save(customer);
        LOGGER.info("User Created: {}", result);


        // TODO -> dispatch user created email with user details to user email address
        return CustomerEntity.toUser(result);
    }

}
