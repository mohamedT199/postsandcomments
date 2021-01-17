package com.example.testapp.fragDetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.testapp.models.DetailsModel;

import java.util.List;

public class ViewModelDetails extends ViewModel {

    RepoDe repoDe ;
    LiveData<List<DetailsModel>> liveFin ;

    public ViewModelDetails() {
        repoDe = new RepoDe();
        liveFin = repoDe.liveDe ;
    }

    public void getDataV(int id )
    {
        repoDe.getFinalData(id);
    }
}
