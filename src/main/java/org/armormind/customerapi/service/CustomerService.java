package org.armormind.customerapi.service;

import org.armormind.customerapi.model.dto.CustomerDto;
import org.armormind.customerapi.model.request.CustomerRequest;
import org.armormind.customerapi.model.response.CustomerDeleteResponse;
import org.armormind.customerapi.model.response.CustomerListResponse;

public interface CustomerService {
    CustomerListResponse getCustomer(Long id);

    CustomerListResponse getAllCustomers();

    CustomerDto createCustomer(CustomerRequest request);

    CustomerDto updateCustomer(Long id, CustomerRequest request);

    CustomerDeleteResponse deleteCustomer(Long id);

    CustomerDeleteResponse deleteAllCustomers();

}
