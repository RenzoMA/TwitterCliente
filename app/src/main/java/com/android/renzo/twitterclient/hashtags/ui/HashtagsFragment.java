package com.android.renzo.twitterclient.hashtags.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.android.renzo.twitterclient.R;
import com.android.renzo.twitterclient.TwitterClientApp;
import com.android.renzo.twitterclient.entities.Hashtag;
import com.android.renzo.twitterclient.hashtags.HashtagsPresenter;
import com.android.renzo.twitterclient.hashtags.di.HashtagsComponent;
import com.android.renzo.twitterclient.hashtags.ui.adapters.HashtagsAdapter;
import com.android.renzo.twitterclient.hashtags.ui.adapters.OnItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HashtagsFragment extends Fragment implements HashtagsView, OnItemClickListener {


    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.container)
    FrameLayout container;

    @Inject
    HashtagsAdapter adapter;

    @Inject
    HashtagsPresenter presenter;

    public HashtagsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
        setupInjection();
        setupRecyclerView();
        presenter.getHashtagTweets();
        return view;
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setupInjection() {
        TwitterClientApp app = (TwitterClientApp)getActivity().getApplication();
        HashtagsComponent hashtagsComponent = app.getHashtagsComponent(this,this);
        hashtagsComponent.inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showList() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideList() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onHashtagsError(String error) {
        Snackbar.make(container, error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setHashtags(List<Hashtag> items) {
        adapter.setItems(items);
    }

    @Override
    public void onItemClick(Hashtag tweet) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweet.getTweetUrl()));
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
