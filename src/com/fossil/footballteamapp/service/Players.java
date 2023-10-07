package com.fossil.footballteamapp.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * This is interface 
 * This interface is implemented by PlayerImp class
 * @author tushar
 *
 */
public interface Players {
	/**
	 * This is abstract Method 
	 * it is overridden in PlayerImp class
	 * @throws SQLException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	void playersDetails() throws SQLException, ParserConfigurationException, SAXException, IOException;
}
