package com.fossil.footballteamapp.run;
import java.sql.SQLException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.fossil.footballteamaapp.util.CloseDataBaseCon;
import com.fossil.footballteamapp.serviceimp.CoachImp;
import com.fossil.footballteamapp.serviceimp.PlayersImp;
import com.fossil.footballteamapp.serviceimp.TeamImp;

import java.io.IOException;
import java.sql.*;
/**
 * This is main class .In this class All main function.
 * This class is responsible all the functionality.
 * @author Tushar
 *
 */
public class RunClass {
   public static void main(String[] args) throws SQLException, ParserConfigurationException, SAXException, IOException {
	   Scanner sc=new Scanner(System.in);
	   Connection con=null;
	   PreparedStatement pstmt=null;
			   ResultSet rs=null;
		int userresponse1=0;
		System.out.println("*******************WELCOME TO FOOTBAL LEAGUE*************************");
	while(true) {
		System.out.println("*********************************************************************");
		System.out.println("1.TEAM'S PAGE\n2.PLAYER'S PAGE\n3.COACH'S PAGE\n4.EXIT");
		System.out.println("*********************************************************************");
        System.out.println("*****************PLEASE CHOOSE THE ABOVE PAGE**********************"); 
		String userresponse=sc.next();
		try {
			 userresponse1=Integer.parseInt(userresponse);
		}
		catch(Exception e) {
			System.err.println("Enter valid Response");
		}
		switch(userresponse1) {
		case 1:TeamImp.getInstance().teamdetails();
		break;
		case 2:PlayersImp.getInstance().playersDetails();
		break;
		case 3:CoachImp.getInstance().cochesDetails();
		break;
		case 4:
			break;
		default:System.err.println("Not Valid Input\nplz input again\n");
		  
		}
	  if(userresponse1==4) {
		  System.err.println("sccessfully Exit!!");
		  CloseDataBaseCon.closeConnection(con,pstmt,rs);
		  break;
	  }
	}
	
}
}
