import { Container, Navbar } from 'react-bootstrap';


function NavbarCustom(props) {
    return (
        <Navbar bg="dark" variant="dark">
            <Container className="d-flex justify-content-center align-items-center" >
                <Navbar.Brand href="#home">
                    Office Queue Management
                </Navbar.Brand>
            </Container>
        </Navbar>
    );
}


export default NavbarCustom;