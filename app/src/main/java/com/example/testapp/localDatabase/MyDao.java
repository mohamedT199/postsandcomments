package com.example.testapp.localDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.testapp.models.DetailsModel;
import com.example.testapp.models.PostModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface MyDao {

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    Completable setPostsRoom(List<PostModel> postModels);


    @Query("select * from PostModel")
    Single<List<PostModel>> getDataRoom();

    @Insert
    Completable setDataDetails(List<DetailsModel> detailsModels);

    @Query("select * from DetailsModel where postId = :what  ")
    Single<List<DetailsModel>> getDataComments(int what);

    @Query("delete from  DetailsModel ")
    Completable deletData();


}
