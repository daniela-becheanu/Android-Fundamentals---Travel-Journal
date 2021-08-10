package com.example.traveljournal;

import com.example.traveljournal.database.Trip;

public class Utils {
    public enum TripType {
        CITY_BREAK("City break"),
        SEA_SIDE("Sea side"),
        MOUNTAINS("Mountains");

        private final String s;

        TripType(String s) {
            this.s = s;
        }

        public String getS() {
            return s;
        }
    }

}
