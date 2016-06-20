package com.android.renzo.twitterclient.lib.di;



import android.support.v4.app.Fragment;

import com.android.renzo.twitterclient.lib.GlidImageLoader;
import com.android.renzo.twitterclient.lib.GreenRobotEventBus;
import com.android.renzo.twitterclient.lib.base.EventBus;
import com.android.renzo.twitterclient.lib.base.ImageLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HOME on 19/06/2016.
 */
@Module
public class LibsModule {
    private Fragment fragment;

    public LibsModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(RequestManager requestManager){
        return new GlidImageLoader(requestManager);
    }

    @Provides
    @Singleton
    RequestManager providesRequestManager(Fragment fragment){
        return  Glide.with(fragment);
    }

    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }

    @Provides
    @Singleton
    EventBus providesEventBus(org.greenrobot.eventbus.EventBus eventBus){
        return new GreenRobotEventBus(eventBus);
    }

    @Provides
    @Singleton
    org.greenrobot.eventbus.EventBus providesLibraryEventBus(){
        return org.greenrobot.eventbus.EventBus.getDefault();
    }
}
