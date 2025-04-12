package com.learning.ecommerce.customercore.customers.internal.database.api;

import java.util.Optional;

public interface CustomerReader {

    Optional<CustomerEntity> findByEmail(String email);

    Optional<CustomerEntity> findByUsername(String username);

}
