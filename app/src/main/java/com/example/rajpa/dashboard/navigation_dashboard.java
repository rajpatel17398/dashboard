package com.example.rajpa.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.rajpa.dashboard.Activity.Buy;
import com.example.rajpa.dashboard.Activity.Display;
import com.example.rajpa.dashboard.Activity.History;
import com.example.rajpa.dashboard.Activity.Invoice;
import com.example.rajpa.dashboard.Activity.Purchase_payment;
import com.example.rajpa.dashboard.Activity.Sell;
import com.example.rajpa.dashboard.Activity.Sell_payment;
import com.example.rajpa.dashboard.Activity.Settings;
import com.example.rajpa.dashboard.Activity.Stock;

public class navigation_dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private  DrawerLayout drawer;
    CardView buy,sell,invoice,display,pp,sp,history,settings;
    TextView email;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String ee=getIntent().getStringExtra("email");




        buy=(CardView)findViewById(R.id.buy);
        sell=(CardView)findViewById(R.id.sell);
        invoice=(CardView)findViewById(R.id.Invoice);
        display=(CardView)findViewById(R.id.display);
        pp=(CardView)findViewById(R.id.pp);
        sp=(CardView)findViewById(R.id.sp);
        history=(CardView)findViewById(R.id.history);
        settings=(CardView)findViewById(R.id.settings);



       // email.setText(ee);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=new Intent(navigation_dashboard.this, Buy.class);
                startActivity(i1);

            }
        });
        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(navigation_dashboard.this, Purchase_payment.class);
                startActivity(i2);
            }
        });
        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(navigation_dashboard.this, Sell_payment.class);
                startActivity(i3);
            }
        });
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(navigation_dashboard.this, Sell.class);
                startActivity(i3);
            }
        });
        invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(navigation_dashboard.this, Invoice.class);
                startActivity(i4);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(navigation_dashboard.this, History.class);
                startActivity(i4);
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(navigation_dashboard.this, Display.class);
                startActivity(i4);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(navigation_dashboard.this, Settings.class);
                startActivity(i4);
            }
        });





//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        Toolbar toolbar =  findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                ( this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

//        this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close

        drawer.addDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        email=(TextView)headerView.findViewById(R.id.email);

        email.setText(ee);

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
//            Toast.makeText(navigation_dashboard.this,"press exit again",Toast.LENGTH_LONG).show();
            finishAffinity();
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_username) {
            Intent intent=new Intent(navigation_dashboard.this,registration.class);
            startActivity(intent);

            // Handle the camera action
        }
        else if (id == R.id.nav_addstock)
        {
            Intent intent=new Intent(navigation_dashboard.this,Add_stock.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_remove_stock)
        {
            Intent intent=new Intent(navigation_dashboard.this,Remove_stock.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_purchaseparties)
        {
            Intent intent=new Intent(navigation_dashboard.this,Add_purchase_parties.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_sellparties)
        {
            Intent intent=new Intent(navigation_dashboard.this,Add_sell_parties.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_logout)
        {
            Intent intent=new Intent(navigation_dashboard.this,login.class);
            startActivity(intent);
            finishAffinity();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
