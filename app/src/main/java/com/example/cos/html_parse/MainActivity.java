package com.example.cos.html_parse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.etUrl)
    EditText etUrl;
    @Bind(R.id.tvHTML)
    TextView tvHTML;

    TextViewMapper tvMapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fabSend)
    public void onClickFabSend(View view) {
        if (!etUrl.getText().toString().equals("")) {
            tvMapper = new TextViewMapper(tvHTML);
            tvMapper.getRequest(etUrl.getText().toString());
        }
    }

}
