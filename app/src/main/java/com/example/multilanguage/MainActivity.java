package com.example.multilanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String lang= Locale.getDefault().getISO3Language();

        if(lang=="fra"||lang=="spa")
        LocalHelper.setLocale(MainActivity.this , lang);

        else
            LocalHelper.setLocale(MainActivity.this , "eng");

        Toast.makeText(this, lang, Toast.LENGTH_SHORT).show();
    }
}
