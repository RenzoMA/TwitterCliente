package com.android.renzo.twitterclient.images.di;

import com.android.renzo.twitterclient.api.CustomTwitterApiCliente;
import com.android.renzo.twitterclient.entities.Image;
import com.android.renzo.twitterclient.images.ImagesInteractor;
import com.android.renzo.twitterclient.images.ImagesInteractorImpl;
import com.android.renzo.twitterclient.images.ImagesPresenter;
import com.android.renzo.twitterclient.images.ImagesPresenterImpl;
import com.android.renzo.twitterclient.images.ImagesRepository;
import com.android.renzo.twitterclient.images.ImagesRepositoryImpl;
import com.android.renzo.twitterclient.images.ui.ImagesView;
import com.android.renzo.twitterclient.images.ui.adapters.ImagesAdapter;
import com.android.renzo.twitterclient.images.ui.adapters.OnItemClickListener;
import com.android.renzo.twitterclient.lib.base.EventBus;
import com.android.renzo.twitterclient.lib.base.ImageLoader;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HOME on 19/06/2016.
 */
@Module
public class ImagesModule {

    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener){
        return new ImagesAdapter(dataset,imageLoader,clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Image> providesItemsList(){
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    ImagesPresenter providesImagesPresenter(EventBus eventBus, ImagesView view, ImagesInteractor interactor){
        return new ImagesPresenterImpl(eventBus,view,interactor);
    }
    @Provides
    @Singleton
    ImagesView providesImagesView(){
        return this.view;
    }
    @Provides
    @Singleton
    ImagesInteractor providesImagesInteractor(ImagesRepository repository){
        return new ImagesInteractorImpl(repository);
    }
    @Provides
    @Singleton
    ImagesRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiCliente client){
        return new ImagesRepositoryImpl(eventBus,client);
    }

    @Provides
    @Singleton
    CustomTwitterApiCliente providesCustomTwitterApiClient(Session session){
        return new CustomTwitterApiCliente(session);
    }

    @Provides
    @Singleton
    Session providesTwitterSession(){
        return Twitter.getSessionManager().getActiveSession();
    }
}
