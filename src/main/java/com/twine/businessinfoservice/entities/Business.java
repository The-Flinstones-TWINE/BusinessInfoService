package com.twine.businessinfoservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {

    @PrimaryKey
    private String unique_id= UUID.randomUUID().toString();
    private String businessName;
    private String   website;
    private String  email;
    private Integer phone;
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
    private List<String> cover;
    private List<String>  itemsImageLinkState;
    private Boolean isTrue;
//    private String businessName;
//    private List<String >coverPictures;
//    private String AboutUsDesc;
//    private Boolean openToInvestors ;
//    private String industryDomain;
//    private List<String> tags ;
//    private String upiId;
//    private List<String> productIds ;
//    private Map<String,String> contacts;
//    private String websiteLink;
//    private Map<String,String> specialities ;
//    top5 ['productMediaId']





}


