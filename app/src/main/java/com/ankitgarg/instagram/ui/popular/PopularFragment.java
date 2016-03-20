package com.ankitgarg.instagram.ui.popular;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ankitgarg.instagram.R;
import com.ankitgarg.instagram.api.InstagramApi;
import com.ankitgarg.instagram.model.Media;
import com.ankitgarg.instagram.model.Popular;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularFragment extends Fragment {
    private RecyclerView rvMedia;
    private PopularAdapter mAdapter;
    private ArrayList<Media> items;
    private SwipeRefreshLayout swipeContainer;
    public PopularFragment() {
        // Required empty public constructor
    }

    public static PopularFragment newInstance(String param1, String param2) {
        PopularFragment fragment = new PopularFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment when activity is re-initialized
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchPopularPhotos();
            }
        });
        rvMedia = (RecyclerView) view.findViewById(R.id.rvFeed);
        if(savedInstanceState == null){
            items = new ArrayList<Media>();
            fetchPopularPhotos();
        }
        mAdapter = new PopularAdapter(getContext(), items);
        rvMedia.setAdapter(mAdapter);
        rvMedia.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    public void fetchPopularPhotos() {
        Call<Popular> call = InstagramApi.getInstagramApiClient().getPopularMedia();
        call.enqueue(new Callback<Popular>() {
            @Override
            public void onResponse(Call<Popular> call, Response<Popular> response) {
                        List<Media> mediaList = response.body().getMediaList();
                        mAdapter.clear();
                        items.addAll(mediaList);
                        mAdapter.notifyDataSetChanged();
                        swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<Popular> call, Throwable t) {
                        Toast.makeText(getContext(), "Problem fetching", Toast.LENGTH_SHORT).show();
                        swipeContainer.setRefreshing(false);
            }
        });

    }
}
