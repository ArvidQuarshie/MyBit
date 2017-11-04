package com.example.android.mybit;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.gigamole.navigationtabstrip.NavigationTabStrip;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import Adapters.BitCoinDisplayAdapter;
import Adapters.TabsPagerAdapter;
import Constants.Constants;
import Models.BitCoinObject;
import Utils.GetDataUtil;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BitCoinDisplayAdapter mAdapter;
    private TabsPagerAdapter myAdapter;
    private ArrayList<BitCoinObject> bitCoinArrayList = new ArrayList<BitCoinObject>();
    private TextView txtusd, txtbtc, txteur;

    private NavigationTabStrip mTopNavigationTabStrip;
    private NavigationTabStrip mCenterNavigationTabStrip;
    private NavigationTabStrip mBottomNavigationTabStrip;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        myAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(myAdapter);





    }


}






