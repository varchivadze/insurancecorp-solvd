package org.solvd.domain.support;

import org.solvd.domain.accident.Vehicle;
import org.solvd.domain.services.Insurance;
import org.solvd.domain.services.InsuranceCompany;
import org.solvd.domain.staff.Client;
import org.solvd.domain.staff.Employee;
import org.solvd.domain.staff.Person;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class ParserStAX {

    public static List<InsuranceCompany> parseInsuranceCompanies(XMLEventReader reader) throws XMLStreamException {
        List<InsuranceCompany> companies = new ArrayList<>();
        InsuranceCompany company = null;

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("InsuranceCompany")) {
                if (company != null) {
                    companies.add(company);
                }
            }
            if (event.isStartElement()) {
                String elementName = event.asStartElement().getName().getLocalPart();
                if ("InsuranceCompany".equals(elementName)) {
                    company = new InsuranceCompany();
                } else if (company != null) {
                    switch (elementName) {
                        case "id":
                            company.setId(Long.parseLong(reader.getElementText()));
                            break;
                        case "name":
                            company.setName(reader.getElementText());
                            break;
                        case "Address":
                            company.setAddress(parseAddress(reader));
                            break;
                        case "employees":
                            company.setEmployees(parserEmployees(reader));
                            break;
                        case "clients":
                            company.setClients(parseClient(reader));
                            break;
                    }
                }

            }

        }
        return companies;
    }

    public static List<Employee> parserEmployees(XMLEventReader reader) throws XMLStreamException {

        List<Employee> employees = new ArrayList<>();
        Employee employee = null;

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("employees")) {
                break;
            }

            if (event.isStartElement()) {
                String elementName = event.asStartElement().getName().getLocalPart();
                if ("Employee".equals(elementName)) {
                    employee = new Employee();
                    employees.add(employee);
                } else if (employee != null) {
                    switch (elementName) {
                        case "id":
                            employee.setId(Long.parseLong(reader.getElementText()));
                            break;
                        case "employeeId":
                            employee.setEmployeeId(Long.parseLong(reader.getElementText()));
                            break;
                        case "name":
                            employee.setName(reader.getElementText());
                            break;
                        case "surname":
                            employee.setSurname(reader.getElementText());
                            break;
                        case "dob":
                            employee.setDob(LocalDate.parse(reader.getElementText()));
                            break;
                        case "position":
                            employee.setPosition(reader.getElementText());
                            break;
                        case "salary":
                            employee.setSalary(new BigDecimal(reader.getElementText()));
                            break;
                        case "bonus":
                            employee.setBonus(new BigDecimal(reader.getElementText()));
                            break;
                        case "passportId":
                            employee.setPassportId(reader.getElementText());
                            break;
                        case "Address":
                            employee.setHomeAddress(parseAddress(reader));
                            break;
                        case "telephoneNumber":
                            employee.setTelephoneNumber(reader.getElementText());
                            break;

                    }
                }
            }
        }
        return employees;
    }

    public static Address parseAddress(XMLEventReader reader) throws XMLStreamException {
        Address address = new Address();

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("Address")) {
                break;
            }

            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                String elementName = startElement.getName().getLocalPart();

                switch (elementName) {
                    case "id":
                        address.setId(Long.parseLong(reader.getElementText()));
                        break;
                    case "country":
                        address.setCountry(reader.getElementText());
                        break;
                    case "city":
                        address.setCity(reader.getElementText());
                        break;
                    case "postalCode":
                        address.setPostalCode(reader.getElementText());
                        break;
                    case "street":
                        address.setStreet(reader.getElementText());
                        break;
                    case "unit":
                        address.setUnit(reader.getElementText());
                        break;

                }
            }

        }
        return address;
    }

    public static List<Client> parseClient(XMLEventReader reader) throws XMLStreamException {
        List<Client> clients = new ArrayList<>();
        Client client = null;

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("clients")) {

                break;
            }
            if (event.isStartElement()) {
                String elementName = event.asStartElement().getName().getLocalPart();
                if ("Client".equals(elementName)) {
                    client = new Client();
                    clients.add(client);
                } else if (client != null) {
                    switch (elementName) {
                        case "id":
                            client.setId(Long.parseLong(reader.getElementText()));
                            break;
                        case "clientId":
                            client.setClientId(Long.parseLong(reader.getElementText()));
                            break;
                        case "telephoneNumber":
                            client.setTelephoneNumber(reader.getElementText());
                            break;
                        case "name":
                            client.setName(reader.getElementText());
                            break;
                        case "surname":
                            client.setSurname(reader.getElementText());
                            break;
                        case "dob":
                            client.setDob(LocalDate.parse(reader.getElementText()));
                            break;
                        case "Address":
                            client.setHomeAddress(parseAddress(reader));
                            break;
                        case "vehicles":
                            client.setVehicles(parsVehicles(reader));
                            break;
                    }
                }
            }
        }
        return clients;
    }

    public static List<Vehicle> parsVehicles(XMLEventReader reader) throws XMLStreamException {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = null;

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("vehicles")) {

                break;
            }

            if (event.isStartElement()) {
                String elementName = event.asStartElement().getName().getLocalPart();
                if ("Vehicle".equals(elementName)) {
                    vehicle = new Vehicle();
                    vehicles.add(vehicle);
                } else if (vehicle != null) {
                    switch (elementName) {
                        case "id":
                            vehicle.setId(Long.parseLong(reader.getElementText()));
                            break;
                        case "Person":
                            vehicle.setOwner(parsePerson(reader));
                            break;
                        case "made":
                            vehicle.setMade(reader.getElementText());
                            break;
                        case "model":
                            vehicle.setModel(reader.getElementText());
                            break;
                        case "yearProduced":
                            vehicle.setYearProduced(Year.parse(reader.getElementText()));
                            break;
                        case "plateNumber":
                            vehicle.setPlateNumber(reader.getElementText());
                            break;
                        case "vin":
                            vehicle.setVin(reader.getElementText());
                            break;
                        case "seats":
                            vehicle.setSeats(Integer.parseInt(reader.getElementText()));
                            break;
                        case "insurances":
                            vehicle.setInsurances(parseInsurances(reader));
                            break;
                    }
                }
            }

        }
        return vehicles;
    }

    public static List<Insurance> parseInsurances(XMLEventReader reader) throws XMLStreamException {
        List<Insurance> insurances = new ArrayList<>();
        Insurance insurance = null;

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("insurances")) {
                break;
            }

            if (event.isStartElement()) {
                String elementName = event.asStartElement().getName().getLocalPart();
                if ("Insurance".equals(elementName)) {
                    insurance = new Insurance();
                    insurances.add(insurance);
                } else if (insurance != null) {
                    switch (elementName) {
                        case "id":
                            insurance.setId(Long.parseLong(reader.getElementText()));
                            break;
                        case "policeNumber":
                            insurance.setPoliceNumber(reader.getElementText());
                            break;
                        case "insuredFrom":
                            insurance.setInsuredFrom(LocalDate.parse(reader.getElementText()));
                            break;
                        case "insuredTill":
                            insurance.setInsuredTill(LocalDate.parse(reader.getElementText()));
                            break;
                        case "insuranceCoverage":
                            insurance.setInsuranceCoverage(new BigDecimal(reader.getElementText()));
                            break;
                        case "oc":
                            insurance.setOc(Boolean.parseBoolean(reader.getElementText()));
                            break;
                    }
                }
            }
        }
        return insurances;
    }

    public static Person parsePerson(XMLEventReader reader) throws XMLStreamException {
        Person person = new Person();
        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("Person")){
                break;
            }

            if (event.isStartElement()) {
                String elementName = event.asStartElement().getName().getLocalPart();
                switch (elementName) {
                    case "id":
                        person.setId(Long.parseLong(reader.getElementText()));
                        break;
                    case "name":
                        person.setName(reader.getElementText());
                        break;
                    case "surname":
                        person.setSurname(reader.getElementText());
                        break;
                    case "dob":
                        person.setDob(LocalDate.parse(reader.getElementText()));
                        break;
                    case "telephoneNumber":
                        person.setTelephoneNumber(reader.getElementText());
                        break;
                    case "Address":
                        person.setHomeAddress(parseAddress(reader));
                        break;
                }
            }
        }
        return person;
    }
}
