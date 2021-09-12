package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }
    TextView tvDescription;
    View viewToGetTv;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inf = inflater.inflate(R.layout.fragment_detail, container, false);
        tvDescription = inf.findViewById(R.id.tvDescription);
        viewToGetTv =inf;
        setDescription("Please seelct some item");
        return inf;
    }

    public void setDescription(String desc){
        try{
            tvDescription.setText(desc);

        }
        catch (Exception ex) {
            Toast.makeText(getContext(), "tvDescription isnnull ,detailFragment", Toast.LENGTH_SHORT).show();
            tvDescription = viewToGetTv.findViewById(R.id.tvDescription);
            tvDescription.setText("clicked and made it");
        }


    }
}