package com.learning.ecommerce.customercore.customers.internal.transport.grpc;

import com.learning.ecommerce.auth.CustomerServiceGrpc;
import com.learning.ecommerce.auth.ValidateUserRequest;
import com.learning.ecommerce.auth.ValidateUserResponse;
import com.learning.ecommerce.customercore.customers.internal.database.api.CustomerEntity;
import com.learning.ecommerce.customercore.customers.internal.database.api.CustomerReader;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@GrpcService
public class CustomerServiceImplGrpc extends CustomerServiceGrpc.CustomerServiceImplBase {

    private final CustomerReader customerReader;
    private final PasswordEncoder passwordEncoder;

    public CustomerServiceImplGrpc(CustomerReader customerReader, PasswordEncoder passwordEncoder) {
        this.customerReader = customerReader;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void validateUser(ValidateUserRequest request, StreamObserver<ValidateUserResponse> responseObserver) {
        Optional<CustomerEntity> customer = customerReader.findByUsername(request.getUsername());

        boolean isValid = customer.isPresent() && passwordEncoder.matches(request.getPassword(), customer.get().getPassword());

        ValidateUserResponse response = ValidateUserResponse.newBuilder()
                .setIsValid(isValid)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
