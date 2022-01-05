package caseStudy.bookingMicroService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

//import com.example.TicketService.exception.ResourceNotFoundException;
import com.google.common.collect.Lists;
//import it.ozimov.springboot.mail.model.Email;
//import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
//import it.ozimov.springboot.mail.service.EmailService;

import caseStudy.bookingMicroService.dao.UserRepository;
import caseStudy.bookingMicroService.entity.DatabaseSequence;
import caseStudy.bookingMicroService.entity.UserDetails;
import caseStudy.bookingMicroService.exception.ResourceNotFoundException;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

@Service
public class UserServiceImpl implements UserService {

	int id;
	@Autowired
	public EmailService emailService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private static MongoOperations mongo;

	private UserServiceImpl(MongoOperations mongo) {
		this.mongo = mongo;
	}

	// This method find the all userList who booked their tickets
	@Override
	public List<UserDetails> getAll() {
		List<UserDetails> userDetails = new ArrayList<UserDetails>();
		userRepo.findAll().forEach(userDetails1 -> userDetails.add(userDetails1));
		System.out.println(userDetails);
		return userDetails;
	}

	// This method find the userDetails who booked their ticket by pnr no
	@Override
	public UserDetails getUserDetailsById(long pnrNo) {
		List<UserDetails> userDetails = userRepo.findAll();
		for (UserDetails x : userDetails) {
			if (x.getPnrNo() == pnrNo) {
				id = x.getId();

			}
		}
		return userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No ticket is booked with PNR Number : " + pnrNo));
	}

	// This method is adds the booking of respective flights
	@Override
	public String addUserBookingDetails(UserDetails userDetails) {
		userRepo.save(userDetails);
		try {
			sendEmail(userDetails.getPnrNo());
		} catch (AddressException e) {
			e.printStackTrace();
		}
		return ("Your ticket is booked successfully..." + "Your pnr number is " + userDetails.getPnrNo()
				+ " Please proceed to payment....");
	}

	// This method cancels the ticket by pnr no
	@Override
	public String deleteUserBookingDetails(long pnrNo) {
		String msg = ("Your booking ticket with PNR Number : " + pnrNo + " is cancelled. "
				+ "Your payment amount will be credited to your account within 5 to 7 days..!!!");
		List<UserDetails> userDetails = userRepo.findAll();
		for (UserDetails x : userDetails) {
			if (x.getPnrNo() == pnrNo) {
				id = x.getId();
			}
		}
		UserDetails existingDetails = userRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Cannot delete as booking is not done with PNR Number : " + pnrNo));
		userRepo.delete(existingDetails);
		try {
			sendEmails(pnrNo);
		} catch (AddressException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public static int getNextSequence(String key) {
		DatabaseSequence dbSeq = mongo.findAndModify(query(where("id").is(key)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), DatabaseSequence.class);
		return !Objects.isNull(dbSeq) ? dbSeq.getSeq() : 1;
	}

	// to send an email after booking of a Flight ticket
	public void sendEmail(long pnrNo) throws AddressException {
		String data1 = "Your flight ticket booking is successful..!!";
		String data2 = "Please Check the details....!!!!!!";
		UserDetails userDet = getUserDetailsById(pnrNo);
		final Email email = DefaultEmail.builder().from(new InternetAddress("surajthopate24@gmail.com"))
				.replyTo(new InternetAddress("surajthopate24@gmail.com"))
				.to(Lists.newArrayList(new InternetAddress("surajthopate24@gmail.com")))
				.subject("Your ticket is booked").body(data1 + "\n" + data2 + "\n" + userDet).encoding("UTF-8").build();
		emailService.send(email);
	}

	// For email notification after Cancelled booking
	public void sendEmails(long pnrNo) throws AddressException {
		final Email email = DefaultEmail.builder().from(new InternetAddress("surajthopate24@gmail.com"))
				.replyTo(new InternetAddress("surajthopate24@gmail.com"))
				.to(Lists.newArrayList(new InternetAddress("surajthopate24@gmail.com")))
				.subject("Your ticket is Cancelled")
				.body("Your booking ticket with PNR Number : " + pnrNo + " is cancelled. "
						+ "Your payment amount will be credited to your account within 5 to 7 days..!!!")
				.encoding("UTF-8").build();
		emailService.send(email);
	}

}