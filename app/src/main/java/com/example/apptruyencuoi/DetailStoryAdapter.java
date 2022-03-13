package com.example.apptruyencuoi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.lang.invoke.LambdaConversionException;
import java.util.List;

public class DetailStoryAdapter extends PagerAdapter {

    private final Context mContext;
    private final List<Story> storyList;

    public DetailStoryAdapter(Context mContext, List<Story> storyList) {
        this.mContext = mContext;
        this.storyList = storyList;
    }

    @Override
    public int getCount() {
        return storyList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.detail_story_item, container, false);

        TextView storyName = view.findViewById(R.id.m003_tv_story_name);
        TextView content = view.findViewById(R.id.m003_tv_content);

        Story itemStory = storyList.get(position);

        storyName.setText(itemStory.getStoryName());
        content.setText(itemStory.getContent());

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
