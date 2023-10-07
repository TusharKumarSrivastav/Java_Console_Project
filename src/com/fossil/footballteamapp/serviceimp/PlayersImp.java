package com.fossil.footballteamapp.serviceimp;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.fossil.footballteamapp.daoimp.DataBaseConnectionImp;
import com.fossil.footballteamapp.service.Players;
import com.fossil.footbalteamapp.xml.XmlParser;
import com.fossil.footbalteamapp.xml.XmlToJavaObj;
/**
 * This class responsible all the operation related to player
 * Information about all listed player
 * add new player in the listed player
 * delete any player
 * @author Tushar
 *
 */
public class PlayersImp implements Players {
	private static PlayersImp playersimpobj;
	/**
	 * This is constructor of PlayerImp class
	 */
	private PlayersImp() {
	}
	/**
	 * This method is using to create this class object
	 * @return PlayerImp object
	 */
	public static PlayersImp getInstance() {
		if(playersimpobj==null) {
			playersimpobj=new PlayersImp();
		}
		return playersimpobj;
	}
	/**
	 *  This class responsible all the operation related to player
     * Information about all listed player
     * add new player in the listed player
     * delete any player
	 * @throws SQLException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
    public void playersDetails() throws SQLException, ParserConfigurationException, SAXException, IOException {
    	Scanner sc=new Scanner(System.in);
    	while(true) {
    		System.out.println("1.You want to see List of player\n2.You want to add player in list\n3.You want to delete player from list");
    		System.out.println("***********PLZ CHOOSE THE ABOVE OPITION************");
        	String userresponse=sc.next();
        	int userresponse1=0;
        	try {
        		userresponse1=Integer.parseInt(userresponse);
        	}
        	catch(Exception e) {
        		System.err.println("Input is invalid Plz input again");
        	}
        	if(userresponse1==1) {
        		DataBaseConnectionImp databaseconnectionimpobj=DataBaseConnectionImp.getInstance();
        		String qry="select* from football.playerdetails";
        		PreparedStatement pstmt=databaseconnectionimpobj.getConnection(qry);
        		ResultSet rs=pstmt.executeQuery();
        		System.out.printf("%-10s%-16s%-18s%-28s%-34s%-40s%-46s\n","PlayerId","Name","Age","PlayedMatch","PreviousTeam","Current Team","Price(In Rupees)");
        		System.out.println("***********************************************************************************************************************************************************************");
        		while(rs.next()) {
        			System.out.printf("%-10d%-16s%-18d%-28d%-34s%-40s%-46f\n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getFloat(7));
        		}
        		System.out.println();
        		 System.out.println("************************************************************************************************************************************************************************");
        		break;
        	}
        	else if(userresponse1==2) {
        		System.out.println("****************************************************************");
        		System.out.println("1.You want to add player from XML file\n2.You want to add player one by one");
        		System.out.println("*****************************************************************");
        		System.out.println("*************************Please choose above option*********************");
        		String useroption=sc.next();
        		int useroption1=0;
        		try {
        			useroption1=Integer.parseInt(useroption);
        		}
        		catch(Exception e) {
        			System.err.println("Enter valid Input!!!!!!");
        		}
        		if(useroption1==1) {
        			try {
        	     XmlParser.xml_Implementation();
        			}
        			catch(Exception e) {
        				System.err.println("Something Went wrong!!!!!!!!!!!!");
        			}
        		break;
        		}
        	     else if(useroption1==2) {
        	while(true) {
        		try {
        			System.out.println("Enter the Player Name");
        			AddPlayer.getInstance().setName(sc.next());
        			int age1=0;
        		  while(true) {
        			  System.out.println("Enter the age of Player");
           		      String age=sc.next();
           		      age1=Integer.parseInt(age);
           		      if(age1>=15&&age1<=50)
           		    	  break;
           		      else
           		      {
           		    	  System.err.println("plz enter age between 15 to 50 !!!");
           		      }
        		  }
        		AddPlayer.getInstance().setAge(age1);
        		System.out.println("Enter the played Matches ");
        		String playedmatch=sc.next();
        		AddPlayer.getInstance().setMatchplayed(Integer.parseInt(playedmatch));
        		System.out.println("Do You want to enter privious Team (Y/N)");
        		char ch=sc.next().charAt(0);
        		if(ch=='Y'||ch=='y') {
        			System.out.println("Enter the previous Team Name");
        			AddPlayer.getInstance().setPriviousteam(sc.next());
        		}
        		System.out.println("Do You want to enter Current Team (Y/N)");
        		char ch1=sc.next().charAt(0);
        		if(ch=='Y'||ch=='y') {
        			System.out.println("Enter the current Team Name");
        			AddPlayer.getInstance().setCurrentteam(sc.next());
        		}
        		
        		while(true) {
        			System.out.println("Enter the price of player");
            		String price=sc.next();
            		double price1=Double.parseDouble(price);
            		if(price1>=100000&&price1<=1000000) {
            		AddPlayer.getInstance().setPrice(price1);
            		break;
            		}
            		else
            			System.err.println("Please enter price between 1 lakhs to 10 lakhs");
        		}
        		String qry="insert into football.playerdetails(name,age,playedmatch,priviousteam,currentteam,price) values(?,?,?,?,?,?)";
        		DataBaseConnectionImp databaseconnectionimpobj=DataBaseConnectionImp.getInstance();
        		PreparedStatement pstmt=databaseconnectionimpobj.getConnection(qry);
        		pstmt.setString(1,AddPlayer.getInstance().getName());
        		pstmt.setInt(2,AddPlayer.getInstance().getAge());
        		pstmt.setInt(3,AddPlayer.getInstance().getMatchplayed());
        		pstmt.setString(4,AddPlayer.getInstance().getPriviousteam());
        		pstmt.setString(5,AddPlayer.getInstance().getCurrentteam());
        		pstmt.setDouble(6,AddPlayer.getInstance().getPrice());
        		pstmt.executeUpdate();
        		System.out.println("Player successfully Added!!!");
        		System.out.println("You want to enter more player plz enter Y or y");
        		char ch2=sc.next().charAt(0);
        		if(ch2=='Y'||ch2=='y')
        			continue;
        		else
        			break;
        	}
        	catch(Exception e) {
        		System.err.println("Plz enter valid input!!");
        	}
        		
        	}
        	     
        	     }
        	}
        	else if(userresponse1==3) {
        		System.out.println("Do you Know playerId(Y/N)");
        		char ch=sc.next().charAt(0);
        		int playerid=0;
        		String playername=null;
        		if(ch=='y'||ch=='Y') {
        			System.out.println("Plz Enter the playerId");
        			playerid=sc.nextInt();
        		}
        		else {
        			System.out.println("Enter the Player name");
        			playername=sc.next();
        		}
        		String qry="delete from football.playerdetails where playerId=? or name=?";
        		DataBaseConnectionImp databaseconnectionimpobj=DataBaseConnectionImp.getInstance();
        		PreparedStatement pstmt=databaseconnectionimpobj.getConnection(qry);
        		pstmt.setInt(1,playerid);
        		pstmt.setString(2,playername);
        		pstmt.execute();
        		System.out.println("Successfully deleted!!");
        		break;
        	}
        	
        	break;
    	}
    	
    }

}
