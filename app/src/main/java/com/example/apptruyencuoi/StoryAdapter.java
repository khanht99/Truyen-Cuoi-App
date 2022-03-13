package com.example.apptruyencuoi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryHolder> {

    private final Context mContext;
    private final List<Story> storyList;


    public StoryAdapter(Context mContext, List<Story> storyList) {
        this.mContext = mContext;
        this.storyList = storyList;
    }

    @NonNull
    @Override
    public StoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_story_name, parent, false);

        return new StoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryHolder holder, int position) {

        Story itemStory = storyList.get(position);

        holder.storyName.setText(itemStory.getStoryName());
        holder.storyName.setTag(itemStory);


    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class StoryHolder extends RecyclerView.ViewHolder {

        TextView storyName;
        TextView content;

        public StoryHolder(@NonNull View itemView) {
            super(itemView);

            storyName = itemView.findViewById(R.id.m002_tv_storyName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)mContext).gotoM003Screen(storyList, (Story)storyName.getTag());
                }
            });
        }
    }
}
