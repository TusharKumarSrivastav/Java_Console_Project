package com.fossil.footballteamapp.serviceimp;
import java.sql.SQLException;
import java.util.Scanner;
import com.fossil.footballteamapp.service.Team;
/**
 * This class is giving  all the team name.
 * this class is responsible to call respect team class.
 * @author Tushar
 *
 */
public class TeamImp implements Team {
   private static TeamImp teamimpobj=null;
   Scanner sc=new Scanner(System.in);
   private TeamImp() {
	   
   }
   /**
    * This method is used to create object of this class
    * @return TeamImp object
    */
   public static TeamImp getInstance() {
	   if(teamimpobj==null)
		   teamimpobj=new TeamImp();
	   return teamimpobj;
   }
   /**
    * This method is giving list of team and calling respected team details according to user input
    * throws SQLException
    */
	@Override
	public void teamdetails() throws SQLException {
		while(true) {
			System.out.println("****************************************************************************");
			System.out.println("There are three team\n1.Bengaluru Team\n2.Hydrabad team\n3.Chennai Team");
			System.out.println("****************************************************************************");
			int userresponse=0;
			System.out.println("**********************PLEASE CHOOSE THE ABOVE TREAM OPTION***********************");
			String userresponse2=sc.next();
			int userresponse1=0;
			try {
				userresponse1=Integer.parseInt(userresponse2);
			}
			catch(Exception e) {
			System.err.println("Enter the valid Number");
			}
			switch(userresponse1) {
			case 1:TeamDetails.details( "Bengaluru");
			break;
			case 2:TeamDetails.details( "Hydrabad");
			break;
			case 3:TeamDetails.details( "Chennai");
			break;
			default:System.err.println("Not Valid Input Input Again!!");
			continue;
			}
			break;
		}
	}



}
