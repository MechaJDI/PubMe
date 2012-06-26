package com.PubMe;

/**
 * Class containing a user's information
 * @author JDI
 *
 */
public class User 
{
	/**
	 * @uml.property  name="id"
	 */
	int id;
	/**
	 * @uml.property  name="name"
	 */
	String name;
	/**
	 * @uml.property  name="password"
	 */
	String password;
	/**
	 * @uml.property  name="email"
	 */
	String email;
	/**
	 * @uml.property  name="address"
	 */
	String address;
	/**
	 * @uml.property  name="city"
	 */
	String city;
	/**
	 * @uml.property  name="state"
	 */
	String state;
	/**
	 * @uml.property  name="zipcode"
	 */
	int zipcode;
	//Creditcard creditcard;
	/**
	 * @uml.property  name="twitterInfo"
	 * @uml.associationEnd  
	 */
	TwitterFunctions twitterInfo;
	
	/**
	 * Constructor
	 */
	public User(String email, String password)
	{
		this.email = email;
		this.password = password;
	}
	
	/**
	 * Returns the id number of the user
	 * @return  id
	 * @uml.property  name="id"
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Returns the name of the user
	 * @return  name
	 * @uml.property  name="name"
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Returns the email of the user
	 * @return  email
	 * @uml.property  name="email"
	 */
	public String getEmail()
	{
		return this.email;
	}
	
	/**
	 * Returns the password of the user
	 * @return  password
	 * @uml.property  name="password"
	 */
	public String getPassword()
	{
		return this.password;
	}
	
	/**
	 * Returns the address of the user
	 * @return  address
	 * @uml.property  name="address"
	 */
	public String getAddress()
	{
		return this.address;
	}

	/**
	 * Returns the city of the user
	 * @return  city
	 * @uml.property  name="city"
	 */
	public String getCity()
	{
		return this.city;
	}
	
	/**
	 * Returns the state of the user
	 * @return  state
	 * @uml.property  name="state"
	 */
	public String getState()
	{
		return this.state;
	}
	
	/**
	 * Returns the zipcode of the user
	 * @return  zipcode
	 * @uml.property  name="zipcode"
	 */
	public int getZipcode()
	{
		return this.zipcode;
	}
	
	/**
	 * Returns the full address of the user
	 * @return address city, state zipcode
	 */
	public String getFullAddress()
	{
		return this.address + " " + this.city + ", " + this.state + " " + this.zipcode;
	}
	
	/**
	 * Returns the twitterInfo of the user
	 * @return  twitterInfo
	 * @uml.property  name="twitterInfo"
	 */
	public TwitterFunctions getTwitterInfo()
	{
		return this.twitterInfo;
	}
	
	/**
	 * Returns true if user id set
	 * @return success
	 */
	public boolean setId(int id)
	{
		boolean success = false;
		if(id >= 1)
		{
			this.id = id;
			success = true;
		}
		return success;
	}
	
	/**
	 * Returns true if user name set
	 * @return success
	 */
	public boolean setName(String name)
	{
		boolean success = false;
		if(name.length() >= 1)
		{
			this.name = name;
			success = true;
		}
		return success;
	}
	
	/**
	 * Returns true if user email set
	 * @return success
	 */
	public boolean setEmail(String email)
	{
		boolean success = false;
		if(email.length() >= 1)
		{
			this.email = email;
			success = true;
		}
		return success;
	}
	
	/**
	 * Returns true if user password set
	 * @return success
	 */
	public boolean setPassword(String password)
	{
		boolean success = false;
		if(password.length() >= 1)
		{
			this.password = password;
			success = true;
		}
		return success;
	}
	
	/**
	 * Returns true if user address set
	 * @return success
	 */
	public boolean setAddress(String address)
	{
		boolean success = false;
		if(address.length() >= 1)
		{
			this.address = address;
			success = true;
		}
		return success;
	}

	/**
	 * Returns true if user city set
	 * @return success
	 */
	public boolean setCity(String city)
	{
		boolean success = false;
		if(city.length() >= 1)
		{
			this.city = city;
			success = true;
		}
		return success;
	}
	
	/**
	 * Returns true if user state set
	 * @return success
	 */
	public boolean setState(String state)
	{
		boolean success = false;
		if(state.length() == 2)
		{
			this.state = state;
			success = true;
		}
		return success;
	}
	
	/**
	 * Returns true if user zipcode set
	 * @return success
	 */
	public boolean setZipcode(int zipcode)
	{
		boolean success = false;
		if(zipcode != 0)
		{
			this.zipcode = zipcode;
			success = true;
		}
		return success;
	}

	/**
	 * Returns true if user twitterInfo set
	 * @return success
	 */
	public boolean setTwitterInfo(TwitterFunctions twitterInfo)
	{
		boolean success = false;
		if(twitterInfo != null)
		{
			this.twitterInfo = twitterInfo;
			success = true;
		}
		return success;
	}

	/**
	 * @uml.property  name="pubMeActivity"
	 * @uml.associationEnd  aggregation="shared" inverse="user:com.PubMe.PubMeActivity"
	 */
	private PubMeActivity pubMeActivity;

	/**
	 * Getter of the property <tt>pubMeActivity</tt>
	 * @return  Returns the pubMeActivity.
	 * @uml.property  name="pubMeActivity"
	 */
	public PubMeActivity getPubMeActivity() {
		return pubMeActivity;
	}

	/**
	 * Setter of the property <tt>pubMeActivity</tt>
	 * @param pubMeActivity  The pubMeActivity to set.
	 * @uml.property  name="pubMeActivity"
	 */
	public void setPubMeActivity(PubMeActivity pubMeActivity) {
		this.pubMeActivity = pubMeActivity;
	}	
	
}