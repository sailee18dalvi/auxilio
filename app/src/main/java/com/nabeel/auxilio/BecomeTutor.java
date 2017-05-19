package com.nabeel.auxilio;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BecomeTutor extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_become_tutor);
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
                    startActivity(new Intent(BecomeTutor.this, SignIn.class));
                } else {
                    // User is signed out
                    //  Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // [START_EXCLUDE]
                //  updateUI(user);
                // [END_EXCLUDE]
            }
        };

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            mAuth.signOut();
            startActivity(new Intent(BecomeTutor.this, SignIn.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        android.app.FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_profile) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_become_tutor
                            , new ProfileFragment())
                    .commit();
            // Handle the camera action
        }/*else if (id == R.id.nav_home) {

            fragment = BlankFragment.newInstance();
            setTitle("Home");

        }*/ else if (id == R.id.nav_calender_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_become_tutor
                            , new  CalendarFragment())
                    .commit();

        } else if (id == R.id.nav_notification_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_become_tutor
                            , new NotificationFragment())
                    .commit();

        } else if (id == R.id.nav_rate_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_become_tutor
                            , new RateFragment())
                    .commit();

        } else if (id == R.id.nav_faq_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_become_tutor
                            , new FAQFragment())
                    .commit();

        } else if (id == R.id.nav_contactus_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_become_tutor
                            , new ContactFragment())
                    .commit();
        } else if (id == R.id.nav_help_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_become_tutor
                            , new HelpFragment())
                    .commit();

        } else if (id == R.id.nav_settings_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_become_tutor
                            , new SettingsFragment())
                    .commit();
        }else if (id == R.id.nav_logout) {
            mAuth.signOut();
            startActivity(new Intent(BecomeTutor.this, SignIn.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
