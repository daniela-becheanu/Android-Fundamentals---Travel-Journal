package com.example.traveljournal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.database.Trip;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderAdapter> {

    public List<Trip> getTripsList() {
        return tripsList;
    }

    public void setTripsList(List<Trip> tripsList) {
        this.tripsList = tripsList;
        notifyDataSetChanged();
    }

    List<Trip> tripsList;

    private Context context;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    public RecyclerAdapter(ArrayList<Trip> tripsList) {
        this.tripsList = tripsList;
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {
        private final CheckBox checkBox;
        private final TextView tripNameTextView;
        private final TextView destinationTextView;
        private final TextView ratingTextView;
        private final ImageView imageView;

        public ViewHolderAdapter(final View view) {
            super(view);
            tripNameTextView = view.findViewById(R.id.trip_name);
            destinationTextView = view.findViewById(R.id.destination);
            ratingTextView = view.findViewById(R.id.rating);
            imageView = view.findViewById(R.id.image);
            checkBox = view.findViewById(R.id.checkBox);
        }
    }

    @NotNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_list, parent, false);
        return new ViewHolderAdapter(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderAdapter holder, int position) {
        Trip trip = tripsList.get(position);
        String tripName = trip.getTripName();
        String destination = trip.getDestination();
        float rating = trip.getRating();
        int imageSrc = trip.getImageSrc();

        holder.tripNameTextView.setText(tripName);
        holder.destinationTextView.setText(destination);
        holder.ratingTextView.setText(Float.toString(rating));
        holder.imageView.setImageResource(imageSrc);
    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }
}
