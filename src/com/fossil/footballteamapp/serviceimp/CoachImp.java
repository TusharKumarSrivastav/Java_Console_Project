package com.fossil.footballteamapp.serviceimp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.fossil.footballteamapp.daoimp.DataBaseConnectionImp;
import com.fossil.footballteamapp.service.Coches;
/**
 * This class is responsible all the operation related to coaches.
 * @author Tushar
 *
 */
public class CoachImp implements Coches {
	private static CoachImp cochesimpobj=null;
	/**
	 * This is Constructor of CoachImp
	 */
	private CoachImp() {
		
	}
	/**
	 * This method  is creating object of CoachImp object
	 * @return CoachImp Object
	 */
   public static CoachImp getInstance() {
	   if(cochesimpobj==null)
		   cochesimpobj=new CoachImp();
	   return cochesimpobj;
   }
   /**
    * This method is responsible to give information all the coaches and add the coach in the list and remove the coaches from the list
    * @throws SQLException this is showing sql error
    */
   public void cochesDetails() throws SQLException {
	   Scanner sc=new Scanner(System.in);
   	while(true) {
   		System.out.println("******************************************************************");
   		System.out.println("1.You want to see List of coaches\n2.You want to add coach in list\n3.You want to delete coach from list");
   		System.out.println("***************PLZ CHOOSE ABOVE OPTION****************************");
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
       		String qry="select* from football.coachdetails";
       		PreparedStatement pstmt=databaseconnectionimpobj.getConnection(qry);
       		ResultSet rs=pstmt.executeQuery();
       		
       		System.out.printf("%-10s%-16s%-18s%-28s%-34s%-40s%-46s\n","CoachIDId","Name","Age","Experience(In Year)","PreviousTeam","Current Team","Price(In Rupees)");
    		System.out.println("***********************************************************************************************************************************************************************");
    		while(rs.next()) {
    			System.out.printf("%-10d%-16s%-18d%-28d%-34s%-40s%-46f\n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getFloat(7));
    		}
    		System.out.println();
    		 System.out.println("************************************************************************************************************************************************************************");
    		break;
       	}
	else if(userresponse1==2) {
        	
        	while(true) {
        		try {
        			System.out.println("Enter the Coach Name");
        			AddCoach.getInstance().setName(sc.next());
        		   int age1=0;
        			while(true) {
        			  System.out.println("Enter the age of Coach");
           		   String age=sc.next();
           		   age1=Integer.parseInt(age);
           		   if(age1>10&&age1<80) {
                		AddCoach.getInstance().setAge(Integer.parseInt(age));
                		break;
           		   }
           		   else
           			   System.err.println("Please Enter age of coach more 10 year and less than 70 year!!!! ");
  
        		  }
        		System.out.println("Enter the past Experince of the coach in year ");
        		String experince=sc.next();
        		AddCoach.getInstance().setExperience(Integer.parseInt(experince));
        		System.out.println("Do You want to enter privious Team (Y)");
        		char ch=sc.next().charAt(0);
        		if(ch=='Y'||ch=='y') {
        			System.out.println("Enter the previous Team Name");
        			AddCoach.getInstance().setPreviousteam(sc.next());
        		}
        		else 
        			AddCoach.getInstance().setPreviousteam(null);
        		
        		System.out.println("Do You want to enter Current Team (Y/N)");
        		char ch1=sc.next().charAt(0);
        		if(ch1=='Y'||ch1=='y') {
        			System.out.println("Enter the current Team Name");
        			AddCoach.getInstance().setCurrentteam(sc.next());
        		}
        		else 
        			AddCoach.getInstance().setCurrentteam(null);
        		
        		while(true) {
        			System.out.println("Enter the price of Coach");
            		String price=sc.next();
            		double price1=Double.parseDouble(price);
            		if(price1>=100000&&price1<=1000000) {
            		AddCoach.getInstance().setPrice(price1);
            		break;
            		}
            		else
            			System.err.println("Please enter price between 1 lakhs to 10 lakhs");
        		}
        		String qry="insert into football.coachdetails(name,age,experince,priviousteam,currentteam,price) values(?,?,?,?,?,?)";
        		DataBaseConnectionImp databaseconnectionimpobj=DataBaseConnectionImp.getInstance();
        		PreparedStatement pstmt=databaseconnectionimpobj.getConnection(qry);
        		pstmt.setString(1,AddCoach.getInstance().getName());
        		pstmt.setInt(2,AddCoach.getInstance().getAge());
        		pstmt.setInt(3,AddCoach.getInstance().getExpereince());
        		pstmt.setString(4,AddCoach.getInstance().getPreviousteam());
        		pstmt.setString(5,AddCoach.getInstance().getCurrentteam());
        		pstmt.setDouble(6,AddCoach.getInstance().getPrice());
        		pstmt.executeUpdate();
        		System.out.println("Coche successfully Added!!!");
        		System.out.println("You want to enter more coach Plz enter the Y or y ");
        		char ch2=sc.next().charAt(0);
        		if(ch2=='y'||ch2=='Y')
        			continue;
        		else
        			break;
        	}
        	catch(Exception e) {
        		e.getStackTrace();
        	}
        		
        	}
        	break;	
        	  
        	}
	else if(userresponse1==3) {
		System.out.println("Do you Know CoachId(Y/N)");
		char ch=sc.next().charAt(0);
		int cocheId=0;
		String cochename=null;
		if(ch=='y'||ch=='Y') {
			System.out.println("Plz Enter the cocheId");
			cocheId=sc.nextInt();
		}
		else {
			System.out.println("Enter the coche name");
			cochename=sc.next();
		}
		String qry="delete from football.coachdetails where coachID=? or name=?";
		DataBaseConnectionImp databaseconnectionimpobj=DataBaseConnectionImp.getInstance();
		PreparedStatement pstmt=databaseconnectionimpobj.getConnection(qry);
		pstmt.setInt(1,cocheId);
		pstmt.setString(2,cochename);
		pstmt.executeUpdate();
		System.out.println("Successfully deleted!!");
		break;  
	}
       	
      
    	
   	}
	
   }
}
