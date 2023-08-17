package org.sports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sports.services.ClassFetcherService;

@RestController
public class ClassController {

    @Autowired private ClassFetcherService classFetcherService;

    @GetMapping(value = "/getEvent")
    public String getTestData() {
      return classFetcherService.getEvent();
    }
}
