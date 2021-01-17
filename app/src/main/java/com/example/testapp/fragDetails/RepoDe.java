package com.example.testapp.fragDetails;

import androidx.lifecycle.MutableLiveData;

import com.example.testapp.localDatabase.MyDatabase;
import com.example.testapp.models.DetailsModel;
import com.example.testapp.retrofit.MyRetrofit;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RepoDe {

    MutableLiveData<List<DetailsModel>> liveDe = new MutableLiveData<>();


    public void getFinalData(int id )
    {
        MyRetrofit.getConnection().getComments(id).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new SingleObserver<List<DetailsModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<DetailsModel> list) {
                        liveDe.postValue(list);
                        deleteDataDB();
                        cachDet(list);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getDet(id);
                    }
                });
    }



    private void getDet(int id )
    {
        MyDatabase.getInstanceDataMy().getDao().getDataComments(id).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new SingleObserver<List<DetailsModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<DetailsModel> list) {
                        liveDe.postValue(list);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    private void deleteDataDB()
    {
        MyDatabase.getInstanceDataMy().getDao().deletData().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
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
    private void cachDet(List<DetailsModel> detailsModelList)
    {
        MyDatabase.getInstanceDataMy().getDao().setDataDetails(detailsModelList).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
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
}
