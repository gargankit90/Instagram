package com.ankitgarg.instagram;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ankitgarg.instagram.ui.popular.PopularFragment;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        startFragment();
    }

    protected void startFragment() {
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        PopularFragment popularFragment = (PopularFragment) getSupportFragmentManager().findFragmentByTag("POPULAR_FRAGMENT");
        if(popularFragment == null){
            popularFragment = new PopularFragment();
        }
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_holder, popularFragment,"POPULAR_FRAGMENT");
        // Complete the changes added above
        ft.commit();
    }

    protected void setupToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
