package com.twine.businessinfoservice.services;

import com.twine.businessinfoservice.entities.Business;
import com.twine.businessinfoservice.exceptions.BusinessNotFoundException;
import com.twine.businessinfoservice.repositories.BusinessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

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
        if(!(business.getBusinessName().length() >0) || !(business.getEmail().length() >0) ||  !(business.getPhone().length() >0) || !(business.getAddressLine1().length() >0) || !(business.getAddressLine2().length() >0) || !(business.getAbout().length() >0) || !(business.getLogo().length() >0) ||!(business.getTags().length() >0) ) throw new RuntimeException("required fields missing");
        return businessRepo.save(business);
    }

    //createBusinesses
    public List<Business> createBusinesses(List<Business> business){
            return businessRepo.saveAll(business);
    }

    //post user review
    public Business postReview(String review,Double reviewRating, String id) throws BusinessNotFoundException {
        try {
            Business business = businessRepo.findByBusinessId(id).get();
            Stack<String> businessReviews =   business.getReviews();
            if(businessReviews == null)  businessReviews = new Stack<>();
            businessReviews.push(review);
            business.setReviews(businessReviews);
            Double oldOverAllRating =business.getBusinessRating();
            Double newRating = calculateRating( reviewRating,oldOverAllRating==null?0:oldOverAllRating);
            //update rating
            business.setBusinessRating(newRating);
            return businessRepo.save(business);
        }catch (RuntimeException e){
            throw new BusinessNotFoundException("business not found");
        }
    }

    //calculate rating
    public Double calculateRating(Double reviewRating, Double businessRating) throws BusinessNotFoundException {
        return  businessRating + (reviewRating/5);
    }


    //getBusinessById
    public Optional<Business> findByBusinessId(String id) throws BusinessNotFoundException {

        Optional<Business> business= businessRepo.findByBusinessId(id);
        if(!business.isPresent())
            throw new BusinessNotFoundException("business not found");
        return business;
    }
    //search
    public List<Business> search(String query) throws BusinessNotFoundException {
        List<Business> result = new ArrayList<>();
        List<Business> businesses= businessRepo.findAll();
        for (Business business:businesses
             ) {
            if(business.getTagsList().contains(query))
                result.add(business);
        }
        return result;

    }


}
