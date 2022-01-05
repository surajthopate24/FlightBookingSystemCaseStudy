package caseStudy.paymentMicroService.service;
import java.util.List;

import caseStudy.paymentMicroService.entity.PaymentDetails;

public interface PaymentService 
{
	public List<PaymentDetails> getAll();
	public String proceedToPay(PaymentDetails payment);
	public String deletePayment(long pnrNo);
	public void updateUserPaymentDetails(long pnrNo);
}
