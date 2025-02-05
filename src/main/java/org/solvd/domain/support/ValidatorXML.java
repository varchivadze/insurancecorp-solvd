package org.solvd.domain.support;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ValidatorXML {

    public static void validateXml(File pathToXml, File xsdFile) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(pathToXml));
            System.out.println("XML compared and valid");
        } catch (Exception e) {
            System.out.println("XML is not valid -> " + e.getMessage());
        }
    }
}
