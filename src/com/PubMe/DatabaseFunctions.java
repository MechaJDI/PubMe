package com.PubMe;

/**
 * Handles all database functions
 * @author JDI
 *
 */
public class DatabaseFunctions 
{
	//user database
	//event database
	//ticket database
	
	
	/**
	 * Constructor
	 */
	public DatabaseFunctions()
	{
		
	}

	/**
	 * @uml.property  name="ticket"
	 * @uml.associationEnd  aggregation="shared" inverse="databaseFunctions:com.PubMe.Ticket"
	 */
	private Ticket ticket;

	/**
	 * Getter of the property <tt>ticket</tt>
	 * @return  Returns the ticket.
	 * @uml.property  name="ticket"
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * Setter of the property <tt>ticket</tt>
	 * @param ticket  The ticket to set.
	 * @uml.property  name="ticket"
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * @uml.property  name="event"
	 * @uml.associationEnd  aggregation="shared" inverse="databaseFunctions:com.PubMe.Event"
	 */
	private Event event;

	/**
	 * Getter of the property <tt>event</tt>
	 * @return  Returns the event.
	 * @uml.property  name="event"
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Setter of the property <tt>event</tt>
	 * @param event  The event to set.
	 * @uml.property  name="event"
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * @uml.property  name="mappingActivity"
	 * @uml.associationEnd  aggregation="shared" inverse="databaseFunctions:com.PubMe.MappingActivity"
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
	
}
