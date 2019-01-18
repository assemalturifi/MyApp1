package com.example.assemalturifi.myapp1;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.assemalturifi.myapp1.weather.WeatherControl;


public class MenuActivity extends AppCompatActivity {


    //step8
    private Toolbar toolbar;

    //step18
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_wrapper);


        //step9
        // Setting tool bar
        toolbar = findViewById( R.id.tb_toolbar );
        setSupportActionBar(toolbar);


        //step17
        //this is for the menu option
        // Setting picture to button
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);


        //step19
        drawerLayout = findViewById( R.id.drawerLayout );
        navigationView = findViewById( R.id.nv_navigationDrawer );


        //step20
        // Setting event listener to menu items
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //step22
                //to close it when something is clicked on the drawer
                drawerLayout.closeDrawers();

                switch ( menuItem.getItemId() ){
                    case R.id.item1:
                        // Clicked home button
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                        break;
                    case R.id.item2:
                        // Calculator
                        Intent intent2 = new Intent(getApplicationContext(), CalculatorActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.item3:

                        // Weather app
                        Intent intent3 = new Intent(getApplicationContext(), WeatherControl.class);
                        startActivity(intent3);

                        break;
                }
                return true;
            }
        });




    }

    //step10
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.toolbar_menu, menu );
        return super.onCreateOptionsMenu(menu);
    }

    //step11
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //step12
        //toolbar clicked (repost app)
        switch (item.getItemId()){
            case R.id.overflowItem1:
                Toast.makeText( this, "Thank you for your feedback!", Toast.LENGTH_SHORT ).show();
                return true;

            //step13
            ////toolbar clicked (contact creator)
            case R.id.overflowItem2:
                Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse("tel:6462703075") );
                startActivity(intent);
                return true;

                //step21
                //to open the drawer
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

}
