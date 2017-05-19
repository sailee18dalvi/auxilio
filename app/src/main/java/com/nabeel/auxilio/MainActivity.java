package com.nabeel.auxilio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

   /* private String[] titles = {"Find Tutor","Become Tutor", "Syllabus", "Question Paper", "Notes","Colleges", "Classes", "Exam Course"};
    private int[] images = { R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5,
                            R.drawable.p6, R.drawable.p2, R.drawable.p4, R.drawable.p3 };*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (firebaseAuth.getCurrentUser() == null) {
                    // User is signed in
                    //Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    startActivity(new Intent(MainActivity.this, SignIn.class));
                } else {
                    // User is signed out
                    //  Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // [START_EXCLUDE]
                //  updateUI(user);
                // [END_EXCLUDE]
            }
        };


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setNavigate(R.id.nav_home);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setNavigate(int id)
    {
        android.app.FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_profile) {
            fragmentManager.beginTransaction()
                    .replace(R.id.myfragment_container
                            , new ProfileFragment())
                    .commit();
            // Handle the camera action
        }else if (id == R.id.nav_home) {
            fragmentManager.beginTransaction()
                    .replace(R.id.myfragment_container
                            , new FragmentNew())
                    .commit();

        } else if (id == R.id.nav_calender_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.myfragment_container
                            , new  CalendarFragment())
                    .commit();

        } else if (id == R.id.nav_notification_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.myfragment_container
                            , new NotificationFragment())
                    .commit();

        } else if (id == R.id.nav_rate_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.myfragment_container
                            , new RateFragment())
                    .commit();

        } else if (id == R.id.nav_faq_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.myfragment_container
                            , new FAQFragment())
                    .commit();

        } else if (id == R.id.nav_contactus_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.myfragment_container
                            , new ContactFragment())
                    .commit();
        } else if (id == R.id.nav_help_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.myfragment_container
                            , new HelpFragment())
                    .commit();

        } else if (id == R.id.nav_settings_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.myfragment_container
                            , new SettingsFragment())
                    .commit();
        }else if (id == R.id.nav_logout) {
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, SignIn.class));
        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
       setNavigate(id);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



/*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        if (id == R.id.nav_profile) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main
                            , new  ProfileFragment())
                    .commit();
        } else if (id == R.id.nav_home) {

            fragment = MainPage.newInstance("some1","some2");
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relativelayout_for_fragment,
                    fragment,
                    fragment.getTag()
            ).commit();

        }else if (id == R.id.nav_calender_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main
                            , new  CalendarFragment())
                    .commit();

        } else if (id == R.id.nav_notification_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main
                            , new NotificationFragment())
                    .commit();

        } else if (id == R.id.nav_rate_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main
                            , new RateFragment())
                    .commit();

        } else if (id == R.id.nav_faq_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main
                            , new FAQFragment())
                    .commit();

        } else if (id == R.id.nav_contactus_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main
                            , new ContactFragment())
                    .commit();
        } else if (id == R.id.nav_help_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main
                            , new HelpFragment())
                    .commit();

        } else if (id == R.id.nav_settings_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_main
                            , new SettingsFragment())
                    .commit();
        }else if (id == R.id.nav_logout) {
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, SignIn.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/





}
