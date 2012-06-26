package com.PubMe;

import android.app.Activity;

/**
 *Business layer of program
 * @author JDI
 */
public class Model 
{
    //Nodes to hold teams
    //Array for teams so they can be referred to by ID for initial app
	/**
	 * @uml.property  name="activity"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Activity activity;
	
	public Model(Activity act)
	{
		this.activity = act;
	}
}
