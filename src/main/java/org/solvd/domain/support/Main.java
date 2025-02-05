package org.solvd.domain.support;

import org.solvd.domain.services.InsuranceCompany;

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


    }
}
