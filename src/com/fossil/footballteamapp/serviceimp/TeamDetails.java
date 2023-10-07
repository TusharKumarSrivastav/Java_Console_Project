package com.fossil.footballteamapp.serviceimp;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import com.fossil.footballteamapp.daoimp.DataBaseConnectionImp;
/**
 * This class is responsible all operation about team.
 * Deatils about team .
 * add member in team 
 * delete member from team
 * @author Tushar
 *
 */
public class TeamDetails {
	/**
	 * This method is doing all the operation like details about team .add member in team and reove member in team according to userselected team.
	 * @param teamname
	 * @throws SQLException
	 */
  static void details(String teamname) throws SQLException {
     Scanner sc=new Scanner(System.in);
     while(true) {
    	 System.out.println("***********************************************************************");
    	 System.out.println("1.You want to see details of  team "+teamname+"\n2.You want to add member in team"+teamname+"\n3.You want to remove member from team"+teamname);
    	 System.out.println("*********************PLZ CHOOSE ABOVE OPTION***************************");
    	 String userresponse=sc.next();
    	 int userresponse1=0;
    	 try 
    	 {
    		 userresponse1=Integer.parseInt(userresponse);
    	 }
    	 catch(Exception e)
    	 {
    		 System.err.println("Invalid Input");
    	 }
    	 if(userresponse1==1)
    	 {
    		  DataBaseConnectionImp databaseconnectionimpobj=DataBaseConnectionImp.getInstance();
    		  String qry="select t1.playerID,t1.name from football.playerdetails t1 inner join  football.teamdetails t2 on t1.playerID=t2.playerID where t2.teamname=?  ";
    		  PreparedStatement pstmt=databaseconnectionimpobj.getConnection(qry);
    		  LinkedHashMap<String,Integer> map1=new LinkedHashMap<String,Integer>();
    		  LinkedHashMap<String,Integer> map2=new LinkedHashMap<String,Integer>();
    		  pstmt.setString(1,teamname);
    		  ResultSet rs=pstmt.executeQuery();
    		  System.out.println("*********"+teamname +" FootBall Team List"+"************");
    		  System.out.println("************************Player's List********************");
    		  while(rs.next()) {
    			  map1.put(rs.getString(2),rs.getInt(1));
    		  }
    		  System.out.printf("%-6s%16s\n","Player Name","Player ID");
    		  System.out.println("************************************************************************************");
    		  for (String i : map1.keySet()) {
    		      System.out.printf("%-6s%16d\n",i,map1.get(i));
    		    }
    		  System.out.println();
    		  System.out.println("*****************************************************************************************");
    		  System.out.println("*************************Coach's List********************");
    		  String qry1="select t1.coachID,t1.name from football.coachdetails t1 inner join  football.teamdetails t2 on t1.coachID=t2.coachID where t2.teamname=?  ";
    		  PreparedStatement pstmt1=databaseconnectionimpobj.getConnection(qry1);
    		  pstmt1.setString(1,teamname);
    		  rs=pstmt1.executeQuery();
    		  while(rs.next())
    			 map2.put(rs.getString(2),rs.getInt(1));
    		  System.out.printf("%-6s%16s\n","Coach Name","Coach ID");
    		  System.out.println("****************************************************************************************************");
    		  for (String i : map2.keySet()) {
    		      System.out.printf("%-6s%16d\n",i,map2.get(i));
    		    }
    		  System.out.println();
    		  System.out.println("********************************************************************************************************");
    		  String qry2="select count(*),sum(t2.price) from football.teamdetails t1  inner join football.playerdetails t2 on t1.playerID=t2.playerID where t1.teamname=?  ";
    		  PreparedStatement pstmt2=databaseconnectionimpobj.getConnection(qry2);
    		  pstmt2.setString(1,teamname);
    		  double totalplayerbudget=0;
    		  double totalcoachbudget=0;
    		  rs=pstmt2.executeQuery();
    		  if(rs.next()) {
    			  totalplayerbudget=rs.getDouble(2);
    		  System.out.println();
    		  System.out.println("************************************************************");
    		  System.out.println("Total Team player:"+rs.getInt(1)+"   Total player Budget of Team : "+ totalplayerbudget);
    		  }
    		  String qry3="select count(*), sum(t2.price)from football.teamdetails t1  inner join football.coachdetails t2 on t1.coachID=t2.coachID where t1.teamname=?  ";
    		  PreparedStatement pstmt3=databaseconnectionimpobj.getConnection(qry3);
    		  pstmt3.setString(1,teamname);
    		  rs=pstmt3.executeQuery();
    		  if(rs.next()) {
    		  totalcoachbudget=rs.getDouble(2);
    		  System.out.println();
    		  System.out.println("*************************************************************");
    		  System.out.println("Total Team coche:"+rs.getInt(1)+"    Total coche Budget of Team : "+ rs.getDouble(2));
    		  }
    		  System.out.println("**************************************************************");
    		  System.out.println("Total Team budget :  "+(totalcoachbudget+totalplayerbudget));
    		  break;
    	 }
    	 else if(userresponse1==2)
    	 {
    		while(true) {
    			 System.out.println("************************************************************");
    			 System.out.println("1.You want to add player\n2.You want to enter coche");
    			 System.out.println("************************************************************");
    			 System.out.println("************PLEASE CHOOSE THE ABOVE OPTION*******************");
        		 String input=sc.next();
        		 int input1=0;
        		 try 
        		 {
        			input1=Integer.parseInt(input);
        		 }
        		 catch(Exception e) 
        		 {
        			System.err.println("invaild input\nplz input again"); 
        		 }
        		 if(input1==1) {
        			 String qry="select t1.playerID,t1.name,t1.age,t1.playedmatch,t1.priviousteam,t1.currentteam,t1.price from football.playerdetails t1 left join football.teamdetails t2 on t1.playerID=t2.playerID where t2.playerID is null; ";
        			  DataBaseConnectionImp databaseconnectionimpobj=DataBaseConnectionImp.getInstance();
            		  PreparedStatement pstmt=databaseconnectionimpobj.getConnection(qry);
            		  ResultSet rs=pstmt.executeQuery();
            		  System.out.println("********************************************************************");
            		  System.out.println("You can add following player");
            		  System.out.println("********************************************************************");
            		  System.out.println("************************NON-PURCHASED PLAYER'S LIST*****************");
            		 if(rs.next()) {
            		  do {
            			  System.out.println("PlayerId:"+rs.getInt(1)+"  Name:"+rs.getString(2)+" Age:"+rs.getInt(3)+" PlayedMatches:"+rs.getInt(4)+" PreviousTeam:"+rs.getString(5)+" CurrentTeam:"+rs.getString(6)+" Price:"+rs.getFloat(7));
            			  System.out.println("************************************************************************");
            		  }while(rs.next());
            		  
            		 while(true) {
            			 System.out.println("Enter the PlayerId for adding in team ");
            			 String playerid=sc.next();
            			 int playerid1=0;
               		  try {
               			playerid1=Integer.parseInt(playerid);
               			String qry1="insert into football.teamdetails(teamname,playerID) values(?,?)";
               			PreparedStatement pstmt1=databaseconnectionimpobj.getConnection(qry1);
               			pstmt1.setString(1,teamname);
               			pstmt1.setInt(2,playerid1);
               			pstmt1.executeUpdate();
               			System.out.println("Player added in team successfully");
               			System.out.println("You want to add more player(Y)");
               			char ch=sc.next().charAt(0);
               			if(ch=='Y'||ch=='y')
               				continue;
               			else
               				break;
               		  }
               		  catch(Exception e) {
               			  System.err.println("Invalid playerID plz enter again!!!");
               		  }
            		 }
            		 }
            		 else
            			 System.err.println("Player is not avaliable for adding to team");
            		 break;
        		 }
        		 else if(input1==2) {
        			 String qry="select t1.coachID,t1.name,t1.age,t1.experince,t1.priviousteam,t1.currentteam,t1.price from football.coachdetails t1 left join football.teamdetails t2 on t1.coachID=t2.coachID where t2.coachID is null; ";
       			  DataBaseConnectionImp databaseconnectionimpobj=DataBaseConnectionImp.getInstance();
           		  PreparedStatement pstmt=databaseconnectionimpobj.getConnection(qry);
           		  ResultSet rs=pstmt.executeQuery();
           		  System.out.println("You can add following coach");
           		  System.out.println("coach List");
           		  while(rs.next()) {
             			System.out.println("PlayerId:"+rs.getInt(1)+"  Name:"+rs.getString(2)+" Age:"+rs.getInt(3)+" PlayedMatches:"+rs.getInt(4)+" PreviousTeam:"+rs.getString(5)+" CurrentTeam:"+rs.getString(6)+" Price:"+rs.getFloat(7));
             		}
           		 while(true) {
           			 System.out.println("Enter the coachID for adding in team ");
           			 String coachid=sc.next();
           			 int coachid1=0;
              		  try {
              			coachid1=Integer.parseInt(coachid);
              			String qry1="insert into football.teamdetails(teamname,coachID) values(?,?)";
              			PreparedStatement pstmt1=databaseconnectionimpobj.getConnection(qry1);
              			pstmt1.setString(1,teamname);
              			pstmt1.setInt(2,coachid1);
              			pstmt1.executeUpdate();
              			System.out.println("coach added in team successfully");
              			System.out.println("You want to add more coach(Y)");
              			char ch=sc.next().charAt(0);
              			if(ch=='Y'||ch=='y')
              				continue;
              			else
              				break;
              		  }
              		  catch(Exception e) {
              			  System.err.println("Invalid coachID plz enter again!!!");
              		  }
           		 }
        	
           		break; 
        		 }
        	
    		}
    		
    	 }
    	
    	
    	
     }
  }
}
