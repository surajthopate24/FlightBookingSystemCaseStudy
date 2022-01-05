package caseStudy.fareMicroservice.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import caseStudy.fareMicroservice.entity.AdminDetails;
import caseStudy.fareMicroservice.entity.FlightDetails;

@Repository
public interface AdminRepository extends MongoRepository<AdminDetails,Integer> {



}
