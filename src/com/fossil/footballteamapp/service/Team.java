package com.fossil.footballteamapp.service;
import java.sql.SQLException;
/**
 * This is interface 
 * this interface is implemented by TeamImp class
 * @author Tushar
 *
 */
public interface Team {
	/**
	 * This is abstract Method 
	 * it is overridden in TeamImp class
	 * @throws SQLException
	 */
    void teamdetails() throws SQLException;
   
}
