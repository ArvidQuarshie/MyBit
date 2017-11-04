package Fragments;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
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

import com.example.android.mybit.R;

import org.json.JSONException;
import org.json.JSONObject;

import Adapters.BitCoinDisplayAdapter;
import Constants.Constants;
import Database.SQLiteDatabaseHandler;
import Models.BitCoinObject;
import Utils.GetDataUtil;

/**
 * Created by android on 10/12/17.
 */

public class FirstFragment extends Fragment {

    private TextView txtusd,txteur;
    private SQLiteDatabaseHandler db;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        txtusd =  view.findViewById(R.id.txt_usd);
        txteur=  view.findViewById(R.id.txt_eur);
        db = new SQLiteDatabaseHandler(getContext());



        //call the AsyncTask To make a call to the Api
        new HttpRequestAsyncTask().execute(Constants.CRYPTOCURRENCYURL);

//        BitCoinObject updateBitcoin = new BitCoinObject("000","000");
//        db.updateData(updateBitcoin,"1");
//        db.deleteItem(updateBitcoin,"1");

//        for(BitCoinObject i : db.displayData()){
//
//          Log.v("@databasevalueseuro",  i.getEUR());
//            Log.v("@databasevaluedollar",  i.getUSD());
//
//        }

//        Log.v("@database", String.valueOf(db.displayData()));
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

                JSONObject jsonObjectEtherium = obj.getJSONObject(Constants.ETH);
                String usd = jsonObjectEtherium.getString(Constants.USD);
                String euro = jsonObjectEtherium.getString(Constants.EUR);
                Log.v("@ETHUSD", usd);
                Log.v("@ETHEURO", euro);


                BitCoinObject bitCoinObject = new BitCoinObject(usd,euro);

                 db.insertData(bitCoinObject);

                Log.v("@database", db.toString());

                txteur.setText(euro);
                txtusd.setText(usd);


                currencyConverter(Double.valueOf(usd));


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
        alertDialog2.setTitle(" Etherium In Other Currencies");

// Setting Dialog Message
        alertDialog2.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3 +"\n"+alert4);



// Setting Positive "Yes" Btn
        alertDialog2.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog

                    }
                });



// Showing Alert Dialog
        alertDialog2.show();



    }
}