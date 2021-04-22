package com.custom.moduleproject;

import android.os.Bundle;

import com.custom.moduleroute.RouteHome;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RouteHome.lauchHome();
    }

}