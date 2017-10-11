package com.example.android.mybit;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
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
    private TextView txtusd, txtbtc , txteur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        txtusd = (TextView) findViewById(R.id.txt_usd);
//        txtbtc = (TextView) findViewById(R.id.txt_btc);
//        txteur= (TextView) findViewById(R.id.txt_eur);


        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        myAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(myAdapter);

        //call the AsyncTask To make a call to the Api
        new HttpRequestAsyncTask().execute(Constants.CRYPTOCURRENCYURL);

        mAdapter = new BitCoinDisplayAdapter(bitCoinArrayList);


//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);


    }
    private class HttpRequestAsyncTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... urls) {

            return GetDataUtil.getDataFromUrl(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Log.v("Result",result);

            try {
                JSONObject obj = new JSONObject(result);

                JSONObject jsonObjectEtherium= obj.getJSONObject("ETH");
                String usd = jsonObjectEtherium.getString("USD");
                String euro = jsonObjectEtherium.getString("EUR");
                Log.v("@ETHUSD", usd);
                Log.v("@ETHEURO", euro);

                JSONObject jsonObjectBitCoin = obj.getJSONObject("BTC");
                String btcUsd = jsonObjectBitCoin.getString("USD");
                String btcEuro = jsonObjectBitCoin.getString("EUR");

                Log.v("@BTCUSD", btcUsd);
                Log.v("@BTCEURO", btcEuro);

//                Double btc = obj.getDouble(Constants.BTC);
//                String usd = obj.getString(Constants.USD);
//                String eur = obj.getString(Constants.EUR);
//
//                Log.v("@BTC", String.valueOf(btc));
//                Log.v("@USD", usd);
//                Log.v("@EUR", eur);


//                txtbtc.setText(btc.toString());
//                txteur.setText(eur);
//                txtusd.setText(usd);

//
//                bitCoinArrayList.add(new BitCoinObject(btc,usd,eur));
               Log.v("bitcoinArrayList", String.valueOf(bitCoinArrayList.size()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }






    }






