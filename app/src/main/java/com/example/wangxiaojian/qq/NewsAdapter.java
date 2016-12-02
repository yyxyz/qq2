package com.example.wangxiaojian.qq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Wangxiaojian on 2016/12/1.
 */

public class NewsAdapter extends ArrayAdapter<News>{
    private int resourceId;
    public NewsAdapter(Context context, int textViewResourceId, List<News> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View conwertView, ViewGroup parent){
        View view;
        ViewHolder viewHolder;
        News news=getItem(position);
        int newsImageId=news.getImageId();
        String newsTextName=news.getTextName();
        String newsTextNews=news.getTextNews();
        String newsTime=news.getTime();
        if(conwertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();
            viewHolder.mImage=(ImageView) view.findViewById(R.id.image_avatar);
            viewHolder.textName=(TextView) view.findViewById(R.id.text_name);
            viewHolder.textNews=(TextView) view.findViewById(R.id.text_news);
            viewHolder.textTime=(TextView) view.findViewById(R.id.text_time);
            view.setTag(viewHolder);
        }
        else
        {
            view=conwertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.mImage.setImageResource(newsImageId);
        viewHolder.textName.setText(newsTextName);
        viewHolder.textNews.setText(newsTextNews);
        viewHolder.textTime.setText(newsTime);
        return  view;
    }
    class ViewHolder{
        private ImageView mImage;
        private TextView textName;
        private TextView textNews;
        private TextView textTime;
    }
}
