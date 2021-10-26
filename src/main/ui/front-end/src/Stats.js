/*import { useState, useEffect } from "react";
import { ListGroup, Row, Col, ThemeProvider } from "react-bootstrap";


class Stat {
  constructor(a, b) {
    this.source = a;
    this.val = b;
  }
}

let statUtil = [];

function GetStats() {
  const [services, setServices] = useState();
  const [tot, setTot] = useState();

  useEffect(() => {
    const getServices = async () => {
      // call: GET api/v1/allservices

      const response = await fetch("api/v1/allservices");
      const services1 = await response.json();
      //console.log(services1);
      if (response.ok) {
        setServices(services1);
      }
    };

    getServices();
  }, []);

  const getVal = async (servId) =>{
    const response = await fetch("/api/v1/served/" + servId);
    const tot1 = await response.json();
    if (response.ok) {
      return tot1;
    }
  }

  if(services != null)
    services.map((service) => {
      let val = getVal(service.id);
      if(val != null){
        let x = new Stat(service.name, val);
        statUtil.push(x);
      }
    });
}

function ListStats() {
  GetStats();

  return (
    <>
      {statUtil.map((s) => {
        return (
          <>
          <Row>
            Service {s.source} : {s.val} served
            </Row>
          </>
        );
      })}
    </>
  );
}

export { ListStats };*/
