package hu.domparse.zuyisf;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.StringWriter;
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
		
		        for (int temp = 0; temp < nodeList.getLength(); temp++) 
		        {
		            	
		        Node nNode = nodeList.item(temp);
		
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) 
		        {
		                	
		        	Element element = (Element) nNode;
		                    
		                    
			            if (element.hasAttributes()) //Attribútumok. 
			            { 
			            	
			                for (int i = 0; i < element.getAttributes().getLength(); ++i) 
			                {
			                       	
			                	Node attr = element.getAttributes().item(i);
			                            
			                }
			                
			             }
			
			
			             NodeList children = element.getChildNodes(); //Gyerek elemek.

			             for (int i = 0; i < children.getLength(); i++) 
			             {
			                    	
			            	 Node child = children.item(i);
			                 
			             }
			        }
		        
		        	Kiiras(doc, (Element) nNode);
		        
		        }
		        
		    }
		    catch (Exception e) 
		    {
		    	e.printStackTrace();
		    }
	    }
	
	//A Kiiras metódus implementációja.
    private static void Kiiras(Document doc, Element element) {
    	
    	try {

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                StringWriter writer = new StringWriter();
                transformer.transform(new DOMSource(element), new StreamResult(writer));

                System.out.println(writer.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


