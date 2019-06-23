package com.mickeywilliamson.placesandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchFragment(View view) {
        Intent i = new Intent(this, AutocompleteFragmentActivity.class);
        startActivity(i);
    }

    public void launchActivity(View view) {
        Intent i = new Intent(this, AutocompleteActivityActivity.class);
        startActivity(i);
    }


}
