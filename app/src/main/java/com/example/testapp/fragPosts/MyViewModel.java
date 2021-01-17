package com.example.testapp.fragPosts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.testapp.models.PostModel;

import java.util.List;

public class MyViewModel extends ViewModel {

    LiveData<List<PostModel>> live ;
    MyRepo repo ;

    public MyViewModel() {
        repo = new MyRepo();
        live = repo.liveDataRepo ;
    }

    public void getFinalDat() {
        repo.getData();
    }
}
