package com.learning.ecommerce.customercore.customers.api;

import com.learning.ecommerce.customercore.customers.api.parameters.CustomerParameters;

public interface CustomerService {
//    String FullDataContextKey = CustomerService.class.getName() + "#fullObjects";

    Customer registerCustomer(CustomerParameters parameters);

}
