package com.example.infenocoder.vigilanteuphoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void buttonOnClick (View v) {
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("http://http://127.0.0.1:5567/handle_data?heading=Vigilant-Euphoria-App&message=Test");

            urlConnection = (HttpURLConnection) url
                    .openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                System.out.print(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
