package com.example.apptruyencuoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showSplash();
    }

    public void showSplash() {

        getSupportFragmentManager().beginTransaction().replace(R.id.in_main, new M000_start_frg(), null).commit();
    }

    public void showFrg(Fragment frg) {

        getSupportFragmentManager().beginTransaction().replace(R.id.in_main, frg, null).commit();

    }

    public void gotoM001Screen() {

        getSupportFragmentManager().beginTransaction().replace(R.id.in_main, new M001_Topic_Frg(), null).commit();
    }

    public void backToM001Screen() {

        gotoM001Screen();

    }

    public void gotoM002Screen(String topicName)  {
        M002_Story_Frg m002 = new M002_Story_Frg();
        m002.setTopicName(topicName);
        showFrg(m002);
    }

    public void gotoM003Screen(List<Story> listStory, Story currentStory) {
        M003_Detail_Story_Frg m003 = new M003_Detail_Story_Frg();
        m003.setData(listStory, currentStory);

        showFrg(m003);

    }




}