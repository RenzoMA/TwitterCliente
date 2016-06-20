package com.android.renzo.twitterclient.hashtags.events;

import com.android.renzo.twitterclient.entities.Hashtag;

import java.util.List;

/**
 * Created by HOME on 19/06/2016.
 */
public class HashtagsEvent {
    private String error;
    private List<Hashtag> hashtags;

    public List<Hashtag> getHashtags(){
        return hashtags;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
