package hu.domparse.zuyisf;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Scanner;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomModifyZUYISF {

    
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException 
	{
	
		Scanner scanner = new Scanner(System.in);
	 
		System.out.println("Adja meg az elem nevét, amit módosítani szeretne! (Ügyvéd/Vádlott/Bűnös-e/Ügy/Ítéletet_hoz/Bíró/Jegyző):");
		String elementName = scanner.nextLine();
	
		printIdentifiersForElement(elementName);
		String elementId = scanner.nextLine();
	        
		printAttributes(elementName);
		String propertyName = scanner.nextLine();
	
		System.out.println("Mire szeretné módosítani a(z) " + propertyName + " tulajdonságot?");
		String newValue = scanner.nextLine();
	        
		File inputFile = new File("XMLZUYISF.xml");
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();    
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();    
		Document doc = docBuilder.parse(inputFile);    
		doc.getDocumentElement().normalize();
	
	    
		NodeList elements = doc.getElementsByTagName(elementName);    
		Node elementToModify = null;
	    
		for (int i = 0; i < elements.getLength(); i++) 
		{  		
	        
			Node node = elements.item(i);	
	        
			//Ügyvéd
			if (node.getAttributes().getNamedItem("Ügyvédi_ID") != null &&   
					node.getAttributes().getNamedItem("Ügyvédi_ID").getTextContent().equals(elementId) ||   
	            	    (node.getAttributes().getNamedItem("Védi") != null && 
	            	    node.getAttributes().getNamedItem("Védi").getTextContent().equals(elementId)) && 
	            	    elementName.equals("Ügyvéd")) {
	            	    elementToModify = node;
	            	    break;
	            	}
	            
	        //Vádlott  
			if (node.getAttributes().getNamedItem("Személyi_ig") != null && 
					node.getAttributes().getNamedItem("Személyi_ig").getTextContent().equals(elementId) && 	
					elementName.equals("Vádlott")) { 	
					elementToModify = node;	
					break;  
				}
	            
			//Bűnös-e
			if (node.getAttributes().getNamedItem("Vádlott") != null && 
					node.getAttributes().getNamedItem("Vádlott").getTextContent().equals(elementId) ||         
					(node.getAttributes().getNamedItem("Ügy") != null &&             	
					node.getAttributes().getNamedItem("Ügy").getTextContent().equals(elementId)) &&             	
					elementName.equals("Bűnös-e")) {            	
					elementToModify = node;            
					break;            
			}
			
			//Ügy
			if (node.getAttributes().getNamedItem("Ügyszám_ID") != null &&         
					node.getAttributes().getNamedItem("Ügyszám_ID").getTextContent().equals(elementId) &&            	
					elementName.equals("Ügy")) {            	
					elementToModify = node;            
					break;        
			}
	
			//Ítéletet_hoz
			if (node.getAttributes().getNamedItem("Bíró") != null &&         
					node.getAttributes().getNamedItem("Bíró").getTextContent().equals(elementId) ||             	
					(node.getAttributes().getNamedItem("Ügy") != null && 
	            	    node.getAttributes().getNamedItem("Ügy").getTextContent().equals(elementId)) &&             	
					elementName.equals("Ítéletet_hoz")) {            	
					elementToModify = node;            
					break;            
			}
	
			//Bíró
			if (node.getAttributes().getNamedItem("Bíró_ID") != null && 
					node.getAttributes().getNamedItem("Bíró_ID").getTextContent().equals(elementId) &&            	
					elementName.equals("Bíró")) {            	
					elementToModify = node;            
					break;    	
			}
	
			//Jegyző
			if (node.getAttributes().getNamedItem("Jegyző_ID") != null && 
					node.getAttributes().getNamedItem("Jegyző_ID").getTextContent().equals(elementId) ||             	
					(node.getAttributes().getNamedItem("Rögzítés") != null &&             	
					node.getAttributes().getNamedItem("Rögzítés").getTextContent().equals(elementId)) && 
	            	elementName.equals("Jegyző")) {            	
					elementToModify = node;            
					break;
			}
	        
		}
	
	        
		if (elementToModify != null) 
		{
	           
			NodeList childNodes = elementToModify.getChildNodes();
	        
			for (int j = 0; j < childNodes.getLength(); j++) 
			{
	           
				Node childNode = childNodes.item(j);
	            
				if (childNode.getNodeName().equals(propertyName)) 
				{
					childNode.setTextContent(newValue);
					break;            
				}   
				
		}
	            
	            
			//Írja vissza a módosított dokumentumot
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("XMLZUYISF.xml"));
			transformer.transform(source, result);
			System.out.println(propertyName + " tulajdonság módosítva a következő értékre: " + newValue);
			
			Kiiras(doc, elementToModify, propertyName);
		} 
		else 
		{
			System.out.println("Nem található " + elementName + " az ID-val: " + elementId); 
		}
	         
		scanner.close();
		
	}
    
    
	private static void Kiiras(Document doc, Node node, String propertyName) {
	    try {
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        //Az összes gyerekelem kiírása
	        StringWriter writer = new StringWriter();
	        transformer.transform(new DOMSource(node), new StreamResult(writer));
	        System.out.println(writer.toString());

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
    
private static void printAttributes(String elementName) //Mindig kiírja az adott elemhez tartozó attribútumokat! 
{	
        
	String attributes = "";
    
	switch (elementName) 
	{
	
			case "Ügyvéd":
				attributes = "Szakterület, Telefonszám, Ügyvéd_Név";
				break;

			case "Vádlott":
				attributes = "Lakcím, Szülidő, Kor, Priusz, Név";
				break;
      
			case "Bűnös-e":            	
				attributes = "Vád"; 	
				break;

            case "Ügy":
            	attributes = "Típus, Dátum, Állapot";
            	break;

            case "Ítéletet_hoz":
            	attributes = "Ügyek_száma, Ítélet";
            	break;

            case "Bíró":
            	attributes = "Bíró_Név, Tapasztalat, Tanítványok";
            	break;
	
            case "Jegyző":
            	attributes = "Jegyző_Név, Munkaidő, Nyelvtudás";
            	break;

            default:
            	attributes = "Nincs ilyen tulajdonság!";
 
        }
	
        System.out.println("Adja meg a(z) " + elementName + " valamelyik tulajdonságát (" + attributes + "):");
        
}
     
private static void printIdentifiersForElement(String elementName) //Mindig kiírja az adott elemhez tartozó azonosítókat! 
{
	
	String identifiers = "";
    
	switch (elementName) 
    
	{
        
    
			case "Ügyvéd":
				identifiers = "Ügyvédi_ID, Védi";
				break;

			case "Vádlott":
				identifiers = "Személyi_ig";      
				break;
				
			case "Bűnös-e":
				identifiers = "Vádlott, Ügy";    
				break;
				
			case "Ügy":
				identifiers = "Ügyszám_ID";
				break;

			case "Ítéletet_hoz":
				identifiers = "Bíró, Ügy";
				break;
				
			case "Bíró":
				identifiers = "Bíró_ID";
				break;
				
			case "Jegyző":
				identifiers = "Jegyző_ID, Rögzítés";  
				break;
				
			default:
				identifiers = "Nincs ilyen elem vagy azonosítók nem definiáltak";

	}
    
	System.out.println("Adja meg a(z) " + elementName + " valamelyik azonosítóját (" + identifiers + "):");  
}

}
