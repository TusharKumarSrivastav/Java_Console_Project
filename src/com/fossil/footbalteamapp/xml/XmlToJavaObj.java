package com.fossil.footbalteamapp.xml;

import java.io.File;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.fossil.footballteamapp.daoimp.DataBaseConnectionImp;
import com.fossile.footballteamapp.dao.DataBaseConnection;
import com.mysql.jdbc.PreparedStatement;
/**
 * This is responsible to insert player Information from XML to database
 * @author Tushar
 *
 */
public class XmlToJavaObj {
	/**
	 * This is static method 
	 * It is responsible to read Xml file and store the database
	 */
   public static void readXML() {
	try {
		File file=new File("src\\players.xml");
		JAXBContext jaxbContext=JAXBContext.newInstance(Player.class);
		Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
		Player player=(Player)unmarshaller.unmarshal(file);
		String qry="insert into football.playerdetails(name,age,playedmatch,priviousteam,currentteam,price) values(?,?,?,?,?,?)";
	    DataBaseConnectionImp databaseconnectionobj=DataBaseConnectionImp.getInstance();
	    java.sql.PreparedStatement pstmt= databaseconnectionobj.getConnection(qry);
	    pstmt.setString(1,player.getName());
	    pstmt.setInt(2,player.getAge());
	    pstmt.setInt(3,player.getPlayedmatch());
	    pstmt.setString(4,player.getPreviousteam());
	    pstmt.setString(5,player.getCurrentteam());
	    pstmt.setDouble(6,player.getPrice());
	    pstmt.executeUpdate();
	    System.out.println("Successfully added player details from XML file");
//		Player player=new Player();
//		player.setName("Brijesh");
//		player.setAge(28);
//		player.setPlayedmatch(29);
//		player.setPreviousteam(null);
//		player.setCurrentteam(null);
//		player.setPrice(255263.255);
//		JAXBContext jaxbContext=JAXBContext.newInstance(Player.class);
//		Marshaller marshaller=jaxbContext.createMarshaller();
//		File file=new File("src\\players.xml");
//		marshaller.marshal(player,file);
	}catch(Exception e) {
		e.printStackTrace();
	}
}

}
