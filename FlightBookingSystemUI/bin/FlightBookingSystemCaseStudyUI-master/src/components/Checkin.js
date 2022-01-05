import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { useHistory, useParams } from 'react-router-dom';
import CheckinService from '../Services/CheckinService'


const Checkin = () => {
    const [pnrNo, setpnrNo] = useState('')
    const history = useHistory();
    const [Ticket, setTicket] = useState([])


    const getCheckin = (e) => {
        e.preventDefault();
        CheckinService.getCheckin(pnrNo).then((response) => {
            setTicket(response.data)
            console.log(response.data);
        }).catch(error => {
            console.log(error)
        })
    }

    return (
        <>
            <section className='showcase login'>
                <div className='showcase-overlay'>
                    <form className='form-control'>
                        <label>PNR Number</label>
                        <input
                            type='number'
                            name='pnrNo'
                            id='pnrNo'
                            placeholder='Enter PNR Number'
                            value={pnrNo}
                            onChange={(e) => setpnrNo(e.target.value)}
                            required
                        />

                        <button className="btn btn-success" onClick={(e) => getCheckin(e)} >Submit </button>

                        <div className="Ticket">
                        <br></br>
                            <h4>Ticket Details</h4>
                            <br></br>

                            <h5>PNR NO: {Ticket.pnrNo}</h5>
                            <h5>Name: {Ticket.name}</h5>
                            <h5>Email: {Ticket.email}</h5>
                            <h5>Gender: {Ticket.gender}</h5>
                            <h5>SeatNo: {Ticket.seatNo}</h5>
                            <h5>Flight No: {Ticket.flightNo}</h5>
                            <h5>StartPoint: {Ticket.startPoint}</h5>
                            <h5>EndPoint: {Ticket.endPoint}</h5>
                            <h5>Flight Date: {Ticket.flightDate}</h5>
                            <h5> Departure Time: {Ticket.deptTime}</h5>
                            <h5> Duration: {Ticket.duration}</h5>
                            <h5> Class Type: {Ticket.classType}</h5>
                            <h5> Payment: {Ticket.payment}</h5>
                        </div>



                    </form>
                </div>


            </section>
        </>
    )
}


export default Checkin
