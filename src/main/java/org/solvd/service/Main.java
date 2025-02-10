package org.solvd.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.solvd.domain.services.InsuranceCompany;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/structure.xml");
        File xsdFile = new File("src/main/resources/structure.xsd");
        ValidatorXML.validateXml(xmlFile, xsdFile);
        File jsonFile = new File("src/main/resources/structure.json");

        XMLInputFactory factory = XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream = new FileInputStream(xmlFile.getAbsolutePath())) {
            XMLEventReader reader = factory.createXMLEventReader(fileInputStream);
            List<InsuranceCompany> insuranceCompanies = ParserStAX.parseInsuranceCompanies(reader);
            insuranceCompanies
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Could not find file " + e.getMessage());
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
        try {
            JAXBContext context = JAXBContext.newInstance(InsuranceCompany.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InsuranceCompany insuranceCompany = (InsuranceCompany) unmarshaller.unmarshal(xmlFile);

            System.out.println(insuranceCompany);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            InsuranceCompany insuranceCompany = mapper.readValue(jsonFile, InsuranceCompany.class);
            System.out.println(insuranceCompany);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
