package com.twine.businessinfoservice.repositories;

import com.twine.businessinfoservice.entities.Business;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BusinessRepo extends CassandraRepository<Business,Long> {
}
