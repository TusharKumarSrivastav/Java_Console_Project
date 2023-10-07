package com.fossil.footballteamapp.serviceimp;
/**
 * This is singleton class 
 * player property and its getter and setter
 * @author Tushar
 *
 */
public class AddPlayer {
	private String name;
	private int age;
	private int matchplayed;
	private String priviousteam;
	private String currentteam;
	private double price;
	private static  AddPlayer addplayerobj=null;
	/**
	 * Private Constructor of AddPlayer
	 */
	private AddPlayer() {
		
	}
	/**
	 * 
	 * @return AddPlayer class Object 
	 */
	public  static  AddPlayer getInstance() {
		if(addplayerobj==null)
			addplayerobj=new AddPlayer();
		return addplayerobj;
	}
	/**
	 * getter of the name property of AddPlayer
	 * @return name of the Player
	 */
	public String getName() {
		return name;
	}
	/**
	 * This setter of name
	 * @param name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter of age
	 * @return age of Player
	 */
	public int getAge() {
		return age;
	}
	/**
	 * setter of age
	 * @param age of the player
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 *getter of matchplayed 
	 * @return matchplayed by player
	 */
	public int getMatchplayed() {
		return matchplayed;
	}
	/**
	 * setter of matchplayed
	 * @param matchplayed of player
	 */
	public void setMatchplayed(int matchplayed) {
		this.matchplayed = matchplayed;
	}
	/**
	 * getter of previousteam
	 * @return previousteam of player
	 */
	public String getPriviousteam() {
		return priviousteam;
	}
	/**
	 * setter of priviousteam
	 * @param priviousteam of player
	 */
	public void setPriviousteam(String priviousteam) {
		this.priviousteam = priviousteam;
	}
	/**
	 * getter of currentteam
	 * @return currentteam of player
	 */
	public String getCurrentteam() {
		return currentteam;
	}
	/**
	 * setter of currentteam
	 * @param currentteam of player
	 */
	public void setCurrentteam(String currentteam) {
		this.currentteam = currentteam;
	}
	/**
	 * getter of price
	 * @return price of player
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * setter of price
	 * @param price of player
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
