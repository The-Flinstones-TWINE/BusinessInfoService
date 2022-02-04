package com.twine.businessinfoservice.controller;


import com.twine.businessinfoservice.entities.Business;
import com.twine.businessinfoservice.exceptions.BusinessNotFoundException;
import com.twine.businessinfoservice.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    //getAllBusinesses method
    @GetMapping("/business")
    public List<Business> getAllBusinesses(){
        return businessService.getAllBusinesses();
    }

    //createBusiness method
    @PostMapping("/business")
    public Business createBusiness(@RequestBody Business business){
        return businessService.createBusiness(business);
    }

    //getBusinessById
    @GetMapping("/business/{id}")
    public Optional<Business> getBusinessById( @PathVariable("id") Long id){
        try {
            return businessService.getBusinessById(id);
        } catch (BusinessNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

    //updateBusinessById
    @PutMapping("/business/{id}")
    public Business updateBusinessById(@PathVariable Long id, @RequestBody Business business){
        try {
            return businessService.updateBusinessById(id,business);
        } catch (BusinessNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    //deleteBusinessById
    @DeleteMapping("/business/{id}")
    public void deleteBusinessById(@PathVariable("id") Long id)throws BusinessNotFoundException {
        businessService.deleteBusinessById(id);
    }
}
