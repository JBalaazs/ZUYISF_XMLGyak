package hu.saxzuyisf;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxZUYISF {
    public static void main(String[] args) {
        try {
            parseXMLFile("ZUYISF_kurzusfelvetel.xml");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLFile(String fileName) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SaxHandler handler = new SaxHandler();
        saxParser.parse(new File(fileName), handler);
    }

    private static class SaxHandler extends DefaultHandler {
    	
    	private String formatAttributes(Attributes attributes) {
    			int attributesLength = attributes.getLength();
    			if (attributesLength == 0) {
    				return "";
    			}
    			StringBuilder output = new StringBuilder(" {");
    			for (int i = 0; i < attributesLength; i++) {
    				output.append(attributes.getLocalName(i) + "=" + attributes.getValue(i));
    			if (i < attributesLength - 1) {
    				output.append(", ");
    			}
    		}
    		output.append("}");
    		return output.toString();
    	}
    			
    	int depth = 0;

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("   ".repeat(depth) + qName + formatAttributes(attributes) + " start");
            depth++;
        }

        public void endElement(String uri, String localName, String qName) {
            depth--;
            System.out.println("   ".repeat(depth) + qName + " end");
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                System.out.print("   ".repeat(depth) + content);
            }
        }
    }
}
