package caseStudy.searchMicroservices.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import caseStudy.searchMicroservices.entity.PaymentDetails;

@Repository
public interface UserPaymentRepository extends MongoRepository<PaymentDetails, Long>
{

}
