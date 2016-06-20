package com.android.renzo.twitterclient.hashtags;

import com.android.renzo.twitterclient.hashtags.events.HashtagsEvent;

/**
 * Created by HOME on 19/06/2016.
 */
public interface HashtagsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagsEvent event);
}
