package com.example.assemalturifi.myapp1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

//step5
public class MainActivity extends MenuActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //step7
        setInclude( R.layout.activity_main);
    }

    //step6
    public void setInclude(int layoutResID){
        LinearLayout mainLayout = findViewById(R.id.layoutContent);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(layoutResID, null);
        mainLayout.removeAllViews();
        mainLayout.addView(layout);
    }
}
//toolbar view
//navigation view
//action bar
//drawerLayout
