package caseStudy.checkinMicroService.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import caseStudy.checkinMicroService.entity.CheckinDetails;
import caseStudy.checkinMicroService.entity.FlightDetails;
import caseStudy.checkinMicroService.entity.UserDetails;
import caseStudy.checkinMicroService.service.CheckinService;
import caseStudy.checkinMicroService.service.CheckinServiceImpl;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@Component
@RestController
@RequestMapping("/checkIn")
public class CheckinController {

	@Autowired
	private CheckinService checkinService;

	// This method is to get Checkin details
	@GetMapping("/get/checkin/{pnrNo}")
	@ApiOperation(value = "Get Checkin")
	public CheckinDetails addCheckinDetails(@PathVariable long pnrNo) {
		RestTemplate restTemplate = new RestTemplate();
		UserDetails user = restTemplate.getForObject("http://localhost:8082/user/get/" + pnrNo, UserDetails.class);
		long pnr = user.getPnrNo();
		int fNo = user.getFlightNo();
		String sPoint = user.getStartPoint();
		String ePoint = user.getEndPoint();
		String cType = user.getClassType();
		String uName = user.getName();
		String gender = user.getGender();
		String pay = user.getPayment();
		String mail = user.getEmail();

		FlightDetails fDetails = restTemplate.getForObject("http://localhost:8081/fare/find/" + fNo,
				FlightDetails.class);
		String dTime = fDetails.getDeptTime();
		String duration = fDetails.getDuration();
		String date = fDetails.getFlightDate();

		CheckinDetails cd = new CheckinDetails();
		cd.setPnrNo(pnr);
		cd.setFlightNo(fNo);
		cd.setStartPoint(sPoint);
		cd.setEndPoint(ePoint);
		cd.setClassType(cType);
		cd.setDeptTime(dTime);
		cd.setName(uName);
		cd.setGender(gender);
		cd.setPayment(pay);
		cd.setDuration(duration);
		cd.setFlightDate(date);
		cd.setSeatNo();
		cd.setEmail(mail);
		checkinService.addDetails(cd);
		return checkinService.findByPnrNo(pnrNo);

	}

	// This method is to get all checkins done
	@GetMapping("/getAllCheckins")
	@ApiOperation(value = "Get all checkin details who booked their tickets")
	public List<CheckinDetails> getAll() {
		return checkinService.getAllCheckins();
	}

}
