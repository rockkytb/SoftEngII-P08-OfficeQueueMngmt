import { Button, Modal, Form, Container } from 'react-bootstrap';
import { useState } from 'react';
//import { useHistory } from 'react-router-dom'

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
            /*DA AGGIUNGERE GESTIONE ADD AL DB add(name) */
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
                    <Button className="mr-1" variant="secondary" onClick={() => {props.onHide(); setServiceName(""); setValidated(false);}}>Close</Button>
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
            /*DA AGGIUNGERE GESTIONE ADD AL DB add(name) */
            props.addCounter(counter);
            setCounterName("");
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
                    <Button className="mr-1" variant="secondary" onClick={() => {props.onHide(); setCounterName(""); setValidated(false);}}>Close</Button>
                    <Button className="ml-1" type="submit" variant="success"> Create </Button>
                    </Container>
                </Form>
            </Modal.Body>
        
            
        </Modal>
    );
}

function NewTicketButton(props){
    return (
        <>
            <Button variant="secondary" onClick={() => { props.newTicket() }}>New Ticket</Button>
            
        </>
    );
}

/* A MODAL IS REQUIRED TO SELECT THE SERVICE FORM THE LIST FOR THE NEW TICKET */

function NextClientButton(props){
    return(
        <>
        <Button variant="secondary" onClick={() => {props.nextClient() }}>  Next Client  </Button>
        </>
    )
}
export { NewCounterButton, NewService, NewTicketButton, NextClientButton }