package org.sports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sports.services.ClassCreationService;

@RestController
public class ClassController {

    @Autowired private ClassCreationService classCreationService;

    @GetMapping(value = "/test")
    public String getTestData() {
      return classCreationService.createClass();
    }
}
