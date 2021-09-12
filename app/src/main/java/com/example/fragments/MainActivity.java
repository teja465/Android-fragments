package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
interface ItemClickListener{
    public void OnItemClick(int index);
}

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    TextView tvDescription;

    public  void clickedListItem(TextView tvDescription,int index){
        if(tvDescription ==null){
            Toast.makeText(getApplicationContext(), "tvDesc is  null", Toast.LENGTH_SHORT).show();
            return;
        }
        if( index==-1) {
            tvDescription.setText("Please select some activity");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = (TextView) findViewById(R.id.tvDescription);
        clickedListItem(tvDescription,-1);

        ArrayList<String> descriptions = new ArrayList<String>();

        for (int i =0;i<200;i++){
            descriptions.add("This is description for item "+String.valueOf(i+1));
        }

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().show(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listItemFragment))
                    .commit();

        } else {
            // In portrait
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().hide(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listItemFragment))
                    .addToBackStack(null)
                    .commit();


        }


    }


    @Override
    public void OnItemClick(int index) {
            tvDescription.setText("Clicked item at index "+String.valueOf(index));

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().show(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listItemFragment))
                    .commit();

        } else {
            // In portrait
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction().show(manager.findFragmentById(R.id.detailFragment))
                    .hide(manager.findFragmentById(R.id.listItemFragment))
                    .addToBackStack(null)
                    .commit();


        }

    }
}