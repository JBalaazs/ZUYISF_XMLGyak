package domzuyisf1115;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomQueryZUYISF {
    
    public static void main(String[] args) {

        try {
            File f = new File("orarendZUYISF.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(f);
            doc.getDocumentElement().normalize();    

            NodeList nodeList = doc.getElementsByTagName("targy");
            System.out.println("Talált targy elemek száma: " + nodeList.getLength());

            List<String> targyak = new ArrayList<>();

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    targyak.add(element.getTextContent());
                }
            }
            
            System.out.print("1a)\nKurzusnév: [");
            for (int i = 0; i < targyak.size(); i++) 
            {
				if (i == targyak.size()-1) 
				{
					System.out.print(targyak.get(i));
				}
				else
				{
					System.out.print(targyak.get(i) + ", ");
				}
			}
            System.out.print("]");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("\n\n1b)");
        DOMQuery.executeQuery();
        
        System.out.println("\n\n1c)");
        KurzusOktatok.Query();
        
        System.out.println("\n\n1d)");
        OsszetettLekerdezes.Query();
    }

	private static class DOMQuery {

        public static void executeQuery() {
            try {
                File inputFile = new File("orarendZUYISF.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();

                NodeList nodeList = doc.getElementsByTagName("ora");

                FileWriter writer = new FileWriter("output.xml");

                if (nodeList.getLength() > 0) {
                    Node node = nodeList.item(0);

                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        printFormattedElement(element, "", writer);
                    }
                }

                writer.close();

            } catch (IOException | SAXException | ParserConfigurationException e) {
                e.printStackTrace();
            }
        }

        private static void printFormattedElement(Element element, String indent, FileWriter writer) throws IOException {
            String output = "\n" + indent + "<" + element.getNodeName();
            if (element.hasAttributes()) {
                for (int i = 0; i < element.getAttributes().getLength(); ++i) {
                    Node attr = element.getAttributes().item(i);
                    output += " " + attr.getNodeName() + "=\"" + attr.getNodeValue() + "\"";                    
                }
            }
            
            output += ">";

            System.out.print(output);
            writer.write(output); 

            NodeList children = element.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    printFormattedElement((Element) node, indent + "\t", writer);
                } else if (node.getNodeType() == Node.TEXT_NODE && !node.getNodeValue().trim().isEmpty()) {
                    String textOutput = node.getNodeValue().trim();
                    System.out.print(textOutput);
                    writer.write(textOutput);
                }
            }

            String closingTagOutput = indent + "</" + element.getNodeName() + ">\n";
            System.out.print(closingTagOutput);
            writer.write(closingTagOutput);
        }
    }
    
    private static class KurzusOktatok
    {
    	public static void Query()
    	{
    	
	    	try {
	    	    File f = new File("orarendZUYISF.xml");
	    	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	    Document doc = dBuilder.parse(f);
	    	    doc.getDocumentElement().normalize();
	
	    	    NodeList nodeList = doc.getElementsByTagName("oktato");
	    	    System.out.println("Talált oktatók száma: " + nodeList.getLength());
	
	    	    List<String> oktatok = new ArrayList<>();
	
	    	    for (int temp = 0; temp < nodeList.getLength(); temp++) {
	    	        Node nNode = nodeList.item(temp);
	
	    	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	    	            Element element = (Element) nNode;
	    	            oktatok.add(element.getTextContent());
	    	        }
	    	    }
	
	    	    System.out.print("Oktatók: [");
	    	    for (int i = 0; i < oktatok.size(); i++) {
	    	        if (i == oktatok.size() - 1) {
	    	            System.out.print(oktatok.get(i));
	    	        } else {
	    	            System.out.print(oktatok.get(i) + ", ");
	    	        }
	    	    }
	    	    System.out.print("]");
	    	} catch (Exception e) {
	    	    e.printStackTrace();
	    	}
    	}
    }
    
    private static class OsszetettLekerdezes
    {
    	public static void Query()
    	{
    	
    		try {
    		    File inputFile = new File("orarendZUYISF.xml");
    		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    		    Document doc = dBuilder.parse(inputFile);
    		    doc.getDocumentElement().normalize();

    		    NodeList oraNodeList = doc.getElementsByTagName("ora");
    		    System.out.println("Hétfői kurzusok helyszínei és tárgyai:");

    		    for (int i = 0; i < oraNodeList.getLength(); i++) {
    		        Node oraNode = oraNodeList.item(i);
    		        
    		        if (oraNode.getNodeType() == Node.ELEMENT_NODE) {
    		            Element oraElement = (Element) oraNode;
    		            NodeList idopontNodeList = oraElement.getElementsByTagName("idopont");

    		            for (int j = 0; j < idopontNodeList.getLength(); j++) {
    		                Node idopontNode = idopontNodeList.item(j);

    		                if (idopontNode.getNodeType() == Node.ELEMENT_NODE) {
    		                    Element idopontElement = (Element) idopontNode;
    		                    String nap = idopontElement.getElementsByTagName("nap").item(0).getTextContent();

    		                    if ("Hétfő".equals(nap)) {
    		                        String targy = oraElement.getElementsByTagName("targy").item(0).getTextContent();
    		                        String helyszin = oraElement.getElementsByTagName("helyszin").item(0).getTextContent();
    		                        System.out.println("Tárgy: " + targy + ", Helyszín: " + helyszin);
    		                    }
    		                }
    		            }
    		        }
    		    }
    		} catch (Exception e) {
    		    e.printStackTrace();
    		}
    		
    	}
    }
}