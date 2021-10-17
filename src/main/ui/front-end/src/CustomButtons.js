import { Button, Modal, Form, Container, Row } from 'react-bootstrap';
import { useState, useEffect } from 'react';


function NewCounterButton(props) {
    const [modalCounterShow, setModalCounterShow] = useState(false);

    return (
        <>
            <Button variant="secondary" onClick={() => { setModalCounterShow(true) }}>New Counter</Button>
            <ModaleNewCounter
                show={modalCounterShow}
                onHide={() => setModalCounterShow(false)}
                addCounter={props.addCounter}
            />
        </>
    );
}

function NewService(props) {
    const [modalServiceShow, setModalServiceShow] = useState(false);

    return (
        <>
            <Button variant="secondary" onClick={() => { setModalServiceShow(true) }}> New Service </Button>
            <ModaleNewService
                show={modalServiceShow}
                onHide={() => setModalServiceShow(false)}
                addService={props.addService}

            />
        </>
    );
}

function ModaleNewService(props) {
    const { show, ...rest } = props;
    const [serviceName, setServiceName] = useState("");
    const [validated, setValidated] = useState(false);

    const handleSubmit = (event) => {
        event.preventDefault();
        const form = event.currentTarget;

        if (form.checkValidity() === false) {
            event.stopPropagation();
        } else {
            const service = {
                name: serviceName
            };
            props.onHide();
            props.addService(service);
            setServiceName("");


        }
        setValidated(false);

    };

    return (
        <Modal
            show={show}
            onHide={rest.onHide}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Create new Service
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form noValidate validated={validated} onSubmit={handleSubmit}>
                    <Form.Group>
                        <Form.Label>New Service: </Form.Label>
                        <Form.Control type="text" value={serviceName} maxLength={90} required onChange={ev => setServiceName(ev.target.value)} />
                        <Form.Text className="text-muted">
                            Name service is required
                        </Form.Text>
                        <Form.Control.Feedback type="invalid">
                            Please insert new service.
                        </Form.Control.Feedback>
                    </Form.Group>
                    <Container className="d-flex justify-content-end">
                        <Button className="mr-1" variant="secondary" onClick={() => { props.onHide(); setServiceName(""); setValidated(false); }}>Close</Button>
                        <Button className="ml-1" type="submit" variant="success"> Create </Button>
                    </Container>
                </Form>
            </Modal.Body>

        </Modal>
    );
}

function ModaleNewCounter(props) {

    const { show, ...rest } = props;
    const [counterName, setCounterName] = useState("");
    const [validated, setValidated] = useState(false);

    const handleSubmit = (event) => {
        event.preventDefault();
        const form = event.currentTarget;

        if (form.checkValidity() === false) {
            event.stopPropagation();
        } else {
            const counter = {
                name: counterName
            };
            props.onHide();
            props.addCounter(counter);
            setCounterName("");
            


        }
        setValidated(false);

    };

    return (
        <Modal
            show={show}
            onHide={rest.onHide}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Create new Counter
                </Modal.Title>
            </Modal.Header>

            <Modal.Body>
                <Form noValidate validated={validated} onSubmit={handleSubmit}>
                    <Form.Group>
                        <Form.Label>New Counter: </Form.Label>
                        <Form.Control type="text" value={counterName} maxLength={90} required onChange={ev => setCounterName(ev.target.value)} />
                        <Form.Text className="text-muted">
                            Name counter is required
                        </Form.Text>
                        <Form.Control.Feedback type="invalid">
                            Please insert new counter.
                        </Form.Control.Feedback>
                    </Form.Group>
                    <Container className="d-flex justify-content-end">
                        <Button className="mr-1" variant="secondary" onClick={() => { props.onHide(); setCounterName(""); setValidated(false); }}>Close</Button>
                        <Button className="ml-1" type="submit" variant="success"> Create </Button>
                    </Container>
                </Form>
            </Modal.Body>


        </Modal>
    );
}

function NewTicketButton(props) {
    const [modalNewTicketShow, setModalNewTicketShow] = useState(false);
    return (
        <>
            <Button variant="secondary" onClick={() => { setModalNewTicketShow(true) }}>New Ticket</Button>
            <ModalNewTicket
                show={modalNewTicketShow}
                onHide={() => setModalNewTicketShow(false)}
                newTicket={props.newTicket}

            />
        </>
    );
}

