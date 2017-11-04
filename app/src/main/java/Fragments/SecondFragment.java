package Fragments;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.mybit.R;

import org.json.JSONException;
import org.json.JSONObject;

import Constants.Constants;
import Utils.GetDataUtil;

/**
 * Created by android on 10/12/17.
 */

public class SecondFragment extends Fragment {
    private TextView txtusd, txteur;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        txtusd = view.findViewById(R.id.txt_usd);
        txteur = view.findViewById(R.id.txt_eur);


        //call the AsyncTask To make a call to the Api
        new HttpRequestAsyncTask().execute(Constants.CRYPTOCURRENCYURL);
        return view;


    }

    private class HttpRequestAsyncTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... urls) {

            return GetDataUtil.getDataFromUrl(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Log.v("Result", result);

            try {
                JSONObject obj = new JSONObject(result);


                JSONObject jsonObjectBitCoin = obj.getJSONObject(Constants.BTC);
                String btcUsd = jsonObjectBitCoin.getString(Constants.USD);
                String btcEuro = jsonObjectBitCoin.getString(Constants.EUR);

                Log.v("@BTCUSD", btcUsd);
                Log.v("@BTCEURO", btcEuro);


                currencyConverter(Double.valueOf(btcUsd));

                txteur.setText(btcEuro);
                txtusd.setText(btcUsd);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }

    private void currencyConverter(Double currencyAmount){

        Double kshDollar= currencyAmount * Constants.dollarKsh;
        Double ushDollar = currencyAmount * Constants.ugshDollar;
        Double nairaDollar = currencyAmount * Constants.nairaDollar;
        Double yuanDollar = currencyAmount * Constants.yuanDollar;


        //custom alert message

        String alert1 = "Kenya Shillings:" + kshDollar;
        String alert2 = "Uganda Shillings :" + ushDollar;
        String alert3 = "NIgerian Naira : " +nairaDollar;
        String alert4 = "Chinese Yuan :" +yuanDollar;



        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                getContext());

// Setting Dialog Title
        alertDialog2.setTitle(" Bitcoin In Other Currencies");

// Setting Dialog Message
        alertDialog2.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3 +"\n"+alert4);



// Setting Positive "Yes" Btn
        alertDialog2.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog

                    }
                });

// Setting Negative "NO" Btn


// Showing Alert Dialog
        alertDialog2.show();



    }
}