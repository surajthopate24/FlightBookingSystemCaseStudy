package caseStudy.bookingMicroService.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import caseStudy.bookingMicroService.entity.UserDetails;


@Repository
public interface UserRepository extends MongoRepository<UserDetails, Integer>
{

}
