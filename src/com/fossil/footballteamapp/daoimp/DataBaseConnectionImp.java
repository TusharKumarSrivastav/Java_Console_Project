package com.fossil.footballteamapp.daoimp;
import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import com.fossile.footballteamapp.dao.DataBaseConnection;
/**
 * This  class is responsible to stabilize connection with DataBase
 * This class implement DataBaseConnection interface
 * @author Tushar
 *
 */
public class DataBaseConnectionImp implements DataBaseConnection {
	/**
	 * This method is stabilizing connection with database server
	 * @param sql query
	 * @return PreparedStatement Interface
	 */
	@Override
	public PreparedStatement getConnection(String qry) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String filepath="./src/config.properties";
			Properties p=new Properties();
			FileInputStream fis=new FileInputStream(filepath);
			p.load(fis);
			
			Class.forName(p.getProperty("fqcn"));
			con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("passwoard"));
			pstmt=con.prepareStatement(qry);
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	private static DataBaseConnectionImp databaseconnectionimp=null;
	/**
	 * This is private constructor of DataBaseConnectionImp
	 */
	private DataBaseConnectionImp() {
		
	}
	/**
	 * This method is responsible for creating the object of DataBaseConnectionImp class
	 * @return DataBaseConnectionImp Class Object
	 */
	public static DataBaseConnectionImp getInstance() {
		if(databaseconnectionimp==null)
			databaseconnectionimp=new DataBaseConnectionImp();
		return databaseconnectionimp;
	}
	
    
}
