package com.example.traveljournal.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Trip.class}, version = 1)
public abstract class TripsDataBase extends RoomDatabase {

    public abstract TripDao tripDao();

    private static TripsDataBase INSTANCE;

    public static synchronized TripsDataBase getDataBaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TripsDataBase.class, "TripsDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
