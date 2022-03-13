package com.example.apptruyencuoi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Topic {

    private final String topicName;

    private final Bitmap imageResource;

    public Topic(String topicName, Bitmap imageResource) {
        this.topicName = topicName;
        this.imageResource = imageResource;
    }

    public String getTopicName() {
        return topicName;
    }

    public Bitmap getImageResource() {
        return imageResource;
    }
}