function ModalNewServiceCounter(props) {

    const { show, ...rest } = props;
    const [selectedService, setSelectedService] = useState("");
    const [selectedCounter, setSelectedCounter] = useState("");
    const [validated, setValidated] = useState(false);
    const [availableServices, setAvailableServices] = useState();
    const [availableCounters, setAvailableCounters] = useState();

    useEffect(() => {
        const getAvailableServices = async () => {
            // call: GET api/v1/allservices

            const response = await fetch('api/v1/allservices');
            const services = await response;
            if (response.ok) {
                setAvailableServices(services);
            }
        };

        const getAvailableCounters = async () => {
            // call: GET api/v1/allcounters

            const response = await fetch('api/v1/allcounters');
            const counters = await response;
            if (response.ok) {
                setAvailableCounters(counters);
            }
        };

        getAvailableServices();

        getAvailableCounters();


    }, []);

    const handleSubmit = (event) => {
        event.preventDefault();
        const form = event.currentTarget;

        if (form.checkValidity() === false) {
            event.stopPropagation();
        } else {
            const serviceCounter = {
                serviceCode: selectedService, 
                counterId: selectedCounter
            };
            props.onHide();
            props.addServiceCounter(serviceCounter);
            setSelectedService("");
            setSelectedCounter("");
            


        }
        setValidated(false);

    };

    return (
        <Modal
            show={show}
            onHide={rest.onHide}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    New Service to Counter
                </Modal.Title>
            </Modal.Header>

            <Modal.Body>
                <Form noValidate validated={validated} onSubmit={handleSubmit}>
                    <Form.Group>
                        <Form.Label>Select service: </Form.Label>
                        <select className="ml-1">
                            {availableServices.map(service =>
                                <option
                                    label={service.name}
                                    id={service.id}
                                    onChange={ev => setSelectedService(ev.target.checked)}
                                />
                            )}
                        </select >
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Select counter: </Form.Label>
                        <select className="ml-1">
                            {availableCounters.map(counter =>
                                <option
                                    label={counter.name}
                                    id={counter.id}
                                    onChange={ev => setSelectedCounter(ev.target.checked)}
                                />
                            )}
                        </select >
                    </Form.Group>
                    <Container className="d-flex justify-content-end">
                        <Button className="mr-1" variant="secondary" onClick={() => { props.onHide(); setSelectedService(); setValidated(false); }}>Close</Button>
                        <Button className="ml-1" type="submit" variant="success"> New Service to Counter </Button>
                    </Container>
                </Form>
            </Modal.Body>


        </Modal>
    );
}

function NewServiceCounterButton(props) {
    const [modalServiceCounterShow, setModalServiceCounterShow] = useState(false);

    return (
        <>
            <Button variant="secondary" onClick={() => { setModalServiceCounterShow(true) }}> New Service Counter </Button>
            <ModalNewServiceCounter
                show={modalServiceCounterShow}
                onHide={() => setModalServiceCounterShow(false)}
                addServiceCounter={props.addServiceCounter}

            />
        </>
    );
}

function ModalNewTicket(props) {

    const { show, ...rest } = props;
    const [selectedService, setSelectedService] = useState("");
    const [validated, setValidated] = useState(false);
    const [availableServices, setAvailableServices] = useState();

    useEffect(() => {
        const getAvailableServices = async () => {
            // call: GET api/v1/allServices

            const response = await fetch('api/v1/allservices');
            const services = await response;
            if (response.ok) {
                setAvailableServices(services);
            }
        };

        getAvailableServices();


    }, []);

    const handleSubmit = (event) => {
        event.preventDefault();
        const form = event.currentTarget;

        if (form.checkValidity() === false) {
            event.stopPropagation();
        } else {
            const service = {
                serviceCode: selectedService
            };
            props.onHide();
            props.newTicket(service);
            setSelectedService("");
            setValidated(false);


        }
        setValidated(true);

    };

    return (
        <Modal
            show={show}
            onHide={rest.onHide}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    New Ticket
                </Modal.Title>
            </Modal.Header>

            <Modal.Body>
                <Form noValidate validated={validated} onSubmit={handleSubmit}>
                    <Form.Group>
                        <Form.Label>Select service: </Form.Label>
                        <Row className="ml-1">
                            {availableServices.map(service =>
                                <Form.Check
                                    type="radio"
                                    label={service}
                                    id={service}
                                    onChange={ev => setSelectedService(ev.target.checked)}
                                />
                            )}
                        </Row >
                    </Form.Group>
                    <Container className="d-flex justify-content-end">
                        <Button className="mr-1" variant="secondary" onClick={() => { props.onHide(); setSelectedService(); setValidated(false); }}>Close</Button>
                        <Button className="ml-1" type="submit" variant="success"> New Ticket </Button>
                    </Container>
                </Form>
            </Modal.Body>


        </Modal>
    );
}


function NextClientButton(props) {
    return (
        <>
            <Button variant="secondary" onClick={() => { props.nextClient() }}>  Next Client  </Button>
        </>
    )
}
export { NewCounterButton, NewService, NewTicketButton, NextClientButton, NewServiceCounterButton }