import axios from'axios'
const BOOK_FLIGHT_URL ='http://localhost:8082/user/book/add';

class BookService{
    bookFlight(UserDetails){
        return axios.post(BOOK_FLIGHT_URL ,UserDetails)
    }

}
export default new BookService();