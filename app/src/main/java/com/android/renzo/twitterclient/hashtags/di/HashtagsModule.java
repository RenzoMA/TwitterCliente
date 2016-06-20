package com.android.renzo.twitterclient.hashtags.di;

import com.android.renzo.twitterclient.api.CustomTwitterApiCliente;
import com.android.renzo.twitterclient.entities.Hashtag;
import com.android.renzo.twitterclient.hashtags.HashtagsInteractor;
import com.android.renzo.twitterclient.hashtags.HashtagsInteractorImpl;
import com.android.renzo.twitterclient.hashtags.HashtagsPresenter;
import com.android.renzo.twitterclient.hashtags.HashtagsPresenterImpl;
import com.android.renzo.twitterclient.hashtags.HashtagsRepository;
import com.android.renzo.twitterclient.hashtags.HashtagsRepositoryImpl;
import com.android.renzo.twitterclient.hashtags.ui.HashtagsView;
import com.android.renzo.twitterclient.hashtags.ui.adapters.HashtagsAdapter;
import com.android.renzo.twitterclient.hashtags.ui.adapters.OnItemClickListener;
import com.android.renzo.twitterclient.lib.base.EventBus;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HOME on 19/06/2016.
 */
@Module
public class HashtagsModule {

    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    HashtagsAdapter providesAdapter(List<Hashtag> dataset, OnItemClickListener clickListener){
        return new HashtagsAdapter(dataset,clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> providesItemsList(){
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    HashtagsView provideHashtagsView() {
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsPresenter provideHashtagsPresenter(HashtagsView view, HashtagsInteractor interactor, EventBus eventBus) {
        return new HashtagsPresenterImpl(view, interactor, eventBus);
    }

    @Provides
    @Singleton
    HashtagsInteractor provideHashtagsInteractor(HashtagsRepository repository) {
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository provideHashtagsRepository(CustomTwitterApiCliente client, EventBus eventBus) {
        return new HashtagsRepositoryImpl(eventBus,client);
    }

    @Provides
    @Singleton
    CustomTwitterApiCliente provideTwitterApiClient(TwitterSession session) {
        return new CustomTwitterApiCliente(session);
    }

    @Provides
    @Singleton
    TwitterSession provideTwitterSession() {
        return Twitter.getSessionManager().getActiveSession();
    }
}
