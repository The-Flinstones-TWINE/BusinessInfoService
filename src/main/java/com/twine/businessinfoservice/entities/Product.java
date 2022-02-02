package com.twine.businessinfoservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @PrimaryKey
    private String id;
    private String title;
    private String  desc;
    private Double price;
    private String mediaLink;
    private Boolean top5;
}