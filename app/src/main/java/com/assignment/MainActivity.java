package com.assignment;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.assignment.util.RecyclerViewItemDecorator;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FloatingActionButton mFabBtn;
    AndoirdNamesAdapter andoirdNamesAdapter;
    final String[] androidVersions = {"Alpha", "Beta", "CupCake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwitch", "JellyBean", "KitKat", "LollyPop", "MarshMallow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init layout (.xml)
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        // init toolbar, recyclerview and fab button
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_main_version_name);
        mFabBtn = (FloatingActionButton) findViewById(R.id.fab);
        setSupportActionBar(mToolbar); // set toolbar as Actionbar
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        andoirdNamesAdapter = new AndoirdNamesAdapter(this, androidVersions);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new RecyclerViewItemDecorator(this, 0));
        mRecyclerView.setAdapter(andoirdNamesAdapter); // set adapter 
       
        // set onclick listener on Fab button
        mFabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Assignment 15.2 : Android Version Names", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // Inflate the menu; this will adds items to the action bar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    // this method will handle option menu item click event
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: ");
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_search) {
            Toast.makeText(this, "Search",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_add) {
            Toast.makeText(this, "Add",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_delete) {
            Toast.makeText(this, "Delete",
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
