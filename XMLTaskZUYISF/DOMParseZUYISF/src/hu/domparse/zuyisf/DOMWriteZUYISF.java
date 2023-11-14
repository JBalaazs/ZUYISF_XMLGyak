package hu.domparse.zuyisf;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMWriteZUYISF {

    public static void main(String[] args) 
    {
        
    	try 
    	{
            File inputFile = new File("XMLZUYISF.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            printNode(doc.getDocumentElement(), 0); //Fa struktúra
           
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Bekezdések hozzáadása
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // Indentálási mélység

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("XMLZUYISF1.xml"));
            transformer.transform(source, result);

        } 
    	catch (Exception e) 
    	{
            e.printStackTrace();
        }
    }

    private static void printNode(Node node, int depth) 
    {
    	
        String indent = " ".repeat(depth * 4);

        if (node.getNodeType() == Node.ELEMENT_NODE) 
        {
        	
            System.out.println(indent + "<" + node.getNodeName() + ">");
            NodeList nodeList = node.getChildNodes();
            
            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                printNode(nodeList.item(i), depth + 1);
            }
            System.out.println(indent + "</" + node.getNodeName() + ">");
        } 
        else if (node.getNodeType() == Node.TEXT_NODE && !node.getTextContent().trim().isEmpty()) 
        {
            System.out.println(indent + node.getTextContent().trim());
        }
        
    }
}
