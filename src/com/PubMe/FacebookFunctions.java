package com.PubMe;

import org.scribe.*;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FacebookApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import android.content.Intent;
import android.net.Uri;

/**
 * Class enabling Facebook functionality
 * @author JDI
 *
 */
public class FacebookFunctions 
{

	/**
	 * @uml.property  name="emptyToken"
	 * @uml.associationEnd  
	 */
	Token emptyToken = null;
	/**
	 * @uml.property  name="accessToken"
	 * @uml.associationEnd  
	 */
	Token accessToken;
	/**
	 * @uml.property  name="apiKey"
	 */
	protected String apiKey = "PutYourApiKeyHere";
	/**
	 * @uml.property  name="apiSecret"
	 */
	protected String apiSecret = "PutYourApiSecretHere";
	/**
	 * @uml.property  name="service"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	OAuthService service;
	/**
	 * @uml.property  name="request"
	 * @uml.associationEnd  
	 */
	OAuthRequest request;
	/**
	 * @uml.property  name="intent"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Intent intent;
	/**
	 * @uml.property  name="verifier"
	 * @uml.associationEnd  
	 */
	Verifier verifier;
	/**
	 * @uml.property  name="code"
	 */
	String code;
	
	public FacebookFunctions()
	{
		service = new ServiceBuilder()
					.provider(FacebookApi.class)
					.apiKey(apiKey)
					.apiSecret(apiSecret)
					.callback("http://mechaapps.com/oauth_callback/")
					.build();
		String authUrl = service.getAuthorizationUrl(emptyToken);
		intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(authUrl));
	}
	
	/**
	 * Displays a webpage for account authorization
	 * @return information regarding how the website should be displayed
	 */
	public Intent authorize()
	{
		return intent;
	}
	
	/**
	 * Authorize sign in based on inputted code
	 * @param code the generated verification code
	 */
	public void signIn(String code)
	{		
		this.code = code;
		verifier = new Verifier(this.code);
		accessToken = service.getAccessToken(emptyToken, verifier);
	}
	
	/**
	 * Posts a tweet to the user's account
	 * @param text the content of the tweet
	 */
	public void tweet(String text)
	{
		request = new OAuthRequest(Verb.POST, "https://graph.facebook.com/me");

		
		request.addBodyParameter("status", text);
		service.signRequest(accessToken, request);
		request.send();
		
	}

	/**
	 * @uml.property  name="mappingActivity"
	 * @uml.associationEnd  inverse="facebookFunctions:com.PubMe.MappingActivity"
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
	 * @uml.property  name="pubMeActivity"
	 * @uml.associationEnd  inverse="facebookFunctions:com.PubMe.PubMeActivity"
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
