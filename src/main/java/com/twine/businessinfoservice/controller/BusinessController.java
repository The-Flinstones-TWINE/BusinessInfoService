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
    public Optional<Business> getByBusinessId( @PathVariable("id") String id){
        try {
            Optional<Business> b = businessService.findByBusinessId(id);
            return b;
        } catch (BusinessNotFoundException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
    //getBusinessByIndustry
    @GetMapping("/business/industry{industry}")
    public List<Business> getByIndustry( @PathVariable("industry") String industry){
        try {
            return businessService.getByIndustry(industry);
        } catch (BusinessNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }



}
