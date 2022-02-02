package com.twine.businessinfoservice.repositories;


import com.twine.businessinfoservice.entities.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductRepo extends CassandraRepository<Product,Long> {
}
