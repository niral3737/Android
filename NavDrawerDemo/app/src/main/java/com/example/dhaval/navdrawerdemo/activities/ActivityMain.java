package com.example.dhaval.navdrawerdemo.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.dhaval.navdrawerdemo.fragments.FragmentHome;
import com.example.dhaval.navdrawerdemo.fragments.FragmentNavigationDrawer;
import com.example.dhaval.navdrawerdemo.fragments.FragmentNote;
import com.example.dhaval.navdrawerdemo.R;
import com.example.dhaval.navdrawerdemo.fragments.FragmentWebView;

public class ActivityMain extends AppCompatActivity implements FragmentNavigationDrawer.FragmentDrawerListener {

    private Toolbar toolbar;
    private RelativeLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.include);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // set up drawer fragment
        final FragmentNavigationDrawer drawerFragment =
                (FragmentNavigationDrawer) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        // drawer lisener for onclick callback
        drawerFragment.setDrawerListener(this);

        container = (RelativeLayout) findViewById(R.id.container);

        displayView(0);

    }




    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position){
        Fragment fragment = null;
        String title = "";
        switch (position) {
            case 0:
                fragment = new FragmentHome();
                title = "Home";
                break;
            case 1:
                fragment = new FragmentNote();
                title = "Notes";
                break;
            case 2:
                fragment = new FragmentWebView();
                title = "Wev View";
                break;

            default:
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);

        }
    }
}
