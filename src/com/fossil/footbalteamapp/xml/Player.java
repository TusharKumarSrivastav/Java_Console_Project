package com.fossil.footbalteamapp.xml;
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement; 
/**
 * This is POJO class 
 * This class is responsible to convert XML to Java Object
 * @author Tushar
 *
 */
@XmlRootElement
public class Player {
   private String name;
   private int age;
   private int playedmatch;
   private String previousteam;
   private String currentteam;
   private double price;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getPlayedmatch() {
	return playedmatch;
}
public void setPlayedmatch(int playedmatch) {
	this.playedmatch = playedmatch;
}
public String getPreviousteam() {
	return previousteam;
}
public void setPreviousteam(String previousteam) {
	this.previousteam = previousteam;
}
public String getCurrentteam() {
	return currentteam;
}
public void setCurrentteam(String currentteam) {
	this.currentteam = currentteam;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
}
