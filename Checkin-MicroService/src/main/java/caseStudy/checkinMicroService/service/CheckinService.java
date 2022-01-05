package caseStudy.checkinMicroService.service;
import java.util.List;
import caseStudy.checkinMicroService.entity.CheckinDetails;

public interface CheckinService {
	
	public List<CheckinDetails> getAllCheckins(); 
	public void addDetails(CheckinDetails userDetails);
	public CheckinDetails findByPnrNo(long pnrNo);
}
