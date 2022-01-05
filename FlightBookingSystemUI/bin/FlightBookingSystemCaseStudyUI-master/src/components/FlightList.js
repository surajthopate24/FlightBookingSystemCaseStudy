import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import AdminService from '../Services/AdminService'


const FlightList = () => {
    const [Flights, setFlights] = useState([])
    
    useEffect(() => {
        getAllFlights();
    }, [])

    const getAllFlights = () => {
        AdminService.getAllFlights().then((response) => {
            setFlights(response.data)
            console.log(response.date);
        }).catch(error => {
            console.log(error);
        })
    }

    const deleteFlight = (flightNo) => {
        AdminService.deleteFlight(flightNo).then((response) => {
            alert("Your flight has been Deleted");
            getAllFlights();
        }).catch(error => {
            console.log(error);
        })
    }

    return (
        <div className="container">
            <br></br><br></br>
            <h2 className="text-center">List Of Flights</h2>
            <Link to="/addFlight" className="btn btn-success" >Add Flight</Link>
            <br></br><br></br>
            <table className="table table-bordered table-striped">
                <thead>
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
                                    <td> <Link className="btn btn-info" to={`/edit-flight/${FlightDetails.flightNo}`}> Update </Link>
                                        <button className="btn btn-danger" onClick={() => deleteFlight(FlightDetails.flightNo)}
                                            style={{ marginLeft: "10px" }} >Delete </button></td>


                                </tr>
                        )
                    }
                </tbody>

            </table>

        </div>
    )
}

export default FlightList
