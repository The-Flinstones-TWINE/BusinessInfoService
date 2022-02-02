package com.twine.businessinfoservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {

    @PrimaryKey
    private Long unique_id;
    private String businessName;
    private List<String >coverPictures;
    private String AboutUsDesc;
    private Boolean openToInvestors ;
    private String industryDomain;
    private List<String> tags ;
    private String upiId;
    private List<String> productIds ;
    private Map<String,String> contacts;
    private String websiteLink;
    private Map<String,String> specialities ;
//    top5 ['productMediaId']


}


