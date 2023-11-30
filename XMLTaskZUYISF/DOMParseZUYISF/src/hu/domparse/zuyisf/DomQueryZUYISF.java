package hu.domparse.zuyisf;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Scanner;

public class DomQueryZUYISF 
{

	public static void main(String[] args) 
	{
	        
		Scanner scanner = new Scanner(System.in);
		System.out.println("Melyik elem adatait szeretné lekérdezni?");
	    String input = scanner.nextLine();
	
		    try 
		    {
		        	
		    	File f = new File("XMLZUYISF.xml");
		        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		        Document doc = dBuilder.parse(f);
		        doc.getDocumentElement().normalize();
		           
		
		        NodeList nodeList = doc.getElementsByTagName(input); //Megkeressük az inputhoz tartozókat.
		        System.out.println("Talált " + input + " elemek száma: " + nodeList.getLength());
		
		        for (int temp = 0; temp < nodeList.getLength(); temp++) 
		        {
		            	
		        Node nNode = nodeList.item(temp);
		
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) 
		        {
		                	
		        	Element element = (Element) nNode;
		            System.out.println("\nAktuális elem: " + element.getNodeName());
		                    
		                    
			            if (element.hasAttributes()) //Attribútumok kiírása. 
			            { 
			            	
			            	System.out.println("Attribútumok:");
			                for (int i = 0; i < element.getAttributes().getLength(); ++i) 
			                {
			                       	
			                	Node attr = element.getAttributes().item(i);
			                    System.out.println(" - " + attr.getNodeName() + ": " + attr.getNodeValue());
			                            
			                }
			                
			             }
			
			
			             NodeList children = element.getChildNodes(); //Gyerek elemek kiírása.
			             System.out.println("Gyermek elemek:");
			             
			             for (int i = 0; i < children.getLength(); i++) 
			             {
			                    	
			            	 Node child = children.item(i);
			                        
			                 if (child.getNodeType() == Node.ELEMENT_NODE) 
			                 {
			                        	
			                	 System.out.println(" - " + child.getNodeName() + ": " + child.getTextContent());
			                            
			                 }
			                 
			             }
			        }
		        
		        }
		        
		    }
		    catch (Exception e) 
		    {
		    	e.printStackTrace();
		    }
	    }
}


