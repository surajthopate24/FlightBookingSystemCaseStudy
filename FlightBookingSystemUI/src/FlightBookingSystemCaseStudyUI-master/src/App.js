import React from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import Header from './components/Header'
import Showcase from './components/Showcase'
import Footer from './components/Footer'
import Login from './components/Login.js'
import Destinations from './components/Destinations'
import Error from './components/Error'
import Search from './components/Search'
import Checkin from './components/Checkin'
import FlightList from './components/FlightList'
import AddFlight from './components/AddFlight'
import BookingForm from './components/BookingForm'
import PaymentForm from './components/PaymentForm'


function App() {
  return (
    <div>
      <Router>
        <Header />

        <Switch>

          <Route exact path="/">
            <Showcase />
            <Destinations />
            <Footer />
          </Route>

          <Route exact path="/login">
            <Login />

          </Route>

          <Route exact path="/checkin">
            <Checkin></Checkin>
            <Footer />
          </Route>

          <Route exact path="/payment">
            <PaymentForm></PaymentForm>
            <Footer />
          </Route>

          <Route exact path="/adminFlightList">
            <FlightList></FlightList>
            <Footer />
          </Route>


          <Route exact path="/booking">
            <BookingForm></BookingForm>
            <Footer />
          </Route>


          <Route exact path="/edit-flight/:flightId">
            <AddFlight />
            <Footer />
          </Route>

          <Route exact path="/addFlight">
            <AddFlight />
            <Footer />
          </Route>

          <Route exact path="/search">
            <Search />
            <Footer />
          </Route>

          <Route path="/checkin">
            <Checkin />
            <Footer />
          </Route>

          <Route path='*'>
            <Error />
            <Footer />
          </Route>

        </Switch>


      </Router>
    </div>

  )
}

export default App