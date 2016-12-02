package com.example.wangxiaojian.qq;

/**
 * Created by Wangxiaojian on 2016/12/1.
 */

public class News {
    private int imageId;
    private String textName;
    private String textNews;
    private String time;
    public News(int imageId,String textName,String textNews,String time){
        this.imageId=imageId;this.textName=textName;
        this.textNews=textNews;this.time=time;
    }
    public int getImageId(){
        return imageId;
    }
    public String getTextName(){
        return textName;
    }
    public String getTextNews(){
        return textNews;
    }
    public String getTime(){
        return time;
    }
}
