import { ListGroup, Row, Col } from 'react-bootstrap'

function ListGroupQueue(props) {
    return ( /*THE BEST WAY TO MANAGE THIS WOULD BE A MAP ON COUNTERS*/
        <ListGroup.Item>
            <Row>

                Counter 1: {props.nextClientServed}

            </Row>
        </ListGroup.Item>
    );
}

export { ListGroupQueue }