package com.PubMe;

import java.io.IOException;
import java.util.List;
import java.util.Random;


import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


/**
 * Class for creating and display map, including its points
 * @author JDI
 *
 */
public class MappingActivity extends MapActivity {
	
	/**
	 * @uml.property  name="linearLayout"
	 * @uml.associationEnd  readOnly="true"
	 */
	LinearLayout linearLayout;
	/**
	 * @uml.property  name="mapView"
	 * @uml.associationEnd  
	 */
	MapView mapView;
	/**
	 * @uml.property  name="mapControl"
	 * @uml.associationEnd  
	 */
	MapController mapControl;
	
	/**
	 * @uml.property  name="mapOverlays"
	 */
	List<Overlay> mapOverlays;
	/**
	 * @uml.property  name="drawable"
	 * @uml.associationEnd  
	 */
	Drawable drawable;
	/**
	 * @uml.property  name="itemMapOverlay"
	 * @uml.associationEnd  
	 */
	ItemizedMapOverlay itemMapOverlay;
	/**
	 * @uml.property  name="points"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	GeoPoint[] points = {new GeoPoint((int) (35.1520881 * 1E6), (int) (-90.0502487 * 1E6)), new GeoPoint((int) (35.1327587 * 1E6), (int) (-90.0514932 * 1E6)), new GeoPoint((int) (35.1394715 * 1E6), (int) (-90.0514932 * 1E6))};
	/**
	 * @uml.property  name="pointInfo" multiplicity="(0 -1)" dimension="1"
	 */
	String[] pointInfo = {"Cook convention Center", "Agricenter International", "FedEx Forum"};
	/**
	 * @uml.property  name="number"
	 */
	int number = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        
        setContentView(R.layout.gmap);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(false);
        

               

        
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.p_point);
        itemMapOverlay = new ItemizedMapOverlay(drawable, this);
        
        Random random = new Random();
        
        //points = this.populatePoints();


       
        number = random.nextInt(points.length);
        GeoPoint point = points[number];
        /**
        GeoPoint point = null;
		
        try {
			point = this.generateGeoPoint("255 N Main St, Memphis, TN 38103");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
**/
        
        pointPlacement(point);
        mapSetup(point);
        
       

        
    }
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Sets default view of location on map
	 * @param point center of map
	 */
	private void mapSetup(GeoPoint point){
        mapControl = mapView.getController();
        mapControl.setCenter(point);
        mapControl.setZoom(18);
	}
	
	/**
	 * Places points on the map
	 * @param point point to be placed
	 */
	private void pointPlacement(GeoPoint point){
		OverlayItem overlayItem = null;
        if(number == 0)
        	overlayItem = new OverlayItem(point, "Memphis Cook Convention Center", "255 N Main St, Memphis, TN 38103");
        if(number == 1)
        	overlayItem = new OverlayItem(point, "Agricenter International", "7777 Walnut Grove Rd. Memphis, TN 38120");
        if(number == 2)
        	overlayItem = new OverlayItem(point, "FedEx Forum", "191 Beale Street, Memphis, TN 38103");

        	
        itemMapOverlay.addOverlay(overlayItem);
        mapOverlays.add(itemMapOverlay);
	}
	
	/**
	 * Generate a geopoint from an address string
	 * @param address
	 * @return a converted geopoint
	 * @throws IOException
	 */
	public GeoPoint generateGeoPoint(String address) throws IOException
	{
		GeoPoint point = null;
		Geocoder gcoder = new Geocoder(this);
		List<Address> addresses = gcoder.getFromLocationName(address, 50);
		Address location = addresses.get(1);
		point = new GeoPoint((int) (location.getLatitude() * 1E6), (int) (location.getLongitude() * 1E6));
		
		return point;
	}
	
	/**
	 * Creates an array of GeoPoints
	 * @return a GeoPoint array of GeoPoints
	 */
	public GeoPoint[] populatePoints()
	{
		GeoPoint[] points = new GeoPoint[3];
		
		points[0] = new GeoPoint((int) (35.1520881 * 1E6), (int) (-90.0502487 * 1E6)); // Cook convention Center  
		points[1] = new GeoPoint((int) (35.1327587 * 1E6), (int) (-90.0514932 * 1E6)); // Agricenter International
		points[2] = new GeoPoint((int) (35.1394715 * 1E6), (int) (-90.0514932 * 1E6)); // FedEx Forum
		        
		return points;
	}

	/** 
	 * @uml.property name="itemizedMapOverlay"
	 * @uml.associationEnd aggregation="shared" inverse="mappingActivity:com.PubMe.ItemizedMapOverlay"
	 */
	private ItemizedMapOverlay itemizedMapOverlay;

	/** 
	 * Getter of the property <tt>itemizedMapOverlay</tt>
	 * @return  Returns the itemizedMapOverlay.
	 * @uml.property  name="itemizedMapOverlay"
	 */
	public ItemizedMapOverlay getItemizedMapOverlay() {
		return itemizedMapOverlay;
	}

	/** 
	 * Setter of the property <tt>itemizedMapOverlay</tt>
	 * @param itemizedMapOverlay  The itemizedMapOverlay to set.
	 * @uml.property  name="itemizedMapOverlay"
	 */
	public void setItemizedMapOverlay(ItemizedMapOverlay itemizedMapOverlay) {
		this.itemizedMapOverlay = itemizedMapOverlay;
	}

	/**
	 * @uml.property  name="twitterFunctions"
	 * @uml.associationEnd  aggregation="shared" inverse="mappingActivity:com.PubMe.TwitterFunctions"
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
	 * @uml.associationEnd  aggregation="shared" inverse="mappingActivity:com.PubMe.FacebookFunctions"
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
	 * @uml.property  name="event"
	 * @uml.associationEnd  inverse="mappingActivity:com.PubMe.Event"
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
	 * @uml.property  name="event1"
	 * @uml.associationEnd  aggregation="shared" inverse="mappingActivity1:com.PubMe.Event"
	 */
	private Event event1;

	/**
	 * Getter of the property <tt>event1</tt>
	 * @return  Returns the event1.
	 * @uml.property  name="event1"
	 */
	public Event getEvent1() {
		return event1;
	}

	/**
	 * Setter of the property <tt>event1</tt>
	 * @param event1  The event1 to set.
	 * @uml.property  name="event1"
	 */
	public void setEvent1(Event event1) {
		this.event1 = event1;
	}

	/**
	 * @uml.property  name="databaseFunctions"
	 * @uml.associationEnd  inverse="mappingActivity:com.PubMe.DatabaseFunctions"
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
