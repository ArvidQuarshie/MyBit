package Utils;

import android.util.Log;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by android on 10/10/17.
 */

public class GetDataUtil {

    public static String getDataFromUrl(String url) {
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            URL CryptoCurrnecyEndPoint = new URL(url);

            // make GET request to the given URL
            HttpsURLConnection myConnection =
                    (HttpsURLConnection) CryptoCurrnecyEndPoint.openConnection();
            inputStream = myConnection.getInputStream();


            if (inputStream != null)
                result =InputStreamUtil.convertInputStreamToString(myConnection.getInputStream());
            else
                result = "Connection to Endpoint Failed";

        } catch (Exception e) {
            Log.v("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

}
