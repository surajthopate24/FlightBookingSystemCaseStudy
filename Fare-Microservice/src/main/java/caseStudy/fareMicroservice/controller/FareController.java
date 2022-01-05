package caseStudy.fareMicroservice.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import caseStudy.fareMicroservice.dao.FareRepository;
import caseStudy.fareMicroservice.entity.AdminDetails;
import caseStudy.fareMicroservice.entity.FlightDetails;
import caseStudy.fareMicroservice.service.FareService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/fare")
public class FareController {

	@Autowired
	private FareService fareService;

	// This method finds the all Flights
	@GetMapping("/findAll")
	@ApiOperation(value = "Get all Flight details")
	public List<FlightDetails> getAllDetails() {
		return fareService.getAllDetails();
	}

	// This method finds the Flight by flight no
	@GetMapping("/find/{flightNo}")
	@ApiOperation(value = "Get all Flight details by flight Number")
	public FlightDetails getDetailsByFlightNo(@PathVariable int flightNo) {
		return fareService.findByFlightNo(flightNo);
	}

	// This method add the new flight
	@PostMapping("/add")
	@ApiOperation(value = "Add new Flight details to flight database")
	public String addFlightDetails(@Valid @RequestBody FlightDetails flightDetails) {
		fareService.addFlightDetails(flightDetails);
		return ("Added flight details with flight number - " + flightDetails.getFlightNo() + " successfully..!!");
	}

	// This method update the details of previous Flight
	@PutMapping("/update/{flightNo}")
	@ApiOperation(value = "Update flight details in flight database by flight Number")
	public FlightDetails updateFlightDetails(@PathVariable int flightNo,
			@Valid @RequestBody FlightDetails flightDetails) {
		return fareService.updateFlightDetails(flightNo, flightDetails);
	}

	// This method delete the Flight by flightNo
	@DeleteMapping("/delete/{flightNo}")
	@ApiOperation(value = "Delete flight details in flight database by Flight Number")
	public ResponseEntity<FlightDetails> deleteFlightDetails(@PathVariable int flightNo) {
		return fareService.deleteFlightDetails(flightNo);
	}

	// update the no of seats based on the no of passengers that booked ticket
	@GetMapping("/updateSeats/{flightNo}/{noOfPassengers}")
	public void updateSeats(@PathVariable int flightNo, @PathVariable int noOfPassengers) {
		FlightDetails currentflight = fareService.findByFlightNo(flightNo);
		int initialSeats = currentflight.getNoOfSeats();
		int finalSeats = initialSeats - noOfPassengers;
		currentflight.setNoOfSeats(finalSeats);
		fareService.updateFlightDetails(flightNo, currentflight);
	}

	// This method find the flights by startpoint, endpoint and flightDate
	@GetMapping("/findBy/{startPoint}/{endPoint}/{flightDate}")
	@ApiOperation(value = "Get Flight details by giving startPoint and endPoint locations and date")
	public FlightDetails[] getFlightDetailsByStartPointAndEndPointAndFlightDate(@PathVariable String startPoint,
			@PathVariable String endPoint, @PathVariable String flightDate) {
		return fareService.findByStartPointAndEndPointAndFlightDate(startPoint, endPoint, flightDate);
	}

	// This method add the admin details
	@PostMapping("/signup")
	@ApiOperation(value = "To Add Admin Details")
	public String saveUser(@RequestBody AdminDetails adminDetails) {
		try {
			this.fareService.addAdmin(adminDetails);
			return "Admin Login Successfully ";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Operation Failed";
	}

}