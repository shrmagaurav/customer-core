package com.learning.ecommerce.customercore.customers.internal.transport.http;

import com.learning.ecommerce.customercore.customers.api.CustomerService;
import com.learning.ecommerce.customercore.customers.api.parameters.CustomerParameters;
import com.learning.ecommerce.customercore.customers.internal.transport.http.representation.CustomerRepresentation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/-/customer")
public class CustomerApi {

    private final CustomerService service;

    public CustomerApi(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public CustomerRepresentation registerCustomer(@RequestBody @Validated CustomerParameters customerParameters) {
        var customer = service.registerCustomer(customerParameters);
//        return ResponseEntity.ok("User registered successfully!");
        return new CustomerRepresentation(customer);
    }

}
