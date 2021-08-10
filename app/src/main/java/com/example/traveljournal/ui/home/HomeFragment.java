package com.example.traveljournal.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.R;
import com.example.traveljournal.RecyclerAdapter;
import com.example.traveljournal.database.AddTripActivity;
import com.example.traveljournal.database.Trip;
import com.example.traveljournal.database.TripsDataBase;
import com.example.traveljournal.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        FloatingActionButton fabAddTrip = root.findViewById(R.id.fab);

        fabAddTrip.setOnClickListener(v -> startActivityForResult(new Intent(getActivity(), AddTripActivity.class), 4));

        initRecyclerView(root);

        loadTripsList();

        return root;
    }

    public void initRecyclerView(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.home_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adapter = new RecyclerAdapter(getContext());
        recyclerView.setAdapter(adapter);
    }

    private void loadTripsList() {
        TripsDataBase dataBase = TripsDataBase.getDataBaseInstance(getContext());
        List<Trip> trips = dataBase.tripDao().getAllTrips();
        adapter.setTripsList(trips);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if (requestCode == 4) {
            loadTripsList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}