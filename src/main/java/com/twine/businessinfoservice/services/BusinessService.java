package com.twine.businessinfoservice.services;

import com.twine.businessinfoservice.entities.Business;
import com.twine.businessinfoservice.exceptions.BusinessNotFoundException;
import com.twine.businessinfoservice.repositories.BusinessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
        List<String> tagTemp = Arrays.asList(business.getTags().split("\\s*,\\s*"));
        business.setTagsList(tagTemp);
        return businessRepo.save(business);
    }

    //getBusinessById
    public Optional<Business> findByBusinessId(String id) throws BusinessNotFoundException {

        Optional<Business> business= businessRepo.findByBusinessId(id);
        if(!business.isPresent())
            throw new BusinessNotFoundException("business not found");
        return business;
    }
    public List<Business> getByIndustry(String industry) throws BusinessNotFoundException {

        List<Business> business= businessRepo.findByIndustry(industry);
        if(business==null)
            throw new BusinessNotFoundException("business not found");
        return business;
    }
}
