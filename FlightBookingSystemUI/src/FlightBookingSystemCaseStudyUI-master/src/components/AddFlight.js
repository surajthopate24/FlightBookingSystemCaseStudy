import React, { useState, useEffect } from 'react'
import { useHistory, useParams } from 'react-router-dom';
import AdminService from '../Services/AdminService'
import { Link } from 'react-router-dom'

const AddFlight = () => {
    const [flightNo, setflightNo] = useState('')
    const [startPoint, setstartPoint] = useState('')
    const [endPoint, setendPoint] = useState('')
    const [arrivalTime, setarrivalTime] = useState('')
    const [deptTime, setdeptTime] = useState('')
    const [duration, setduration] = useState('')
    const [noOfSeats, setnoOfSeats] = useState('')
    const [economyClass, seteconomyClass] = useState('')
    const [premiumEconomy, setpremiumEconomy] = useState('')
    const [businessClass, setbusinessClass] = useState('')
    const [flightDate, setflightDate] = useState('')
    const history = useHistory();
    const { id } = useParams();

    const saveOrUpdateFlight = (e) => {
        e.preventDefault();
        const FlightDetails = { flightNo, startPoint, endPoint, arrivalTime, deptTime, duration, noOfSeats, economyClass, premiumEconomy, businessClass, flightDate }
        if (id) {
            AdminService.upDateFlight(id, FlightDetails).then((response) => {
                var e=JSON.stringify(response.data);
                alert(e);
                history.push('/adminFlightList')
            }).catch(error => {
                console.log(error)
            })
        } else {
            AdminService.addFlight(FlightDetails).then((response) => {
                var e=JSON.stringify(response.data);
                alert(e);
                history.push('/adminFlightList')
            }).catch(error => {
                console.log(error)
            })

        }


    }

    useEffect(() => {
        AdminService.getFlightById(flightNo).then((response) => {
            setflightNo(response.data.flightNo)
            setstartPoint(response.data.startPoint)
            setendPoint(response.data.endPoint)
            setarrivalTime(response.data.arrivalTime)
            setdeptTime(response.data.deptTime)
            setduration(response.data.duration)
            setnoOfSeats(response.data.noOfSeats)
            seteconomyClass(response.data.economyClass)
            setpremiumEconomy(response.data.premiumEconomy)
            setbusinessClass(response.data.businessClass)
            setflightDate(response.data.flightDate)

        }).catch(error => {
            console.log(error)
        })

    }, [])

    const title = () => {

        if (id) {
            return <h2 className="text-center">Update Flight</h2>
        } else {
            return <h2 className="text-center">Add Flight</h2>
        }
    }
    return (
        <div>
            <br></br><br></br>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">

                    <br></br>
                        {
                            title()
                        }
                        <div className="card-body">
                            <form>
                                <div className="form-group mb-2">
                                    <label className="form-label">FlightNo</label>

                                    <input
                                        type="text"
                                        placeholder="Enter flight Number"
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
                                        placeholder="Enter start point"
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
                                        placeholder="Enter end point"
                                        name="endPoint"
                                        className="form-control"
                                        value={endPoint}
                                        onChange={(e) => setendPoint(e.target.value)}>
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">ArrivalTime</label>

                                    <input
                                        type="text"
                                        placeholder="Enter Arrival Time"
                                        name="arrivalTime"
                                        className="form-control"
                                        value={arrivalTime}
                                        onChange={(e) => setarrivalTime(e.target.value)}>
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">DeptTime</label>

                                    <input
                                        type="text"
                                        placeholder="Enter Departure Time"
                                        name="deptTime"
                                        className="form-control"
                                        value={deptTime}
                                        onChange={(e) => setdeptTime(e.target.value)}>
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">Duration</label>

                                    <input
                                        type="text"
                                        placeholder="Enter Duration"
                                        name="duration"
                                        className="form-control"
                                        value={duration}
                                        onChange={(e) => setduration(e.target.value)}>
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">NoOfSeats</label>

                                    <input
                                        type="text"
                                        placeholder="Enter Number of seats"
                                        name="noOfSeats"
                                        className="form-control"
                                        value={noOfSeats}
                                        onChange={(e) => setnoOfSeats(e.target.value)}>
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">EconomyClass Fare</label>

                                    <input
                                        type="text"
                                        placeholder="Enter Economy Class Fare"
                                        name="economyClass"
                                        className="form-control"
                                        value={economyClass}
                                        onChange={(e) => seteconomyClass(e.target.value)}>
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">PremiumEconomy Fare</label>

                                    <input
                                        type="text"
                                        placeholder="Enter Premium Economy Fare"
                                        name="premiumEconomy"
                                        className="form-control"
                                        value={premiumEconomy}
                                        onChange={(e) => setpremiumEconomy(e.target.value)}>
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">BusinessClass Fare</label>

                                    <input
                                        type="text"
                                        placeholder="Enter Business Class Fare"
                                        name="businessClass"
                                        className="form-control"
                                        value={businessClass}
                                        onChange={(e) => setbusinessClass(e.target.value)}>
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">FlightDate</label>

                                    <input
                                        type="text"
                                        placeholder="Enter flightDate"
                                        name="flightDate"
                                        className="form-control"
                                        value={flightDate}
                                        onChange={(e) => setflightDate(e.target.value)}>
                                    </input>

                                </div>
                                <button className="btn btn-success" onClick={(e) => saveOrUpdateFlight(e)} >Submit </button>
                                <Link to="/login" className="btn btn-danger"> Cancel </Link>
                            
                            </form>
                            <br></br>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    )
}

export default AddFlight
