package com.hxd.hoxuandieu.asynctalkthuchanh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Button btnOKE;
    EditText edtHttp;
    ListView lstVRSS;

    public void AnhXa() {
        btnOKE = (Button) findViewById(R.id.btnGo);
        edtHttp = (EditText) findViewById(R.id.edtHTTP);
        lstVRSS = (ListView) findViewById(R.id.lstvRss);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

    }
}
