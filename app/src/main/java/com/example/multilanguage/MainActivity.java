package com.example.multilanguage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button login;
    public SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String lang= Locale.getDefault().getISO3Language();
        if(lang=="fra"||lang=="spa")
        LocalHelper.setLocale(MainActivity.this , lang);
        else
            LocalHelper.setLocale(MainActivity.this , "eng");
        
        login = (Button) findViewById(R.id.btnlogin);

        sp = getSharedPreferences("login",MODE_PRIVATE);

//        sp.edit().putBoolean("logged",false).apply();

        if(sp.getBoolean("logged",false)){
            goToMainActivity();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
                sp.edit().putBoolean("logged",true).apply();
            }
        });
    }

    private void goToMainActivity() {
        Intent i = new Intent(this,SecondActivity.class);
        startActivityForResult(i,Activity.RESULT_OK);
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.d("msg: ", "Message");
        if(requestCode== Activity.RESULT_OK) {
            sp.edit().putBoolean("logged",false).apply();
            Intent myIntent = getIntent();
            startActivity(myIntent);
        }
    }
}
