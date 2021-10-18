import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Row, Col, Button } from 'react-bootstrap'
import NavbarCustom from './NavbarCustom.js';
import { NewCounterButton, NewService, NewTicketButton, NextClientButton, NewServiceCounterButton } from './CustomButtons'
import { useState } from 'react'
import { ListGroupQueue } from './ListGroupQueue.js'
import { ListStats } from './Stats.js'

//import { Switch, Route, Redirect, BrowserRouter as Router } from 'react-router-dom';

function App() {
  const [counterId, setCounterId] = useState(1);
  const [nextClientServed, setNextClientServed] = useState(0)
  const [services, setServices] = useState(); /*GET FROM THE SERVER! /api/v1/allServices*/
  const [counters, setCounters] = useState(); /* GET FROM THE SERVER! api missing */
  const [dirty, setDirty] = useState(false);

  async function nextClient() {
    // call: GET /api/v1/counter/{id}/nextticket
    const response = await fetch('/api/v1/counter/' + counterId + '/nextticket');
    const nextticket = await response.json();
    if (response.ok) {

      setNextClientServed(nextticket.number);
      setDirty(true);

    }
  }

  async function addService(serviceName) {
    // call: POST /api/v1/service
    return new Promise((resolve, reject) => {
      fetch('/api/v1/service', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: serviceName.name
      }).then((response) => {
        if (response.ok) {
          resolve(response.json());
        } else {
          response.json()
            .then((obj) => { reject(obj); }) // error msg in the response body
            .catch((err) => { reject({ errors: [{ param: "Application", msg: "Cannot parse server response" }] }) }); // something else
        }
      }).catch((err) => { reject({ errors: [{ param: "Server", msg: "Cannot communicate" }] }) }); // connection errors
    });
  }

  async function addCounter(counterName) {
    // call: POST /api/v1/counter
    return new Promise((resolve, reject) => {
      fetch('/api/v1/counter', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: counterName.name
      }).then((response) => {
        if (response.ok) {
          resolve(response.json());
        } else {
          response.json()
            .then((obj) => { reject(obj); }) // error msg in the response body
            .catch((err) => { reject({ errors: [{ param: "Application", msg: "Cannot parse server response" }] }) }); // something else
        }
      }).catch((err) => { reject({ errors: [{ param: "Server", msg: "Cannot communicate" }] }) }); // connection errors
    });
  }

  async function addServiceCounter(serviceCounter) {
    // call: POST /api/v1/linkCounterService


    return new Promise((resolve, reject) => {
      fetch('/api/v1/linkCounterService', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: serviceCounter
      }).then((response) => {
        if (response.ok) {
          resolve(response.json());
        } else {
          response.json()
            .then((obj) => { reject(obj); }) // error msg in the response body
            .catch((err) => { reject({ errors: [{ param: "Application", msg: "Cannot parse server response" }] }) }); // something else
        }
      }).catch((err) => { reject({ errors: [{ param: "Server", msg: "Cannot communicate" }] }) }); // connection errors
    });
  }

  async function newTicket(service) {
    // call: POST /api/v1/ticket
    return new Promise((resolve, reject) => {
      fetch('/api/v1/ticket', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: service.serviceCode
      }).then((response) => {
        if (response.ok) {
          resolve(response.json());
        } else {
          response.json()
            .then((obj) => { reject(obj); }) // error msg in the response body
            .catch((err) => { reject({ errors: [{ param: "Application", msg: "Cannot parse server response" }] }) }); // something else
        }
      }).catch((err) => { reject({ errors: [{ param: "Server", msg: "Cannot communicate" }] }) }); // connection errors
    });
  }

  return (
    <>
      <NavbarCustom />

      <Row className="page">

        <Col> {/**COUNTER*/}

          <Row className="d-flex justify-content-center align-items-center pt-1 pl-3">
            <h2> Counter </h2>
          </Row>

          <Row className="d-flex justify-content-center align-items-center pt-1 pl-3">
            <NextClientButton nextClient={nextClient} />
          </Row>
        </Col>

        <Col> {/**CUSTOMER FIX TICKET GENERATION: getServices is required to allow the choice of the service*/}
          <div className="verticalLine"></div>

          <Row className="d-flex justify-content-center align-items-center pt-1 pl-3">

            <h2> Customer </h2>
          </Row>

          <Row className="d-flex justify-content-center align-items-center pt-1 pl-3">
            <NewTicketButton newTicket={newTicket} />
          </Row>



        </Col>

        <Col> {/**MANAGER */}
          <div className="verticalLine"></div>

          <Row className="d-flex justify-content-center align-items-center pt-1 pl-3">
            <h2> Manager </h2>
          </Row>


          <Row className="d-flex justify-content-center align-items-center pt-1 pl-3">
            <NewService addService={addService} />
          </Row>

          <Row className="d-flex justify-content-center align-items-center pt-1 pl-3">
            <NewCounterButton addCounter={addCounter} />
          </Row>

          <Row className="d-flex justify-content-center align-items-center pt-1 pl-3">
            <NewServiceCounterButton addServiceCounter={addServiceCounter} />
          </Row>

          <Row>
            <ListStats/>
          </Row>

        </Col>

        <Col>{/**MAIN DISPLAY */}
          <div className="verticalLine"></div>
          <Row className="d-flex justify-content-center align-items-center pt-1 pl-3">
            <h2>Main Display</h2>
          </Row>

          <Row className="d-flex justify-content-center align-items-center pt-1 pl-3">
            <ListGroupQueue nextClientServed={nextClientServed} dirty={dirty} setDirty={setDirty} />
          </Row>
        </Col>
      </Row>

    </>
  );
}

export default App;
