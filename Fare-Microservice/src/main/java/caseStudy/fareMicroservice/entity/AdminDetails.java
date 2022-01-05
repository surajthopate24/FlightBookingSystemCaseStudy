package caseStudy.fareMicroservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "adminSignUpDetails")
public class AdminDetails {
	@Id
	private String name;
	private String emailId;
	private Long contact;
	private String adminname;
	private String password;
	private String confirmpassword;

	public AdminDetails() {
		super();
	}

	public AdminDetails(String name, String emailId, Long contact, String adminname, String password,
			String confirmpassword) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.contact = contact;
		this.adminname = adminname;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getadminname() {
		return adminname;
	}

	public void setadminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	@Override
	public String toString() {
		return "adminSignUp [name=" + name + ", emailId=" + emailId + ", contact=" + contact + ", adminname="
				+ adminname + ", password=" + password + ", confirmpassword=" + confirmpassword + "]";
	}
}
