package com.example.testapp.localDatabase;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.testapp.models.DetailsModel;
import com.example.testapp.models.PostModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    @TypeConverter
    public String toGsonPosts(List<PostModel> list1)
    {
        return new Gson().toJson(list1);
    }

    @TypeConverter
    public List<PostModel> fromGsonPosts(String s)
    {
        Type type = new TypeToken<ArrayList<PostModel>>(){}.getType();
        return  new Gson().fromJson(s , type);
    }
    @TypeConverter
    public String toGsonDetails(List<DetailsModel> list)
    {
        return  new Gson().toJson(list);
    }

    @TypeConverter
    public List<DetailsModel> fromGsonDetails(String s)
    {
        Type type = new TypeToken<ArrayList<DetailsModel>>(){}.getType();
        return new Gson().fromJson(s , type);
    }
}
