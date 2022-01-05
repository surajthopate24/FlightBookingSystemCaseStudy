package caseStudy.fareMicroservice.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import caseStudy.fareMicroservice.dao.AdminRepository;
import caseStudy.fareMicroservice.dao.FareRepository;
import caseStudy.fareMicroservice.entity.AdminDetails;
import caseStudy.fareMicroservice.entity.FlightDetails;

@Service
public class FareServiceImpl implements FareService {
	@Autowired
	private FareRepository fareRepo;

	@Autowired
	private AdminRepository adminRepo;

	// This method finds the all Flights
	public List<FlightDetails> getAllDetails() {
		List<FlightDetails> FlightDetails = new ArrayList<FlightDetails>();
		fareRepo.findAll().forEach(FlightDetails1 -> FlightDetails.add(FlightDetails1));
		return FlightDetails;
	}

	// This method add the new flight
	public void addFlightDetails(FlightDetails flightDetails) {
		fareRepo.save(flightDetails);
	}

	// This method update the details of previous Flight
	public FlightDetails updateFlightDetails(int flightNo, FlightDetails flightDetails) {
		FlightDetails existingDetails = fareRepo.findByFlightNo(flightNo);
		existingDetails.setFlightNo(flightDetails.getFlightNo());
		existingDetails.setStartPoint(flightDetails.getStartPoint());
		existingDetails.setEndPoint(flightDetails.getEndPoint());
		existingDetails.setArrivalTime(flightDetails.getArrivalTime());
		existingDetails.setDeptTime(flightDetails.getDeptTime());
		existingDetails.setDuration(flightDetails.getDuration());
		existingDetails.setNoOfSeats(flightDetails.getNoOfSeats());
		existingDetails.setEconomyClass(flightDetails.getEconomyClass());
		existingDetails.setPremiumEconomy(flightDetails.getPremiumEconomy());
		existingDetails.setPremiumEconomy(flightDetails.getPremiumEconomy());
		return fareRepo.save(existingDetails);
	}

	// This method delete the Flight by flightNo
	@Override
	public ResponseEntity<FlightDetails> deleteFlightDetails(int flightNo) {
		FlightDetails existingDetails = fareRepo.findByFlightNo(flightNo);
		fareRepo.delete(existingDetails);
		// fareRepo.deleteById(flightNo);
		return ResponseEntity.ok().build();
	}

	// This method finds the Flight by flight no
	@Override
	public FlightDetails findByFlightNo(int flightNo) {
		return fareRepo.findByFlightNo(flightNo);
	}

	// This method find the flights by startpoint, endpoint and flightDate
	@Override
	public FlightDetails[] findByStartPointAndEndPointAndFlightDate(String startPoint, String endPoint,
			String flightDate) {
		return fareRepo.findByStartPointAndEndPointAndFlightDate(startPoint, endPoint, flightDate);

	}
	
	// This method add the admin details
	public void addAdmin(AdminDetails adminDetails) {
		adminRepo.save(adminDetails);
	}
}