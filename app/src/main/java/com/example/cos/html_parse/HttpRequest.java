package com.example.cos.html_parse;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
    public void request(final String method, final String address, final Callback callback) {
        new AsyncTask<Void, Void, String>() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            protected String doInBackground(Void... params) {
                try {
                    URL url = new URL(address);
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod(method);

                    if (connection.getResponseCode() == 200) {
                        try(InputStream is = connection.getInputStream()){
                            BufferedReader r = new BufferedReader(new InputStreamReader(is));
                            StringBuilder str = new StringBuilder();
                            String line;
                            while ((line = r.readLine()) != null) {
                                str.append(line);
                            }
                            return str.toString();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callback.response(method, address, s);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
        }.execute();
    }

    public interface Callback {
        void response(String method, String address, String body);
    }
}
