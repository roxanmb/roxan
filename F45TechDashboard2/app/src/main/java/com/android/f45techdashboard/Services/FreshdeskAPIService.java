package com.android.f45techdashboard.Services;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import com.android.f45techdashboard.Models.FreshdeskDataModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by LeakSun on 11/09/2017.
 */

public class FreshdeskAPIService extends AsyncTask<String, String, String> {


    public void getFreshdeskData(String url)
    {
        new FreshdeskAPIService().execute(url);
    }



    @Override
    protected String doInBackground(String... strings) {

        StringBuilder stringBuilder = new StringBuilder();
        String data;
        HttpURLConnection apiCon;
        URL url;
        InputStream inputStream;
        BufferedReader bufferedReader;
        String userName = "WU7cFIcIa5VClq8Ns52";
        String passWord = "Welcome@12345";
        String userPass = userName + ":" + passWord;
        String encUserPass = Base64.encodeToString(userPass.getBytes(), Base64.NO_WRAP);
        FreshdeskDataModel freshdeskModel = null;
        try
        {

            url = new URL(strings[0]);
            apiCon = (HttpURLConnection) url.openConnection();
            apiCon.setRequestMethod("GET");
            apiCon.setRequestProperty("Authorization", "Basic " + encUserPass);
            apiCon.connect();

            inputStream = apiCon.getInputStream();

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while((data = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(data);
                stringBuilder.append("\n");
            }


            apiCon.disconnect();
            bufferedReader.close();


            Log.d("resultt", stringBuilder.toString());
            Log.d("LIXAN GWAPO", "FINALLY ,,/,,");

        }
        catch (Exception e)
        {
            e.printStackTrace();


        }
        try {


            JSONArray jsonArray = new JSONArray(stringBuilder.toString());
            JSONObject jsonObject;
            ArrayList<FreshdeskDataModel> array2 = new ArrayList<>();


            for (int i = 0; i < jsonArray.length(); i++)
            {
                jsonObject = jsonArray.getJSONObject(i);
                freshdeskModel = new Gson().fromJson(jsonObject.toString(), FreshdeskDataModel.class);
//                freshdeskDataModelList = new Gson().fromJson(deputyModel.toString(), DataModelLists.class);
                array2.add(freshdeskModel);
            }
            Log.d("yoo", "mehehehe ,,/,,");


        }catch (Exception e) {
            e.printStackTrace();
        }



        return null;
    }
}
