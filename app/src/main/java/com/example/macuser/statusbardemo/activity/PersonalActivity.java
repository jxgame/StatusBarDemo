package com.example.macuser.statusbardemo.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.macuser.statusbardemo.R;

/**
 * Created by macuser on 16/7/22.
 **/
public class PersonalActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_personal);
    }
}