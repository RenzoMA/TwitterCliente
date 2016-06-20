package com.android.renzo.twitterclient.hashtags.ui;

import com.android.renzo.twitterclient.entities.Hashtag;

import java.util.List;

/**
 * Created by HOME on 19/06/2016.
 */
public interface HashtagsView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void onHashtagsError(String error);
    void setHashtags(List<Hashtag> items);
}
