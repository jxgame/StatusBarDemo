package com.example.macuser.statusbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.macuser.statusbardemo.activity.GlideTestActivity;
import com.example.macuser.statusbardemo.activity.PersonalActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.activity_main_status_demo)
    Button activityMainStatusDemo;
    @BindView(R.id.activity_main_glide_demo)
    Button activityMainGlideDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_main_status_demo)
    void jumpDemo(View v) {
        Intent intent = new Intent(MainActivity.this, PersonalActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.activity_main_glide_demo)
    void jumpDemo2() {
        Intent intent = new Intent(MainActivity.this, GlideTestActivity.class);
        startActivity(intent);
    }
}
