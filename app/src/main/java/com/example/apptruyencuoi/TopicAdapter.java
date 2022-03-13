package com.example.apptruyencuoi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicHolder> {

    private final Context mContext;

    private final List<Topic> listTopic;

    public TopicAdapter(Context context, List<Topic> listTopic) {
        this.mContext = context;
        this.listTopic = listTopic;
    }

    @NonNull
    @Override
    public TopicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_topic, parent, false);

        return new TopicHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicHolder holder, int position) {

        Topic topicItem = listTopic.get(position);

        holder.imageView.setImageBitmap(topicItem.getImageResource());
        holder.textView.setText(topicItem.getTopicName());
        holder.textView.setTag(topicItem);

    }

    @Override
    public int getItemCount() {
        return listTopic.size();
    }

    public class TopicHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public TopicHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.m001_iv_itemTopic);
            textView = itemView.findViewById(R.id.m001_tv_itemTopic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ((MainActivity)mContext).gotoM002Screen((String) textView.getText());

                }
            });
        }
    }
}
