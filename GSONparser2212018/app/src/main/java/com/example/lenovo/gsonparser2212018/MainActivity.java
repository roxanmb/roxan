package com.example.lenovo.gsonparser2212018;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView name, age, gender, alive, hobbies;
    private static final String url = "https://gist.githubusercontent.com/wwwdotphilip/d76ce24848301c454a3670a13a7918db/raw/c2bef30cc78e1a6ae49d9927ce831e43b7d0f7cb/sample.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.tvName);
        age = findViewById(R.id.tvAge);
        gender = findViewById(R.id.tvGender);
        alive = findViewById(R.id.tvAlive);
        hobbies = findViewById(R.id.tvHobbies);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new NetworkRequest(name, age, gender, alive, hobbies).execute(url);
    }

    private static class NetworkRequest extends AsyncTask<String, String, String> {

        TextView name, age, gender, alive, hobbies;
        NetworkRequest(TextView name, TextView age, TextView gender, TextView alive, TextView hobbies){

            this.name = name;
            this.age = age;
            this.gender = gender;
            this.alive = alive;
            this.hobbies = hobbies;
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                URL sourceUrl = new URL (strings[0]); //ctrl alt plus t trycatch
                HttpURLConnection  httpURLConnection = (HttpURLConnection) sourceUrl.openConnection(); //casting
                httpURLConnection.setRequestMethod("GET");

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())); //mubasa
                String line;
                StringBuilder result = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null){
                    result.append(line);
                }
                return result.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Data data = new Gson().fromJson(s, Data.class);
            name.setText("Name: " + data.profile.name);
            age.setText("age: " + data.profile.age);
            gender.setText("gender: " + data.profile.gender);
            alive.setText("alive: " + data.profile.alive);
            hobbies.setText("hobbies: " + Arrays.toString(data.profile.hobbies));



        }
    }
}
