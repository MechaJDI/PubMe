package com.PubMe;

import com.google.android.maps.GeoPoint;

/**
 * Class containing ticket information
 * @author JDI
 *
 */
public class Ticket 
{
	/**
	 * @uml.property  name="id"
	 */
	int id;
	/**
	 * @uml.property  name="price"
	 */
	String price;
	/**
	 * @uml.property  name="vendor"
	 */
	String vendor;
	
	/**
	 * Constructor
	 */
	public Ticket(int id, String price, String vendor)
	{
		this.id = id;
		this.price = price;
		this.vendor = vendor;
	}
	
	/**
	 * Return the id of the ticket
	 * @return  name
	 * @uml.property  name="id"
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Return the price of the ticket
	 * @return  description
	 * @uml.property  name="price"
	 */
	public String getPrice()
	{
		return this.price;
	}

	/**
	 * Return the vendor of the ticket
	 * @return  description
	 * @uml.property  name="vendor"
	 */
	public String getVendor()
	{
		return this.vendor;
	}
	
	/**
	 * Returns true if ticket id set
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
	 * Return true if location of event set
	 * @return success
	 */
	public boolean setPrice(String price)
	{
		boolean success = false;
		if(price != null)
		{
			this.price = price;
			success = true;
		}
		return success;
	}
	
	/**
	 * Return true if host of event set
	 * @return success
	 */
	public boolean setVendor(String vendor)
	{
		boolean success = false;
		if(vendor.length() >= 1)
		{
			this.vendor = vendor;
			success = true;
		}
		return success;
	}

	/**
	 * @uml.property  name="databaseFunctions"
	 * @uml.associationEnd  inverse="ticket:com.PubMe.DatabaseFunctions"
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
