package com.learning.ecommerce.customercore.customers.internal.database.internal;

import com.learning.ecommerce.customercore.customers.internal.database.api.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    Optional<CustomerEntity> findByEmail(String email);

    Optional<CustomerEntity> findByUsername(String username);

}
