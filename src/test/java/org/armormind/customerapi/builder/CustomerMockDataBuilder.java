package org.armormind.customerapi.builder;

import org.armormind.customerapi.model.dto.CustomerDto;
import org.armormind.customerapi.model.request.CustomerRequest;
import org.armormind.customerapi.model.response.CustomerDeleteResponse;
import org.armormind.customerapi.model.response.CustomerListResponse;

import java.util.Collections;

public class CustomerMockDataBuilder {

    private CustomerMockDataBuilder() {
    }

    public static CustomerListResponse generateCustomerListResponse(long customerId) {
        return CustomerListResponse.builder()
                .customers(Collections.singletonList(generateCustomerDto(customerId)))
                .build();
    }

    public static CustomerRequest generateCustomerRequest() {
        return GenericMockDataBuilder.of(CustomerRequest.class).build();
    }

    public static CustomerDeleteResponse generateCustomerDeleteResponse() {
        return CustomerDeleteResponse.builder()
                .deletedCustomerCount(1L)
                .build();
    }

    public static CustomerDto generateCustomerDto(long customerId) {
        final CustomerDto dto = GenericMockDataBuilder.of(CustomerDto.class)
                .excludeField("id")
                .build();
        dto.setId(customerId);
        return dto;
    }

}
