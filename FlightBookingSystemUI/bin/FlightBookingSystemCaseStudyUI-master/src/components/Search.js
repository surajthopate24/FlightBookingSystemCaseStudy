import React, { useState } from 'react'
import { useHistory } from 'react-router-dom';
import SearchService from '../Services/SearchService'
import { Link } from 'react-router-dom'

const Search = () => {
    const [startPoint, setstartPoint] = useState('')
    const [endPoint, setendPoint] = useState('')
    const [flightDate, setflightDate] = useState('')
    const history = useHistory();
    const [Flights, setFlights] = useState([]);


    const searchFlight = (e) => {
        e.preventDefault();
        SearchService.getFlightById(startPoint, endPoint, flightDate).then((response) => {
            console.log(response)
            setFlights(response.data);
        }).catch(error => {
            console.log(error)
        })
    }

    return (
        <>
            <section className='showcase login'>
                <div className='showcase-overlay'>

                    <form className='form-control'>
                        <input type='text' name='From' id='From' placeholder='Enter Start Station'
                            value={startPoint}
                            onChange={(e) => setstartPoint(e.target.value)} />

                        <input type='text' name='To' id='To' placeholder='Enter Destination'
                            value={endPoint}
                            onChange={(e) => setendPoint(e.target.value)} />

                        <input type='text' name='date' id='date' placeholder='Enter Date'
                            value={flightDate}
                            onChange={(e) => setflightDate(e.target.value)} />

                        <button className="btn btn-info" to='/flightList' onClick={(e) => searchFlight(e)} >Search Flights</button>
                        <div className="container">
                            <br></br>
                            <br></br>
                            <h2 className="text-center">List Of Flights Available</h2>

                            <br></br>
                            <br></br>
                            <div class="row">
                                <div class="table-responsive ">
                                    <table class="table table-striped table-hover table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Flight No </th>
                                                <th>StartPoint </th>
                                                <th>EndPoint </th>
                                                <th>DeptTime </th>
                                                <th>Duration </th>
                                                <th>NoOfSeats </th>
                                                <th>EconomyClass </th>
                                                <th>PremiumEconomy </th>
                                                <th>BusinessClass </th>
                                                <th>FlightDate </th>
                                                <th>Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            {
                                                Flights.map(
                                                    FlightDetails =>
                                                        <tr key={FlightDetails.Id}>
                                                            <td>{FlightDetails.flightNo} </td>
                                                            <td>{FlightDetails.startPoint} </td>
                                                            <td>{FlightDetails.endPoint}</td>
                                                            <td>{FlightDetails.deptTime}</td>
                                                            <td>{FlightDetails.duration}</td>
                                                            <td>{FlightDetails.noOfSeats}</td>
                                                            <td>{FlightDetails.economyClass}</td>
                                                            <td>{FlightDetails.premiumEconomy}</td>
                                                            <td>{FlightDetails.businessClass}</td>
                                                            <td>{FlightDetails.flightDate}</td>
                                                            <td> <Link className="btn btn-info" to='/booking'> Book </Link>
                                                            </td>


                                                        </tr>
                                                )
                                            }
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
        </>
    )
}

export default Search