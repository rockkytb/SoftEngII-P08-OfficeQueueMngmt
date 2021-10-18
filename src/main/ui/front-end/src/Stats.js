import { useState } from "react";
import { ListGroup, Row, Col, ThemeProvider } from "react-bootstrap";

class Stat {
  constructor(a, b) {
    source = a;
    val = b;
  }
}

function GetStats(props) {
  const [services, setServices] = useState();

  statUtil = [];

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
    val = getVal(service.id);
    x = new Stat(service.name, val);
    statUtil.push(x);
  });
}

function ListStats (){

    return <>
        {statUtil.map(s => {
            return<>
            Service {s.source} : {s.val} served
            </>
        })}
    
    </>

}

export { ListStats };
