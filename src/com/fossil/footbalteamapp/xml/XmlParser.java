package com.fossil.footbalteamapp.xml;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fossil.footballteamapp.daoimp.DataBaseConnectionImp;
/**
 * This is used for read data from xml and store the database
 * @author Tushar
 *
 */
 public class XmlParser{
	 /**
	  * This method is used to store data from xml file into data base
	  * @throws ParserConfigurationException from method
	  * @throws SAXException from method
	  * @throws IOException from method
	  */
public static void xml_Implementation() throws ParserConfigurationException, SAXException, IOException {

  try {
     File xmlFile = new File("src\\players1.xml");
     DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
     DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
     Document doc = dBuilder.parse(xmlFile);
     doc.getDocumentElement().normalize();
     NodeList nList = doc.getElementsByTagName("player");
    
     for (int temp = 0; temp < nList.getLength(); temp++) {
       Node nNode = nList.item(temp);
       if (nNode.getNodeType() == Node.ELEMENT_NODE) {
         Element eElement = (Element) nNode;
         String name = eElement.getElementsByTagName("name").item(0).getTextContent();
         int age = Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent());
         int playedmatch = Integer.parseInt(eElement.getElementsByTagName("playedmatch").item(0).getTextContent());
         String previousteam = eElement.getElementsByTagName("previousteam").item(0).getTextContent();
         String currentteam = eElement.getElementsByTagName("currentteam").item(0).getTextContent();
        double price = Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent());
         String qry="insert into football.playerdetails(name,age,playedmatch,priviousteam,currentteam,price) values(?,?,?,?,?,?)";
 		DataBaseConnectionImp databaseconnectionimpobj=DataBaseConnectionImp.getInstance();
 		PreparedStatement pstmt=databaseconnectionimpobj.getConnection(qry);
         pstmt.setString(1,name);
         pstmt.setInt(2, age);
         pstmt.setInt(3, playedmatch);
         pstmt.setString(4, previousteam);
         pstmt.setString(5, previousteam);
         pstmt.setDouble(6, price);
         pstmt.executeUpdate();
       }
     }
     System.out.println("Successfullt entered players list from XML!!!!");
   } catch (Exception e) {
     System.err.println("SomeThing Went Wrong!!!!!");
   }
 }
}