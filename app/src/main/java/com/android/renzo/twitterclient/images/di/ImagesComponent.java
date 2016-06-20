package com.android.renzo.twitterclient.images.di;

import com.android.renzo.twitterclient.images.ImagesPresenter;
import com.android.renzo.twitterclient.images.ui.ImagesFragment;
import com.android.renzo.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by HOME on 19/06/2016.
 */
@Singleton
@Component(modules = {ImagesModule.class, LibsModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    ImagesPresenter getPresenter();

}
