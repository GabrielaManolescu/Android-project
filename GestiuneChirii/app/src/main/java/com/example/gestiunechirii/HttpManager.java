package com.example.gestiunechirii;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpManager extends AsyncTask<String, Void, String>  {
    //clase pt conexiunea la retea
   protected URL url;
    private HttpURLConnection connection;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

   // private final String urlAddress;

//    public HttpManager(String urlAddress) {
//        this.urlAddress = urlAddress;
//    }


//    protected String doInBackground() {
//        StringBuilder result = new StringBuilder();
//        try {
//            url = new URL(urlAddress);
//            connection = (HttpURLConnection) url.openConnection();
//            inputStream = connection.getInputStream();
//            inputStreamReader = new InputStreamReader(inputStream);
//            bufferedReader = new BufferedReader(inputStreamReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                result.append(line);
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//            //return result.toString();
//        } finally {
//            if(bufferedReader!=null){
//            try {
//                bufferedReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }}
//            if(inputStreamReader!=null){
//            try {
//                inputStreamReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }}
//            if(inputStream!=null){
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }}
//            if(inputStream!=null){
//            connection.disconnect();
//            }
//        }return result.toString();
//    }

    @Override
    protected String doInBackground(String... s) {
        StringBuilder result = new StringBuilder();
        try {
            url = new URL(s[0]);
            connection = (HttpURLConnection) url.openConnection();
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

            //return result.toString();
        } finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}
            if(inputStreamReader!=null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}
            if(inputStream!=null){
                connection.disconnect();
            }
        }return result.toString();
    }
}
