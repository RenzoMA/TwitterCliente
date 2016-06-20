package com.android.renzo.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

;
import com.android.renzo.twitterclient.hashtags.di.DaggerHashtagsComponent;
import com.android.renzo.twitterclient.hashtags.di.HashtagsComponent;
import com.android.renzo.twitterclient.hashtags.di.HashtagsModule;
import com.android.renzo.twitterclient.hashtags.ui.HashtagsView;
import com.android.renzo.twitterclient.images.di.DaggerImagesComponent;
import com.android.renzo.twitterclient.images.di.ImagesComponent;
import com.android.renzo.twitterclient.images.di.ImagesModule;
import com.android.renzo.twitterclient.images.ui.ImagesView;
import com.android.renzo.twitterclient.images.ui.adapters.OnItemClickListener;
import com.android.renzo.twitterclient.lib.di.LibsModule;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by HOME on 14/06/2016.
 */
public class TwitterClientApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();

    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY, BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view,clickListener))
                .build();
    }

   public HashtagsComponent getHashtagsComponent(HashtagsView view, com.android.renzo.twitterclient.hashtags.ui.adapters.OnItemClickListener clickListener){
        return DaggerHashtagsComponent
                .builder()
                .libsModule(new LibsModule(null))
                .hashtagsModule(new HashtagsModule(view,clickListener))
                .build();

    }
}
