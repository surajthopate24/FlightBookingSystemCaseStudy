package caseStudy.paymentMicroService;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import caseStudy.paymentMicroService.dao.UserPaymentRepository;
import caseStudy.paymentMicroService.entity.PaymentDetails;
import caseStudy.paymentMicroService.service.PaymentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceApplicationTests 
{

	@Autowired
	private PaymentServiceImpl paymentService;

	@MockBean
	private UserPaymentRepository userRepo;
	
	@Test
	@DisplayName("Testing whether User details database is empty")
	public void getAllDetailsTest1() {
		List<PaymentDetails> details =  paymentService.getAll();
		assertTrue(details.isEmpty());
	}
	
	
	
}