package com.fossil.footballteamapp.serviceimp;
/**
 * This is singleton class 
 * This class hold properties of coaches
 * @author Tushar
 */
public class AddCoach {
	private String name;
	private int age;
	private int experience;
	private String previousteam;
	private String currentteam;
	private double price;
	private static  AddCoach addcocheobj=null;
	/**
	 * This is private constructor off AddCoach class
	 */
	private AddCoach() {
		
	}
	/**
	 * This method is creating object of AddCoach class
	 * @return AddCoach class Object 
	 */
	public  static  AddCoach getInstance() {
		if(addcocheobj==null)
			addcocheobj=new AddCoach();
		return addcocheobj;
	}
	/**
	 * getter  name of coach
	 * @return name of coach
	 */
	public String getName() {
		return name;
	}
	/**
	 * setter name  of coach
	 * @param name of coach
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter  age of coach
	 * @return age of coach
	 */
	public int getAge() {
		return age;
	}
	/**
	 * setter age  of coach
	 * @param age of coach
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * getter  experience of coach
	 * @return experience of coach
	 */
	public int getExpereince() {
		return experience;
	}
	/**
	 * setter experience  of coach
	 * @param experience of coach
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}
	/**
	 * getter previousteam of coach
	 * @return previousteam of coach
	 */
	public String getPreviousteam() {
		return previousteam;
	}
	/**
	 * setter previoustteam  of coach
	 * @param previousteam of coach
	 */
	public void setPreviousteam(String previousteam) {
		this.previousteam = previousteam;
	}
	/**
	 * getter  currentteam of coach
	 * @return currentteam of coach
	 */
	public String getCurrentteam() {
		return currentteam;
	}
	/**
	 * setter currentteam  of coach
	 * @param currentteam of coach
	 */
	public void setCurrentteam(String currentteam) {
		this.currentteam = currentteam;
	}
	/**
	 * getter  price of coach
	 * @return price of coach
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * setter price  of coach
	 * @param price  of coach
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
