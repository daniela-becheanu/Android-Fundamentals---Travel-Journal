package com.example.traveljournal.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.traveljournal.R;

public class AddTripActivity extends AppCompatActivity {
    private EditText editTextTripName;
    private EditText editTextDestination;
    private EditText editTextRating;
    private EditText editTextImageSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        editTextTripName = findViewById(R.id.enter_trip_name);
        editTextDestination = findViewById(R.id.enter_destination);
        editTextRating = findViewById(R.id.enter_rating);
        editTextImageSrc = findViewById(R.id.enter_image_src);

        Button buttonAddTrip = findViewById(R.id.add_trip_button);
        buttonAddTrip.setOnClickListener(v -> saveNewTrip(
                editTextTripName.getText().toString(),
                editTextDestination.getText().toString(),
                editTextRating.getText().toString(),
                editTextImageSrc.getText().toString()));
    }

    private void saveNewTrip(String tripName, String destination, String rating, String imageSrc){
        int idSrc = getResources().getIdentifier(imageSrc , "drawable", getPackageName());

        TripsDataBase dataBase = TripsDataBase.getDataBaseInstance(this.getApplicationContext());
        Trip trip = new Trip(tripName, destination, Float.parseFloat(rating), idSrc);

        dataBase.tripDao().insertTrip(trip);

        finish();
    }
}