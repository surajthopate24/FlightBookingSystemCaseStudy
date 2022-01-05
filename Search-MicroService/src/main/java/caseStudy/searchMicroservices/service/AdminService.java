package caseStudy.searchMicroservices.service;
import java.util.List;

import caseStudy.searchMicroservices.entity.FlightDetails;

public interface AdminService 
{
	public List<FlightDetails> getAllDetails();
	public String pnrStatus(long pnrNo);
	public FlightDetails getDetailsByFlightNo(int flightNo);
	public List<FlightDetails> findByStartPointAndEndPointAndFlightDate(String startPoint, String endPoint,
			String flightDate);
	
	
}
