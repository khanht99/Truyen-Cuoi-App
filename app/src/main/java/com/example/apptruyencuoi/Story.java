package com.example.apptruyencuoi;

public class Story {

    private final String storyName;
    private final String topicName;
    private final String content;

    public Story(String topicName, String storyName, String content) {
        this.topicName = topicName;
        this.storyName = storyName;
        this.content = content;
    }

    public String getStoryName() {
        return storyName;
    }

    public String getContent() {
        return content;
    }

    public String getTopicName() {
        return topicName;
    }
}
