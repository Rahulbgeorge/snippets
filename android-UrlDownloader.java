package com.example.rahulstudy.beacontagtest;

/**
 * Created by Rahul  on 03-05-2018.
 * 
 * REQUIRED IN MANIFEST
 *  androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation 'com.squareup.okhttp3:okhttp:3.6.0'
    
    
    THE BELOW FUNCTION IS EXPECTED TO BE CALLED FROM A ASYNC CLASS AND EXECUTED IN ORDER TO RECIEVE THE DATA FROM
    A URL HTTP OR HTTPS WITH OR WITHOUT A HEADER KEY
 */


import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class DownloadUrl {

    public String readUrl(String myUrl) throws IOException {
        String result = "";
        String ApiKey = "PASTE_YOUR_KEY_OVER_HERE";
        String data = "";
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;

            URL BeaconEndPoint = null;
            HttpsURLConnection myconnection = null;
            try {
                BeaconEndPoint = new URL(myUrl);
                myconnection = (HttpsURLConnection) BeaconEndPoint.openConnection();
                //COMMENT THE BELOW LINE IF YOU DONT HAVE A HEADER NAME AND VALUE
                myconnection.setRequestProperty("HEADER_NAME", "HEADER VALUE");

                if (myconnection.getResponseCode() == 200) {
                    //successfully recieved response
                    InputStream response = myconnection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(response));
                    result = br.readLine();
                    // InputStreamReader responseBody=new InputStreamReader(response,"utf-8");
                    //result=responseBody.toString();
                    myconnection.disconnect();
                }



            } catch (Exception e) {
                result = "exception";
                Log.i("rest ", "exception ");
            }
            // All your networking logic
            // should be here


            Log.i("Rest", result);

            return result;
        }
        }

