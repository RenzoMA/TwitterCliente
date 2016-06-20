package com.android.renzo.twitterclient.images;

import com.android.renzo.twitterclient.images.events.ImagesEvent;

/**
 * Created by HOME on 19/06/2016.
 */
public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
