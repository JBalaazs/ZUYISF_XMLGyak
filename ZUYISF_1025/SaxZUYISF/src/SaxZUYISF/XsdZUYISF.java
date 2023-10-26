package SaxZUYISF;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class XsdZUYISF {
    public static void main(String[] args) {
        try {
            // XSD séma betöltése
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("ZUYISF_kurzusfelvetel.xsd"));
            
            // SAX elemző konfigurálása a séma validációra
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setSchema(schema);
            SAXParser saxParser = parserFactory.newSAXParser();
            
            // XML fájl validálása
            saxParser.parse("ZUYISF_kurzusfelvetel.xml", new XmlValidationHandler());
            System.out.println("XSD Validation successful.");
        } catch (SAXParseException e) {
            System.out.println("Unsuccessful validation: " + e.getMessage());
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static class XmlValidationHandler extends DefaultHandler {
        @Override
        public void error(SAXParseException e) throws SAXException {
            throw e;
        }
    }
}

