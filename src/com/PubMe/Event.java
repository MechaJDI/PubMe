package com.PubMe;

import com.google.android.maps.GeoPoint;

/**
 * Class containing event information
 * @author JDI
 *
 */
public class Event 
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
	 * @uml.property  name="description"
	 */
	String description;
	/**
	 * @uml.property  name="address"
	 */
	String address;
	/**
	 * @uml.property  name="location"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	GeoPoint location;
	//Ticket ticket
	/**
	 * @uml.property  name="host"
	 */
	String host;
	
	/**
	 * Constructor
	 */
	public Event(String name, String description, String address, GeoPoint location, String host)
	{
		this.name = name;
		this.description = description;
		this.address = address;
		this.location = location;
		this.host = host;
	}
	
	/**
	 * Returns the id number of the event
	 * @return  id
	 * @uml.property  name="id"
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Return the name of the event
	 * @return  name
	 * @uml.property  name="name"
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Return the description of the event
	 * @return  description
	 * @uml.property  name="description"
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	/**
	 * Return the address of the event
	 * @return  address
	 * @uml.property  name="address"
	 */
	public String getAddress()
	{
		return this.address;
	}
	
	/**
	 * Return the location of the event
	 * @return  location
	 * @uml.property  name="location"
	 */
	public GeoPoint getLocation()
	{
		return this.location;
	}
	
	/**
	 * Return the host of the event
	 * @return  host
	 * @uml.property  name="host"
	 */
	public String getHost()
	{
		return this.host;
	}
	
	/**
	 * Returns true if event id set
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
	 * Return true if name of event set
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
	 * Return true if description of event set
	 * @return success
	 */
	public boolean setDescription(String description)
	{
		boolean success = false;
		if(description.length() >= 1)
		{
			this.description = description;
			success = true;
		}
		return success;
	}

	/**
	 * Return true if address of event set
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
	 * Return true if location of event set
	 * @return success
	 */
	public boolean setLocation(GeoPoint location)
	{
		boolean success = false;
		if(location != null)
		{
			this.location = location;
			success = true;
		}
		return success;
	}
	
	/**
	 * Return true if host of event set
	 * @return success
	 */
	public boolean setHost(String host)
	{
		boolean success = false;
		if(host.length() >= 1)
		{
			this.host = host;
			success = true;
		}
		return success;
	}

	/**
	 * @uml.property  name="mappingActivity"
	 * @uml.associationEnd  aggregation="shared" inverse="event:com.PubMe.MappingActivity"
	 */
	private MappingActivity mappingActivity;

	/**
	 * Getter of the property <tt>mappingActivity</tt>
	 * @return  Returns the mappingActivity.
	 * @uml.property  name="mappingActivity"
	 */
	public MappingActivity getMappingActivity() {
		return mappingActivity;
	}

	/**
	 * Setter of the property <tt>mappingActivity</tt>
	 * @param mappingActivity  The mappingActivity to set.
	 * @uml.property  name="mappingActivity"
	 */
	public void setMappingActivity(MappingActivity mappingActivity) {
		this.mappingActivity = mappingActivity;
	}

	/**
	 * @uml.property  name="mappingActivity1"
	 * @uml.associationEnd  inverse="event1:com.PubMe.MappingActivity"
	 */
	private MappingActivity mappingActivity1;

	/**
	 * Getter of the property <tt>mappingActivity1</tt>
	 * @return  Returns the mappingActivity1.
	 * @uml.property  name="mappingActivity1"
	 */
	public MappingActivity getMappingActivity1() {
		return mappingActivity1;
	}

	/**
	 * Setter of the property <tt>mappingActivity1</tt>
	 * @param mappingActivity1  The mappingActivity1 to set.
	 * @uml.property  name="mappingActivity1"
	 */
	public void setMappingActivity1(MappingActivity mappingActivity1) {
		this.mappingActivity1 = mappingActivity1;
	}

	/**
	 * @uml.property  name="databaseFunctions"
	 * @uml.associationEnd  inverse="event:com.PubMe.DatabaseFunctions"
	 */
	private DatabaseFunctions databaseFunctions;

	/**
	 * Getter of the property <tt>databaseFunctions</tt>
	 * @return  Returns the databaseFunctions.
	 * @uml.property  name="databaseFunctions"
	 */
	public DatabaseFunctions getDatabaseFunctions() {
		return databaseFunctions;
	}

	/**
	 * Setter of the property <tt>databaseFunctions</tt>
	 * @param databaseFunctions  The databaseFunctions to set.
	 * @uml.property  name="databaseFunctions"
	 */
	public void setDatabaseFunctions(DatabaseFunctions databaseFunctions) {
		this.databaseFunctions = databaseFunctions;
	}
}
