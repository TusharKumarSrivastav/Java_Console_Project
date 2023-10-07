package com.fossil.footballteamaapp.util;
import java.sql.*;
/**
 * This class is used to close the costly resources
 * @author Tushar
 *
 */
public class CloseDataBaseCon {
	/**
	 * This is static method 
	 * This method is used to close all the connection
	 * @param con
	 * @param pstmt
	 * @param rs
	 * @throws SQLException
	 */
	public static void closeConnection(Connection con,PreparedStatement pstmt,ResultSet rs) throws SQLException {
		while(rs!=null)
			rs.close();
		while(pstmt!=null)
			pstmt.close();
		while(con!=null)
			con.close();
	}

}
