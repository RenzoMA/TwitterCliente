package com.android.renzo.twitterclient.images.ui;

import com.android.renzo.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by HOME on 19/06/2016.
 */
public interface ImagesView {
    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> items);
}
