package AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import Adapters.BitCoinDisplayAdapter;
import Constants.Constants;
import Utils.GetDataUtil;

/**
 * Created by android on 10/11/17.
 */



//    public class HttpRequestAsyncTask extends AsyncTask<String, Void, String> {
//
//
//        @Override
//        protected String doInBackground(String... urls) {
//
//            return GetDataUtil.getDataFromUrl(urls[0]);
//        }
//
//        // onPostExecute displays the results of the AsyncTask.
//        @Override
//        protected void onPostExecute(String result) {
//
//            Log.v("Result",result);
//
//            try {
//                JSONObject obj = new JSONObject(result);
//                Double btc = obj.getDouble(Constants.BTC);
//                String usd = obj.getString(Constants.USD);
//                String eur = obj.getString(Constants.EUR);
//
//                Log.v("@BTC", String.valueOf(btc));
//                Log.v("@USD", usd);
//                Log.v("@EUR", eur);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//    }

