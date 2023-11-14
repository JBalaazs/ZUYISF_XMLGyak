package hu.domparse.zuyisf;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Comment;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class DomReadZUYISF {

	public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException 
	{
	
		try
		{
				
			File f = new File("XMLZUYISF.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);
			doc.getDocumentElement().normalize();
		
			System.out.println("Gyökérelem: " + doc.getDocumentElement().getNodeName());
		
			
		    NodeList nodeList = doc.getElementsByTagName("Ügyvéd"); //Ügyvéd elemek.
		    printNodeList(nodeList);
		
		    nodeList = doc.getElementsByTagName("Vádlott"); //Vádlott elemek.
		    printNodeList(nodeList);
		
		    nodeList = doc.getElementsByTagName("Bűnös-e"); //Bűnös-e elemek.
		    printNodeList(nodeList);
		
		    nodeList = doc.getElementsByTagName("Ügy"); //Ügy elemek.
		    printNodeList(nodeList);
		
		    nodeList = doc.getElementsByTagName("Ítéletet_hoz"); //Ítéletet_hoz elemek.
		    printNodeList(nodeList);
		
		    nodeList = doc.getElementsByTagName("Bíró"); //Bíró elemek.
		    printNodeList(nodeList);
		
		    nodeList = doc.getElementsByTagName("Jegyző"); //Jegyző elemek.
		    printNodeList(nodeList);
	
		    Element root = doc.getDocumentElement();
		    System.out.println("Gyökérelem: " + root.getNodeName()); //Gyökérelem.
		        
		} 
		catch (Exception e) 
		{
		        e.printStackTrace();
		}
	}
	
private static void printNodeList(NodeList nodeList) {
	for (int temp = 0; temp < nodeList.getLength(); temp++) 
	{
		Node nNode = nodeList.item(temp);
	    System.out.println("\nJelenlegi elem: " + nNode.getNodeName());

	    if (nNode.getNodeType() == Node.COMMENT_NODE) 
	    {
	    	
	    	System.out.println("Comment: " + nNode.getTextContent());  // Kiírja a komment tartalmát
	    	continue;
	    	
	    }

	
	    if (nNode.getNodeType() == Node.ELEMENT_NODE) 
	    {
	    	
	    	Element eElement = (Element) nNode;
	    	System.out.println("Elemhez tartozó attribútumok: ");
	        for (int j = 0; j < eElement.getAttributes().getLength(); j++) 
	        {
	        	Node attr = eElement.getAttributes().item(j);
	            System.out.println(" - " + attr.getNodeName() + ": " + attr.getNodeValue());
	        }
	
	        NodeList children = eElement.getChildNodes();
	        System.out.println("Gyerek elemei:");
	        for (int j = 0; j < children.getLength(); j++)
	        {
	        	
	        	Node child = children.item(j);
	       
	            if (child.getNodeType() == Node.ELEMENT_NODE) 
	            {
	            	
	            	System.out.println(" - " + child.getNodeName() + ": " + child.getTextContent());
	                    
	            }
	        }
	    }   
	}	
}
	
	

}