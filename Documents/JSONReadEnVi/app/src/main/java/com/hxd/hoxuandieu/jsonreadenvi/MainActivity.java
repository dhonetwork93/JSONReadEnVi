package com.hxd.hoxuandieu.jsonreadenvi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    Button btnE,btnV;
    TextView txtHT;
    String lan = "en";

    public void AnhXa() {
        btnE = (Button) findViewById(R.id.btnEn);
        btnV = (Button) findViewById(R.id.btnVi);
        txtHT = (TextView) findViewById(R.id.txtHienThi);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private class ReadJSON extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                object = object.getJSONObject("language");
                object = object.getJSONObject(lan);
                String name = object.getString("name");
                String address = object.getString("address");
                String course1 = object.getString("course1");
                String course2 = object.getString("course2");
                String course3 = object.getString("course3");
                txtHT.setText(
                        name + "\n" +
                        address + "\n" +
                        course1 + "\n" +
                        course2 + "\n" +
                        course3 

                );

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    private static String docNoiDung_Tu_URL(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}
