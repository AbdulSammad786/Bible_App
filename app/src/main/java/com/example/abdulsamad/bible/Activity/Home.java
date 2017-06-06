package com.example.abdulsamad.bible.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.abdulsamad.bible.Fragments.HomeFragment;
import com.example.abdulsamad.bible.Fragments.ReadBook;
import com.example.abdulsamad.bible.R;
public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.container,new HomeFragment()).commit();
        initBottomBar();
        initSwipeToReferesh();
    }
    private void initSwipeToReferesh()
    {
        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        //can define more than one color for siper referesh
        mSwipeRefreshLayout.setColorSchemeResources(R.color.black);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Snackbar mSnack = Snackbar.make(mSwipeRefreshLayout, "Loading data from server... It will not end :P", Snackbar.LENGTH_INDEFINITE);
                View view = mSnack.getView();
              //  view.setBackgroundColor();
                mSnack.show();
            }
        });
    }
    private void initBottomBar()
    {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        FragmentTransaction transaction=null;
                        switch (item.getItemId()) {
                            case R.id.home:
                                Log.d("hello", "onNavigationItemSelected: ");
                                item.setIcon(null);
                                item.setIcon(R.drawable.home);
                                transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.container, new HomeFragment()).commit();
                                break;
                            case R.id.read:
                                item.setIcon(R.drawable.read);
                                transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.container, new ReadBook()).commit();
                                break;
                            case R.id.plans:
                                item.setIcon(R.drawable.plans);
                                transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.container, new HomeFragment()).commit();
                                break;
                            case R.id.profile:
                                item.setIcon(R.drawable.user);
                                transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.container, new HomeFragment()).commit();
                                break;case R.id.more:
                                item.setIcon(R.drawable.menu);
                                transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.container, new HomeFragment()).commit();
                                break;
                        }
                        return true;
                    }
                });
    }
}