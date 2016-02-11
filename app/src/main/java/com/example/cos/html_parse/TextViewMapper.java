package com.example.cos.html_parse;

import android.widget.TextView;

public class TextViewMapper implements HttpRequest.Callback{
    private TextView text;

    public TextViewMapper(TextView text) {
        this.text = text;
    }

    public void getRequest(String address) {
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.request("GET", address, this);
    }

    @Override
    public void response(String method, String address, String body) {
        text.setText(body);
    }
}
