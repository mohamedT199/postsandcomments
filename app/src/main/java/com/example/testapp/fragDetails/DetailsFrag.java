package com.example.testapp.fragDetails;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgs;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.adapters.DeatailsAdapterRec;
import com.example.testapp.localDatabase.MyDatabase;
import com.example.testapp.models.DetailsModel;

import java.util.List;

public class DetailsFrag extends Fragment {

    int i ;
    ViewModelDetails viewModelDetails ;
    DeatailsAdapterRec deatailsAdapterRec ;
    RecyclerView recyclerView ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details , container , false);
        i = DetailsFragArgs.fromBundle(getArguments()).getNumber();
        deatailsAdapterRec = new DeatailsAdapterRec();
        MyDatabase.getMyDatabase(getContext());
        viewModelDetails = new ViewModelProvider(requireActivity()).get(ViewModelDetails.class);
        viewModelDetails.getDataV(i);
        viewModelDetails.liveFin.observe(requireActivity(), new Observer<List<DetailsModel>>() {
            @Override
            public void onChanged(List<DetailsModel> list) {
                deatailsAdapterRec.setListDe(list);
            }
        });
        return v ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rec_details);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(deatailsAdapterRec);
    }

}
//DetailsFragArgs.fromBundle(getArguments()).getNumber();
