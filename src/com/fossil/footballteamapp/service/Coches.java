package com.fossil.footballteamapp.service;

import java.sql.SQLException;

/**
 * This is interface 
 * it interface implemented by CoachImp Class
 * @author Tushar
 *
 */
public interface Coches {
	/**
	 * This is abstract Method 
	 * it is overridden in CoachImp class
	 * @throws SQLException
	 */
	void cochesDetails() throws SQLException;
}
