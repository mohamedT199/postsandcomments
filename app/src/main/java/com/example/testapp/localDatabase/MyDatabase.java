package com.example.testapp.localDatabase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.testapp.models.DetailsModel;
import com.example.testapp.models.PostModel;

@Database(entities = {PostModel.class , DetailsModel.class} , version =  11 , exportSchema = false)
@TypeConverters(value = Converter.class)
public abstract class MyDatabase extends RoomDatabase {
    private static MyDatabase myDatabase ;
     public abstract MyDao getDao();

      public synchronized  static void getMyDatabase(Context context)
      {
          if (myDatabase == null )
          {
              myDatabase = Room.
                      databaseBuilder(context , MyDatabase.class , "DatabasePosts" ).
                      fallbackToDestructiveMigration().
                      build();
          }



      }

      public static MyDatabase getInstanceDataMy()
      {
          return myDatabase ;
      }
}
