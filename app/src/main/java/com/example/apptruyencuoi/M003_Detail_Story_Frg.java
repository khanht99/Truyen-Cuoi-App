package com.example.apptruyencuoi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class M003_Detail_Story_Frg extends Fragment {


    private String topicName;
    private TextView themeName;
    private Context mContext;
    private Story currentStory;
    private List<Story> storyList;
    private ImageView iv_back;



    public void setData(List<Story> storyList, Story currentStory) {
        this.topicName = currentStory.getTopicName();
        this.storyList = storyList;
        this.currentStory = currentStory;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.m003_detail_story_frg, container, false);

        themeName = view.findViewById(R.id.m002_tv_topicName);
        themeName.setText(topicName);

        iv_back = view.findViewById(R.id.m002_iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getContext()).backToM001Screen();
            }
        });

        ViewPager viewPager = view.findViewById(R.id.m003_vp_content);
        viewPager.setAdapter(new DetailStoryAdapter(getContext(), storyList));
        viewPager.setCurrentItem(storyList.indexOf(currentStory), true);

        return view;
    }




}
