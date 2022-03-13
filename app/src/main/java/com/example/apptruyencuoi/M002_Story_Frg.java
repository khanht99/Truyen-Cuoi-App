package com.example.apptruyencuoi;

import android.os.Bundle;
import android.telecom.TelecomManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class M002_Story_Frg extends Fragment {

    private String topicName;
    private TextView themeName;
    private ImageView iv_back;


    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.m002_story_frg, container, false);

        themeName = view.findViewById(R.id.m002_tv_topicName);
        themeName.setText(topicName);

        iv_back = view.findViewById(R.id.m002_iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getContext()).backToM001Screen();
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.m002_rv_storyItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        try {
            recyclerView.setAdapter(new StoryAdapter(getContext(), loadListStoryName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }

    public List<Story> loadListStoryName() throws IOException {
        List<Story> listStory = new ArrayList<>();
        listStory = new ArrayList<>();
        InputStream in = getContext().getAssets().open("story/" + topicName + ".txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        String str;
        String name = null;
        StringBuilder content = new StringBuilder();
        listStory = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            if (str.isEmpty()) continue;
            if (name == null) {
                name = str;
            } else if (!str.startsWith("','0');")) {
                content.append(str).append("\n");
            } else {
                listStory.add(new Story(topicName, name, content.toString()));
                name = null;
                content = new StringBuilder();
            }
        }
        br.close();


        return listStory;
    }


}
