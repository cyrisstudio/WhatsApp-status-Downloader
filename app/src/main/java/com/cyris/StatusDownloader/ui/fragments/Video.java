package com.cyris.StatusDownloader.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cyris.StatusDownloader.R;
import com.cyris.StatusDownloader.ui.adapters.videoAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Video#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Video extends Fragment {

    private View view;
    private RecyclerView videoRecyclerView;
    videoAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    public Video() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Video newInstance(String param1, String param2) {
        Video fragment = new Video();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_video, container, false);
        //swipeRefreshLayout = view.findViewById(R.id.swipeInVideo);



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        videoRecyclerView = view.findViewById(R.id.videoRecyclerView);
        videoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        videoRecyclerView.setItemAnimator(null);
        adapter = new videoAdapter(getContext());
        videoRecyclerView.setAdapter(adapter);
      /*  swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                swipeRefreshLayout.setRefreshing(false);
            }
        }); */

    }
}
