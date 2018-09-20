package edu.virginia.cs.cs4720.bucketlistactivity;

import android.widget.EditText;
import java.util.ArrayList;
import java.util.Date;


public class BucketItem {
    private String name;
    private Date time;
    private String description;
    private double latitude;
    private double longitude;
    private boolean isCompleted;

    public BucketItem(String newName, Date newTime, String newDescription, double newLatitude, double newLongitude, boolean newIsCompleted){
        name = newName;
        time = newTime;
        description = newDescription;
        latitude = newLatitude;
        longitude = newLongitude;
        isCompleted = newIsCompleted;
    }

    public String getName(){
        return name;
    }

    public Date getTime(){
        return time;
    }

    public String getDescription(){
        return description;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public boolean getIsCompleted(){
        return isCompleted;
    }

    public int dateComparison(Date dateToCompare, BucketItem item){
        return dateToCompare.compareTo(item.getTime());

    }

    public static ArrayList<BucketItem> createInitialBucketList(int numItems, String name, Date time, String description, double latitude, double longitude, boolean isCompleted){

        ArrayList<BucketItem> bucketItems = new ArrayList<>();

        for(int i = 1; i <= numItems; i++){
            bucketItems.add(new BucketItem(name, time, description, latitude, longitude, isCompleted));
        }
        return bucketItems;
    }

}
