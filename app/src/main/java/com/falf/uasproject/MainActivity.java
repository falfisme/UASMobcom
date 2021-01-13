package com.falf.uasproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private EditText url_web;
    private Button button;
    private TextView textviewhtml;
    private String url ="http://www.google.co.in";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url_web = findViewById(R.id.url_web);
        button = findViewById(R.id.button);
        textviewhtml = findViewById(R.id.textviewhtml);

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                Document doc = null;
                try {
                    doc = (Document) Jsoup.connect("https://unj.ac.id/").get();
                    progressDialog.dismiss();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                textviewhtml.setText(doc.toString());
            }
        });

    }

//    public String getHtml(String url) throws IOException {
//        // Build and set timeout values for the request.
//        ProgressDialog pdLoading = new ProgressDialog(this);
//
//        URLConnection connection = (new URL(url)).openConnection();
//        connection.setConnectTimeout(5000);
//        connection.setReadTimeout(5000);
//        connection.connect();
//
//        pdLoading.setMessage("\tLoading...");
//        pdLoading.show();
//        // Read and store the result line by line then return the entire string.
//        InputStream in = connection.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//        StringBuilder html = new StringBuilder();
//        for (String line; (line = reader.readLine()) != null; ) {
//            html.append(line);
//        }
//        in.close();
//        pdLoading.dismiss();
//        return html.toString();
//    }


}

