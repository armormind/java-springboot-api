package org.armormind.customerapi.controller;

import org.armormind.customerapi.model.hateoas.CustomerControllerRepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/")
public final class IndexController {

    @GetMapping
    public CustomerControllerRepresentationModel index() {
        return new CustomerControllerRepresentationModel(linkTo(CustomerController.class).withRel("customer"));
    }
}
