import axios from'axios'
const FLIGHT_SEARCH_BY_PARAMS_URL ='http://localhost:8081/fare/findBy';
class SearchService{

    getFlightById(startPoint,endPoint,flightDate){
        return axios.get(FLIGHT_SEARCH_BY_PARAMS_URL  +'/'+ startPoint+'/'+ endPoint+ '/'+ flightDate);
    }

}
export default new SearchService();