package caseStudy.checkinMicroService.entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "userDetails")
public class UserDetails 
{
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	@NotNull
	private int id;
	
	@NotNull
	private long pnrNo;
	 
	@NotNull
	@Size(min=3,message="Name should be minimum of 3 characters")
	private String name;
	
	@NotNull
	@Max(value=99,message="Age cannot be more than 99")
	private int age;
	
	@NotNull
	@Size(max=6,message="Either male,female or other ")
	private String gender;
	
	@NotNull
	@Max(value=99999,message="Flight number cannot exceed 5 digits")
	private int flightNo;

	
	@NotNull
	@Size(min=2,message="Start Point should be minimum of 2 characters")
	private String startPoint;
	
	@NotNull
	@Size(min=2,message="EndPoint Point should be minimum of 2 characters")
	private String endPoint;
	
	@NotNull
	@Size(min=2,message="Class type should be minimum of 2 characters")
	private String classType;
	
	
	@NotNull
	private String payment;
	
	private int adults;
	private int children;
	private String email;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public UserDetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(long pnrNo) {
		this.pnrNo = pnrNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

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

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	

	
	public UserDetails(@NotNull int id, @NotNull long pnrNo,
			@NotNull @Size(min = 3, message = "Name should be minimum of 3 characters") String name,
			@NotNull @Max(value = 99, message = "Age cannot be more than 99") int age,
			@NotNull @Size(max = 6, message = "Either male,female or other ") String gender,
			@NotNull @Max(value = 99999, message = "Flight number cannot exceed 5 digits") int flightNo,
			@NotNull @Size(min = 2, message = "Start Point should be minimum of 2 characters") String startPoint,
			@NotNull @Size(min = 2, message = "EndPoint Point should be minimum of 2 characters") String endPoint,
			@NotNull @Size(min = 2, message = "Class type should be minimum of 2 characters") String classType,
			@NotNull String payment, int adults, int children, String email) {
		super();
		this.id = id;
		this.pnrNo = pnrNo;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.flightNo = flightNo;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.classType = classType;
		this.payment = payment;
		this.adults = adults;
		this.children = children;
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", pnrNo=" + pnrNo + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", flightNo=" + flightNo + ", startPoint=" + startPoint + ", endPoint=" + endPoint + ", classType="
				+ classType + ", payment=" + payment + ", adults=" + adults + ", children=" + children + ", email="
				+ email + "]";
	}

	public void setPnrNo() {			// 0 to 1
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		this.pnrNo = number;
	}

	
	
}