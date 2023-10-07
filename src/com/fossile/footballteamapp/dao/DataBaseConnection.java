package com.fossile.footballteamapp.dao;
import java.sql.PreparedStatement;
/**
 * This is interface 
 * This interface is implemented by DataBaseConnectionImp class
 * @author tushar
 *
 */
public interface DataBaseConnection {
	/**
	 * This is Abstract Method 
	 * This method overridden in DataBaseConnectionImp class
	 * @param sql  quary 
	 * @return PreparedStatement Interface
	 */
    PreparedStatement getConnection(String qry);
}
