package com.PubMe;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

/**
 * Creates and manages the look of points placed on the map
 * @author JDI
 *
 */
public class ItemizedMapOverlay extends ItemizedOverlay {
	
	/**
	 * @uml.property  name="mOverlays"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.google.android.maps.OverlayItem"
	 */
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	/**
	 * @uml.property  name="mcontext"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Context mcontext;

	public ItemizedMapOverlay(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		mcontext = context;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mOverlays.size();
	}

	/**
	 * Adds the overlay displaying information about a point to a list
	 * @param overlay
	 */
	public void addOverlay(OverlayItem overlay){
		mOverlays.add(overlay);
		populate();
	}
	
	/**
	 * Displays message when item is clicked
	 */
	protected boolean onTap(int index){
		OverlayItem item = mOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(mcontext);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return false;
		
	}

	/** 
	 * @uml.property name="mappingActivity"
	 * @uml.associationEnd inverse="itemizedMapOverlay:com.PubMe.MappingActivity"
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
