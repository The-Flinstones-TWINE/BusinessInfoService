package com.twine.businessinfoservice.services;

import com.twine.businessinfoservice.entities.Business;
import com.twine.businessinfoservice.exceptions.BusinessNotFoundException;
import com.twine.businessinfoservice.repositories.BusinessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepo businessRepo;


    //getAllBusinesses
    public List<Business> getAllBusinesses(){
        return businessRepo.findAll();
    }

    //createBusiness
    public Business createBusiness(Business business){
        return businessRepo.save(business);
    }

    //getBusinessById
    public Optional<Business> getBusinessById(Long id) throws BusinessNotFoundException {

        Optional<Business> business= businessRepo.findById(id);
        if(!business.isPresent())
            throw new BusinessNotFoundException("business not found");
        return business;
    }

    //updateBusinessById
    public Business updateBusinessById(Long id, Business business)throws BusinessNotFoundException {

        if(!businessRepo.findById(id).isPresent()) {
            throw new BusinessNotFoundException("business not found");
        }
        return businessRepo.save(business);

    }
    //deleteBusinessById
    public void deleteBusinessById(Long id){
        Optional<Business> business= businessRepo.findById(id);
        if(!business.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"business not found in repo,enter correct details");
        }

        businessRepo.deleteById(id);
    }


}
