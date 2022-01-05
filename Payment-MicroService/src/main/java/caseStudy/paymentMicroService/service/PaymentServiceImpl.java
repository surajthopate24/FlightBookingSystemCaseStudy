package caseStudy.paymentMicroService.service;

import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import caseStudy.paymentMicroService.dao.UserPaymentRepository;
import caseStudy.paymentMicroService.dao.UserRepository;
import caseStudy.paymentMicroService.entity.PaymentDetails;
import caseStudy.paymentMicroService.entity.UserDetails;
import caseStudy.paymentMicroService.exception.ResourceNotFoundException;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

@Service
public class PaymentServiceImpl implements PaymentService {
	int id;

	@Autowired
	public EmailService emailService;

	@Autowired
	UserPaymentRepository userPayRepo;

	@Autowired
	UserRepository userRepo;

	// This method gets all the userlist who complete their payment
	@Override
	public List<PaymentDetails> getAll() {
		List<PaymentDetails> payDetails = userPayRepo.findAll();
		return payDetails;
	}

	// This method add the payment
	@Override
	public String proceedToPay(PaymentDetails payment) {
		long pnrNo = payment.getPnrNo();
		List<UserDetails> det = userRepo.findAll();
		for (UserDetails x : det) {
			if (x.getPnrNo() == pnrNo) {
				id = x.getId();
			}
		}
		userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"Cannot proceed the payment request as booking is not done with PNR Number : " + pnrNo));
		userPayRepo.save(payment);
		// For email notification after successful payment
		try {
			sendEmail(payment);
		} catch (AddressException e) {
			e.printStackTrace();
		}
		return ("Your payment for PNR Number " + payment.getPnrNo() + " is Successful...!!!");

	}

	// This method cancel the payment
	@Override
	public String deletePayment(long pnrNo) {
		userPayRepo.deleteById(pnrNo);
		return "You payment for " + pnrNo + " will be credited to your account within 7 days..";
	}

	// This method is to update payment field in user details after successful
	// payment
	@Override
	public void updateUserPaymentDetails(long pnrNo) {
		List<UserDetails> details = userRepo.findAll();
		for (UserDetails x : details) {
			// System.out.println(x);
			if (x.getPnrNo() == pnrNo) {
				x.setPayment("Sucessful");
				userRepo.save(x);
			}
		}
	}

	// For email notification after successful payment
	public void sendEmail(PaymentDetails payment) throws AddressException {
		final Email email = DefaultEmail.builder().from(new InternetAddress("surajthopate24@gmail.com"))
				.replyTo(new InternetAddress("surajthopate24@gmail.com"))
				.to(Lists.newArrayList(new InternetAddress("surajthopate24@gmail.com")))
				.subject("Payment is Successful")
				.body("Your payment for PNR Number " + payment.getPnrNo() + " is Successful...!!!").encoding("UTF-8")
				.build();
		emailService.send(email);
	}

}
