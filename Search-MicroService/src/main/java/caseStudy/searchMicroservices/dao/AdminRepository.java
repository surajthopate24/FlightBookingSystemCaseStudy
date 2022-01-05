package caseStudy.searchMicroservices.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import caseStudy.searchMicroservices.entity.FlightDetails;


@Repository
public interface AdminRepository extends MongoRepository<FlightDetails, Integer>
{

	FlightDetails findByFlightNo(int flightNo);
	public List<FlightDetails> findByStartPointAndEndPointAndFlightDate(String startPoint, String endPoint,String flightDate);
}
