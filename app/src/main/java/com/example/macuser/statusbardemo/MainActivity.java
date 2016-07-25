package com.example.macuser.statusbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.macuser.statusbardemo.activity.PersonalActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.activity_main_btn)
    Button activityMainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_main_btn)
    void jumpDemo(View v) {
        Intent intent = new Intent(MainActivity.this, PersonalActivity.class);
        startActivity(intent);
    }

}
