package caseStudy.fareMicroservice.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import caseStudy.fareMicroservice.entity.FlightDetails;



@Repository
public interface FareRepository extends MongoRepository<FlightDetails, Integer>
{
	public FlightDetails findByFlightNo(int flightNo);
	public FlightDetails[] findByStartPointAndEndPointAndFlightDate(String startPoint, String endPoint,String flightDate);
}
