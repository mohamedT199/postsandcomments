package com.example.testapp.fragPosts;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.testapp.localDatabase.MyDatabase;
import com.example.testapp.models.PostModel;
import com.example.testapp.retrofit.MyRetrofit;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyRepo {

    MutableLiveData<List<PostModel>> liveDataRepo = new MutableLiveData<>();



    public void getData()
    {
        MyRetrofit.getConnection().getPosts().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(new SingleObserver<List<PostModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<PostModel> postModels) {
                        Log.e("Tag13" , postModels.get(0).getBody());
                        liveDataRepo.postValue(postModels);
                        cashData(postModels);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("Tag13" , e.getLocalizedMessage());
                        getDataFromRoom();

                    }
                });
    }

    private void cashData(List<PostModel> list)
    {
        MyDatabase.getInstanceDataMy().getDao().setPostsRoom(list).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    private void getDataFromRoom()
    {
        MyDatabase.getInstanceDataMy().getDao().getDataRoom().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).
                subscribe(new SingleObserver<List<PostModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<PostModel> postModels) {
                        liveDataRepo.postValue(postModels);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
}
