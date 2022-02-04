package com.twine.businessinfoservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @PrimaryKey
    private String id= UUID.randomUUID().toString();
    private String title;
    private String  desc;
    private Double price;
    private String mediaLink;
}
