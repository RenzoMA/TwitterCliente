package com.android.renzo.twitterclient.hashtags.di;

import com.android.renzo.twitterclient.hashtags.ui.HashtagsFragment;
import com.android.renzo.twitterclient.hashtags.ui.HashtagsView;
import com.android.renzo.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by HOME on 19/06/2016.
 */
@Singleton
@Component(modules = {HashtagsModule.class, LibsModule.class})
public interface HashtagsComponent {
    void inject(HashtagsFragment fragment);
}
