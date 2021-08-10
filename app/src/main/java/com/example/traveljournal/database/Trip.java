package com.example.traveljournal.database;

import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.traveljournal.Utils;
import com.example.traveljournal.Utils.TripType;

@Entity
public class Trip {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int uid;

    @ColumnInfo(name = "trip_name")
    private String tripName;

    @ColumnInfo(name = "destination")
    private String destination;

    @ColumnInfo(name = "rating")
    private float rating;

    @ColumnInfo(name = "image_source")
    private int imageSrc;

    @Ignore
    public Trip(String tripName) {
        this.tripName = tripName;
    }

    public Trip(String tripName, String destination, float rating, int imageSrc) {
        this.tripName = tripName;
        this.destination = destination;
        this.rating = rating;
        this.imageSrc = imageSrc;
    }

    @Ignore
    public Trip(String tripName, String destination, float rating) {
        this.tripName = tripName;
        this.destination = destination;
        this.rating = rating;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public float getRating() {
        return rating;
    }

    public String getDestination() {
        return destination;
    }

    public String getTripName() {
        return tripName;
    }

}
