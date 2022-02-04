package com.twine.businessinfoservice.repositories;

import com.twine.businessinfoservice.entities.Business;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BusinessRepo extends CassandraRepository<Business,Long> {
    Optional<Business> findByBusinessId(String businessId);

    @Query(allowFiltering=true)
    List<Business> findByIndustry(String industry);
}
