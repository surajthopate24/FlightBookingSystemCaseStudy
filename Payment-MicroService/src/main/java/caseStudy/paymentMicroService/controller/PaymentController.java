package caseStudy.paymentMicroService.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import caseStudy.paymentMicroService.entity.PaymentDetails;
import caseStudy.paymentMicroService.service.PaymentService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/pay")
public class PaymentController {
	@Autowired
	PaymentService payService;

	// This method gets all the userlist who complete their payment
	@GetMapping("/getAll")
	@ApiOperation(value = "Get all users who completed payment")
	public List<PaymentDetails> getAll() {
		return payService.getAll();
	}

	// This method add the payment
	@PostMapping("/addPayment/")
	@ApiOperation(value = "Inorder to proceed to payment")
	public String addPaymentDetails(@Valid @RequestBody PaymentDetails payment) {
		long pnrNo = payment.getPnrNo();
		payService.proceedToPay(payment);
		payService.updateUserPaymentDetails(payment.getPnrNo());
		String sentMsg = "Your payment is successful";
		return sentMsg;
	}

	// This method cancel the payment
	@RequestMapping(value = "/cancel/{pnrNo}", method = { RequestMethod.GET, RequestMethod.DELETE })
	@ApiOperation(value = "Inorder to cancel your payment")
	public String deletePaymentDetails(@PathVariable long pnrNo) {
		return payService.deletePayment(pnrNo);
	}

}