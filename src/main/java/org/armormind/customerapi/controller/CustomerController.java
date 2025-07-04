package org.armormind.customerapi.controller;
import java.util.Map;
import java.util.HashMap;
import org.armormind.customerapi.model.dto.CustomerDto;
import org.armormind.customerapi.model.request.CustomerRequest;
import org.armormind.customerapi.model.response.CustomerDeleteResponse;
import org.armormind.customerapi.model.response.CustomerListResponse;
import org.armormind.customerapi.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public final class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/healtz")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "ok tested");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerListResponse> getCustomer(@PathVariable("id") Long id) {
        CustomerListResponse response = customerService.getCustomer(id);

        if (CollectionUtils.isEmpty(response.getCustomers())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @GetMapping("/customers")
    public ResponseEntity<CustomerListResponse> getAllCustomers() {
        CustomerListResponse response = customerService.getAllCustomers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerRequest request) {
        return new ResponseEntity<>(customerService.createCustomer(request), HttpStatus.CREATED);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerRequest request) {
        CustomerDto customerDto = customerService.updateCustomer(id, request);
        if (null == customerDto) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<CustomerDeleteResponse> deleteCustomer(@PathVariable("id") Long id) {
        CustomerDeleteResponse response = customerService.deleteCustomer(id);
        if (0L == response.getDeletedCustomerCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/customers")
    public ResponseEntity<CustomerDeleteResponse> deleteAllCustomers() {
        CustomerDeleteResponse response = customerService.deleteAllCustomers();
        if (0L == response.getDeletedCustomerCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}
