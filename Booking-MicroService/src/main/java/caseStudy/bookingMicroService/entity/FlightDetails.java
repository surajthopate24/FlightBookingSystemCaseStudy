package caseStudy.bookingMicroService.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flightDetails")
public class FlightDetails {

	@Id
	@NotNull(message = "Flight number cannot be null")
	@Max(value = 99999, message = "Flight number cannot exceed 5 digits")
	private int flightNo;

	@NotNull
	@Size(min = 2, message = "Start Point should be minimum of 2 characters")
	private String startPoint;

	@NotNull
	private String endPoint;

	@NotNull
	private String arrivalTime;

	@NotNull
	@Size(max = 7, message = "Departure Time should be maximum of 7 characters")
	private String deptTime;
	private String duration;
	private int noOfSeats;

	private int economyClass;
	private int premiumEconomy;
	private int businessClass;
	private  String flightDate;

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getEconomyClass() {
		return economyClass;
	}

	public void setEconomyClass(int economyClass) {
		this.economyClass = economyClass;
	}

	public int getPremiumEconomy() {
		return premiumEconomy;
	}

	public void setPremiumEconomy(int premiumEconomy) {
		this.premiumEconomy = premiumEconomy;
	}

	public int getBusinessClass() {
		return businessClass;
	}

	public void setBusinessClass(int businessClass) {
		this.businessClass = businessClass;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public FlightDetails(
			@NotNull(message = "Flight number cannot be null") @Max(value = 99999, message = "Flight number cannot exceed 5 digits") int flightNo,
			@NotNull @Size(min = 2, message = "Start Point should be minimum of 2 characters") String startPoint,
			@NotNull String endPoint, @NotNull String arrivalTime,
			@NotNull @Size(max = 7, message = "Departure Time should be maximum of 7 characters") String deptTime,
			String duration, int noOfSeats, int economyClass, int premiumEconomy, int businessClass,
			String flightDate) {
		super();
		this.flightNo = flightNo;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.arrivalTime = arrivalTime;
		this.deptTime = deptTime;
		this.duration = duration;
		this.noOfSeats = noOfSeats;
		this.economyClass = economyClass;
		this.premiumEconomy = premiumEconomy;
		this.businessClass = businessClass;
		this.flightDate = flightDate;
	}

	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FlightDetails [flightNo=" + flightNo + ", startPoint=" + startPoint + ", endPoint=" + endPoint
				+ ", arrivalTime=" + arrivalTime + ", deptTime=" + deptTime + ", duration=" + duration + ", noOfSeats="
				+ noOfSeats + ", economyClass=" + economyClass + ", premiumEconomy=" + premiumEconomy
				+ ", businessClass=" + businessClass + ", flightDate=" + flightDate + "]";
	}

}