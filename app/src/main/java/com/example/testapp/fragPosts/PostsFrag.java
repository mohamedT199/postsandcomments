package com.example.testapp.fragPosts;

import android.app.Notification;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp.R;
import com.example.testapp.adapters.PostsRecAdapter;
import com.example.testapp.fragDetails.DetailsFragDirections;
import com.example.testapp.localDatabase.MyDatabase;
import com.example.testapp.models.PostModel;

import java.util.ArrayList;
import java.util.List;


public class PostsFrag extends Fragment {

    RecyclerView rec ;
    PostsRecAdapter postsRecAdapter ;
    MyViewModel myViewModel ;
    List<PostModel> listt ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MyDatabase.getMyDatabase(getContext());
        listt = new ArrayList<>();
        postsRecAdapter = new PostsRecAdapter();
        myViewModel = new  ViewModelProvider(requireActivity()).get(MyViewModel.class);
        myViewModel.getFinalDat();
        myViewModel.live.observe(requireActivity(), new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postsRecAdapter.setList(postModels);
                listt = postModels ;

            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view , savedInstanceState);
        intiView(view);
        rec.setAdapter(postsRecAdapter);
        postsRecAdapter.setOnclickIteem(new PostsRecAdapter.onClicks() {
            @Override
            public void ocCllick(int position) {
                PostsFragDirections.ActionGoToFragDetails action =
                        PostsFragDirections.actionGoToFragDetails();
                action.setNumber(listt.get(position).getId());
                Navigation.findNavController(view).
                        navigate(action);
            }
        });
    }

    public void intiView(View view)
    {
        rec = view.findViewById(R.id.rec_posts);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}