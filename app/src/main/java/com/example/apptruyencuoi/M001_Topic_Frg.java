package com.example.apptruyencuoi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class M001_Topic_Frg extends Fragment {

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.m001_topic_frg, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.m001_rv_topic);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new TopicAdapter(getContext(), loadDataToList()));

        return view;
    }

    private List<Topic> loadDataToList()  {
        List<Topic> listTopic = new ArrayList<>();

        try {
            String[] fileName = getContext().getAssets().list("photo");

            for(String item : fileName) {

                String topicName = item.substring(0, item.indexOf("."));

                Bitmap imageResource = BitmapFactory.decodeStream(getContext().getAssets().open("photo/" + item));

                listTopic.add(new Topic(topicName, imageResource));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listTopic;
    }
}
