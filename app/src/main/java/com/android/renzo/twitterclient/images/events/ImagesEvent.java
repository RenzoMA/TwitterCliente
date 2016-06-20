package com.android.renzo.twitterclient.images.events;

import com.android.renzo.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by HOME on 19/06/2016.
 */
public class ImagesEvent {
    private String error;
    private List<Image> images;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
