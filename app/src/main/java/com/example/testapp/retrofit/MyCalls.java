package com.example.testapp.retrofit;

import com.example.testapp.models.DetailsModel;
import com.example.testapp.models.PostModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyCalls {

    @GET("posts")
    Single<List<PostModel>> getPosts();

    @GET("comments")
    Single<List<DetailsModel>> getComments(@Query("postId") int id );


}
