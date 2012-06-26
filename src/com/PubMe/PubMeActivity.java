package com.PubMe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;

import org.scribe.model.Token;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class PubMeActivity extends Activity {
	
	/**
	 * @uml.property  name="model"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Model model = new Model(this);
	/**
	 * @uml.property  name="twitter"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	TwitterFunctions twitter = new TwitterFunctions();
	/**
	 * @uml.property  name="fb"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	FacebookFunctions fb = new FacebookFunctions();
	/**
	 * @uml.property  name="fileName"
	 */
	String fileName = "user.jdi";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {
			load();
		} catch (OptionalDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    
    

    
    /**
     * Performs ALL actions relating to button views
     * @param view button whose action to perform
     * @throws LimitExceededException 
     * @throws IOException 
     */
    public void buttonAction(View view) throws IOException
    {
    	if(view.getId() == R.id.loginButton	|| view.getId() == R.id.backButton)
    		setContentView(R.layout.menu);
    	if(view.getId() == R.id.optionsButton)
    		setContentView(R.layout.option);
    	if(view.getId() == R.id.eventsButton)
    		setContentView(R.layout.eventpage);
    	if(view.getId() == R.id.eventButton1 || view.getId() == R.id.eventButton2
    		|| view.getId() == R.id.eventButton3)
    	{
    		setContentView(R.layout.event);

    	}
    	if(view.getId() == R.id.mapItButton)
    	{
    		this.viewMap();

    	}

    	if(view.getId() == R.id.saveButton) 
    	{
    		createDialog("Confirmation", "Your information has been saved.");
    		setContentView(R.layout.menu);
    	}
    	
    	if(view.getId() == R.id.promoteButton)
    	{
    		setContentView(R.layout.promote);

    	}
    	
    	if(view.getId() == R.id.tweetButton) // tweets
    	{

    		TextView view3 = (TextView) findViewById(R.id.promoteBox);

    		twitter.tweet(view3.getText().toString());
    		view3.setText("");

    		createDialog("Confirmation", "Your tweet has been sent.");
    	}
    	
    	if(view.getId() == R.id.fbButton) // facebook posts
    	{

    		TextView view3 = (TextView) findViewById(R.id.promoteBox);

    		twitter.tweet(view3.getText().toString());
    		view3.setText("");

    		createDialog("Confirmation", "Your facebook status has been updated.");
    	}   	
    	
    	if(view.getId() == R.id.signIn) // uses authorization code to gain account access
    	{
    		TextView view2 = (TextView) findViewById(R.id.verify);
    		String code =  view2.getText().toString();
    		twitter.signIn(code);
    		save();
    	}
    		
    	if(view.getId() == R.id.authButton) // generates authorization code
    	{
    		startActivity(twitter.authorize());
    	}

    	
    	if(view.getId() == R.id.fbSignIn) // uses authorization code to gain account access
    	{
    		TextView view2 = (TextView) findViewById(R.id.verify);
    		String code =  view2.getText().toString();
    		fb.signIn(code);
    		//save();
    	}
    	
    	if(view.getId() == R.id.fbAuthButton) // generates authorization code
    	{
    		startActivity(fb.authorize());
    	}

    	if(view.getId() == R.id.rewardsButton) 
    	{
    		setContentView(R.layout.rewards);
    	}
    	
    	
    	if(view.getId() == R.id.rewardButton || view.getId() == R.id.rewardButton2) 
    	{
    		setContentView(R.layout.rewardpage);
    	}
    	
    	if(view.getId() == R.id.ticketButton) 
    	{
    		setContentView(R.layout.payment);
    	}

    	if(view.getId() == R.id.confirmButton1) 
    	{
    		createDialog("Confirmation", "Your payment has been made.");
    	}

    	if(view.getId() == R.id.confirmButton2) 
    	{
    		createDialog("Confirmation", "Your order has been made.");
    	}
    }
    
    /**
     * Creates and displays a dialog box
     * @param title title to appear on the box
     * @param text text to appear in the box
     */
    public void createDialog(String title, String text)
    {
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle(title);
		dialog.setMessage(text);
		dialog.show();	
    }
    
    /**
     * Save user information to internal memory of device
     * @throws IOException
     */
    public void save() throws IOException
    {
    	Token accessToken = twitter.accessToken;
    	Object objs[] = new Object[10]; // holds various objects containing user information
    	objs[0] = accessToken;

    	FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
    	ObjectOutputStream os = new ObjectOutputStream(fos);
    	os.writeObject(objs);
    	os.close();

    }
    
    /**
     * Loads user information from internal memory device
     * @throws OptionalDataException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void load() throws OptionalDataException, ClassNotFoundException, IOException
    {
    	FileInputStream fis = openFileInput(fileName);
    	ObjectInputStream is = new ObjectInputStream(fis);
    	Object objs[] = (Object[]) is.readObject();
    	twitter.accessToken = (Token) objs[0];
    	is.close();
    	
    }
    
    /**
     * Displays the map activity on the android screen
     */
    public void viewMap()
    {
		Intent intent = new Intent(this, MappingActivity.class);
		startActivity(intent);	
    }

	/**
	 * @uml.property  name="twitterFunctions"
	 * @uml.associationEnd  aggregation="shared" inverse="pubMeActivity:com.PubMe.TwitterFunctions"
	 */
	private TwitterFunctions twitterFunctions;

	/**
	 * Getter of the property <tt>twitterFunctions</tt>
	 * @return  Returns the twitterFunctions.
	 * @uml.property  name="twitterFunctions"
	 */
	public TwitterFunctions getTwitterFunctions() {
		return twitterFunctions;
	}






	/**
	 * Setter of the property <tt>twitterFunctions</tt>
	 * @param twitterFunctions  The twitterFunctions to set.
	 * @uml.property  name="twitterFunctions"
	 */
	public void setTwitterFunctions(TwitterFunctions twitterFunctions) {
		this.twitterFunctions = twitterFunctions;
	}

	/**
	 * @uml.property  name="facebookFunctions"
	 * @uml.associationEnd  aggregation="shared" inverse="pubMeActivity:com.PubMe.FacebookFunctions"
	 */
	private FacebookFunctions facebookFunctions;

	/**
	 * Getter of the property <tt>facebookFunctions</tt>
	 * @return  Returns the facebookFunctions.
	 * @uml.property  name="facebookFunctions"
	 */
	public FacebookFunctions getFacebookFunctions() {
		return facebookFunctions;
	}






	/**
	 * Setter of the property <tt>facebookFunctions</tt>
	 * @param facebookFunctions  The facebookFunctions to set.
	 * @uml.property  name="facebookFunctions"
	 */
	public void setFacebookFunctions(FacebookFunctions facebookFunctions) {
		this.facebookFunctions = facebookFunctions;
	}

	/**
	 * @uml.property  name="user"
	 * @uml.associationEnd  inverse="pubMeActivity:com.PubMe.User"
	 */
	private User user;

	/**
	 * Getter of the property <tt>user</tt>
	 * @return  Returns the user.
	 * @uml.property  name="user"
	 */
	public User getUser() {
		return user;
	}






	/**
	 * Setter of the property <tt>user</tt>
	 * @param user  The user to set.
	 * @uml.property  name="user"
	 */
	public void setUser(User user) {
		this.user = user;
	}
    

}