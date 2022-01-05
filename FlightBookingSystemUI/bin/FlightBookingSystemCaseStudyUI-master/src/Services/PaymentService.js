import axios from'axios'
const PAY_FLIGHT_URL ='http://localhost:8083/pay/addPayment/';

class PaymentService{

    doPayment(PaymentDetails){
        return axios.post(PAY_FLIGHT_URL ,PaymentDetails)
    }

}
export default new PaymentService();