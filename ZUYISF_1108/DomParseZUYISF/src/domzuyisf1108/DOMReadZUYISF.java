package domzuyisf1108;


import java.io.File;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;


public class DOMReadZUYISF {



	public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {

		

		File f = new File("orarendZUYISF.xml");

		

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder dBuilder = factory.newDocumentBuilder();

		

		Document doc = dBuilder.parse(f);

		

		doc.getDocumentElement().normalize();

		

		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		

		NodeList nList = doc.getElementsByTagName("ora");

		

		for (int i = 0; i < nList.getLength(); i++) {

			

			Node nNode = nList.item(i);

			

			System.out.println("\nCurrent Element: " + nNode.getNodeName());

			

			if (nNode.getNodeType() == Node.ELEMENT_NODE)

			{

				Element elem = (Element) nNode;

				String id = elem.getAttribute("id");

				

				Node node1 = elem.getElementsByTagName("targy").item(0);

				String tantargy = node1.getTextContent();

				

				Node node2 = elem.getElementsByTagName("idopont").item(0);

				String idopont = node2.getTextContent();

				

				Node node3 = elem.getElementsByTagName("oktato").item(0);

				String oktato = node3.getTextContent();

				

				Node node4 = elem.getElementsByTagName("helyszin").item(0);

				String helyszin = node4.getTextContent();

				
				
				Node node5 = elem.getElementsByTagName("szak").item(0);

				String szak = node5.getTextContent();
				

				System.out.println("Id: " + id);

				System.out.println("Tantárgy: " + tantargy);

				System.out.println("Időpont: " + idopont);

				System.out.println("Tanár: " + oktato);

				System.out.println("Helyszín: " + helyszin);

				System.out.println("Szak: " + szak);

			}

		}

	}



}