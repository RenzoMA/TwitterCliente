package com.android.renzo.twitterclient.entities;

/**
 * Created by HOME on 19/06/2016.
 */
public class Image {
    private String id;
    private String imageURL;
    private String tweetText;
    private int favoriteCount;
    private final static String BASE_TWEET_URL = "https://twitter.com/null/status/";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public static String getBaseTweetUrl() {
        return BASE_TWEET_URL;
    }

    public String getTweetURl(){
        return getBaseTweetUrl()+ this.id;
    }
}