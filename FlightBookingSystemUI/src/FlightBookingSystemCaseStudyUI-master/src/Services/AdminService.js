import axios from'axios'
const FLIGHT_SEARCH_ALL_URL ='http://localhost:8081/fare/findAll';
const FLIGHT_ADD_FLIGHT_URL ='http://localhost:8081/fare/add';
const FLIGHT_GET_FLIGHT_BY_ID_URL ='http://localhost:8081/fare/find';
const FLIGHT_UPDATE_FLIGHT_BY_ID_URL ='http://localhost:8081/fare/update';
const FLIGHT_DELETE_FLIGHT_BY_ID_URL ='http://localhost:8081/fare/delete';
const FLIGHT_ADMIN_LOGIN_URL='http://localhost:8081/fare/signup'


class AdminService{

getAllFlights(){
    return axios.get(FLIGHT_SEARCH_ALL_URL)
}

addFlight(FlightDetails){
    return axios.post(FLIGHT_ADD_FLIGHT_URL ,FlightDetails)
}

getFlightById(flightNo){
    return axios.get(FLIGHT_GET_FLIGHT_BY_ID_URL + '/'+ flightNo);
}

upDateFlight(flightNo,FlightDetails){
    return axios.put(FLIGHT_UPDATE_FLIGHT_BY_ID_URL + '/'+ flightNo ,FlightDetails);
}

deleteFlight(flightNo){
    return axios.delete(FLIGHT_DELETE_FLIGHT_BY_ID_URL + '/' + flightNo);
}

adminLogin(adminDetails){
    return axios.post(FLIGHT_ADMIN_LOGIN_URL , adminDetails );
}

}
export default new AdminService();