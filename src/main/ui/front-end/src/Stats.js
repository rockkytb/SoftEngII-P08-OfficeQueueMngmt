import { useState, useEffect } from "react";
import { ListGroup, Row, Col, ThemeProvider } from "react-bootstrap";


class Stat {
  constructor(a, b) {
    this.source = a;
    this.val = b;
  }
}

function GetStats(props) {
  const [services, setServices] = useState();

  let statUtil = [];

  useEffect(() => {
    const getServices = async () => {
      // call: GET api/v1/allservices

      const response = await fetch("api/v1/allservices");
      const services = await response.json();
      if (response.ok) {
        setServices(services);
      }
    };

    getServices();
  }, []);

  async function getVal(servId) {
    const response = await fetch("/api/v1/served/" + servId);
    const tot = await response.json();
    if (response.ok) {
      return tot;
    }
  }

  services.map((service) => {
    let val = getVal(service.id);
    let x = new Stat(service.name, val);
    statUtil.push(x);
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

export { ListStats };
