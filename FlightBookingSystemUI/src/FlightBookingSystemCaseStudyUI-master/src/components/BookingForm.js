import React, { useState} from 'react'
import { useHistory, useParams } from 'react-router-dom';
import BookService from '../Services/BookService'
import { Link } from 'react-router-dom'

const BookingForm = () => {

  const [name, setname] = useState('')
  const [email, setemail] = useState('')
  const [gender, setgender] = useState('')
  const [adult, setadult] = useState('')
  const [children, setchildren] = useState('')
  const [age, setage] = useState('')
  const [flightNo, setflightNo] = useState('')
  const [startPoint, setstartPoint] = useState('')
  const [endPoint, setendPoint] = useState('')
  const [classType, setclassType] = useState('')
  const [payment, setpayment] = useState('')
  const [id, setid] = useState('')
  const [pnrNo, setpnrNo] = useState('')
  const history = useHistory();

  const bookedFlight = (e) => {
    e.preventDefault();
    const UserDetails = { name,email,gender,adult,children,age,flightNo, startPoint, endPoint,classType,id,pnrNo,payment }
    
        BookService.bookFlight(UserDetails).then((response) => {
          var e=JSON.stringify(response.data);
            alert(e);
            console.log(response);
            history.push('/booking')
        }).catch(error => {
            console.log(error)
        })

    }


  return (
    <div>
      <br></br>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
          <br></br><br></br>
            <h2 className="text-center">Book Flight</h2>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">Name</label>

                  <input
                    type="text"
                    placeholder="Enter Name"
                    name="name"
                    className="form-control"
                    value={name}
                    onChange={(e) => setname(e.target.value)}>
                  </input>

                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Email</label>

                  <input
                    type="text"
                    placeholder="Enter Email"
                    name="email"
                    className="form-control"
                    value={email}
                    onChange={(e) => setemail(e.target.value)}>
                  </input>

                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Gender</label>

                  <input
                    type="text"
                    placeholder="Enter Gender"
                    name="gender"
                    className="form-control"
                    value={gender}
                    onChange={(e) => setgender(e.target.value)}>
                  </input>

                </div>
                <div className="form-group mb-2">
                  <label className="form-label">No of Adults</label>

                  <input
                    type="text"
                    placeholder="Enter No of Adults"
                    name="adults"
                    className="form-control"
                    value={adult}
                    onChange={(e) => setadult(e.target.value)}>
                  </input>

                </div>
                <div className="form-group mb-2">
                  <label className="form-label">No of Childrens</label>

                  <input
                    type="text"
                    placeholder="Enter No of Childrens"
                    name="children"
                    className="form-control"
                    value={children}
                    onChange={(e) => setchildren(e.target.value)}>
                  </input>

                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Age</label>

                  <input
                    type="text"
                    placeholder="Enter Age"
                    name="age"
                    className="form-control"
                    value={age}
                    onChange={(e) => setage(e.target.value)}>
                  </input>

                </div>
                <div className="form-group mb-2">
                  <label className="form-label">FlightNo</label>

                  <input
                    type="text"
                    placeholder="Enter FlightNo"
                    name="flightNo"
                    className="form-control"
                    value={flightNo}
                    onChange={(e) => setflightNo(e.target.value)}>
                  </input>

                </div>
                <div className="form-group mb-2">
                  <label className="form-label">StartPoint</label>

                  <input
                    type="text"
                    placeholder="Enter StartPoint"
                    name="startPoint"
                    className="form-control"
                    value={startPoint}
                    onChange={(e) => setstartPoint(e.target.value)}>
                  </input>

                </div>
                <div className="form-group mb-2">
                  <label className="form-label">EndPoint</label>

                  <input
                    type="text"
                    placeholder="Enter EndPoint"
                    name="endPoint"
                    className="form-control"
                    value={endPoint}
                    onChange={(e) => setendPoint(e.target.value)}>
                  </input>

                </div>
                <div className="form-group mb-2">
                  <label className="form-label">ClassType</label>

                  <input
                    type="text"
                    placeholder="Enter ClassType"
                    name="classType"
                    className="form-control"
                    value={classType}
                    onChange={(e) => setclassType(e.target.value)}>
                  </input>

                </div>

                <Link className="btn btn-success" onClick={(e) => bookedFlight(e)}  >Submit </Link>
                <Link className="btn btn-info" to='/payment'> Goto Payment </Link> 
               
              </form>
            </div>

          </div>

        </div>
      </div>
      <br></br>
    </div>
  )
}

export default BookingForm
