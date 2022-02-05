package com.twine.businessinfoservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {

    @PrimaryKey
    private String businessId= UUID.randomUUID().toString();
    private String businessName;
    private String   website;
    private String  email;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String facebook;
    private String twitter;
    private String youtube;
    private String instagram;
    private String about;
    private String tags;
    private String industry;
    private List<String> tagsList;
    private String cover;
    private List<String>  productListIds;
    private Boolean isTrue;
    private Stack<String> reviews;
    private Double  businessRating;
    private String logo;
    private String upiId;

}


