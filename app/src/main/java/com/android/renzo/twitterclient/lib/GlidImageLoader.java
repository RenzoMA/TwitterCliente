package com.android.renzo.twitterclient.lib;

import android.widget.ImageView;

import com.android.renzo.twitterclient.lib.base.ImageLoader;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by HOME on 19/06/2016.
 */
public class GlidImageLoader implements ImageLoader {

    private RequestManager glideRequestManager;

    public GlidImageLoader(RequestManager glideRequestManager) {
        this.glideRequestManager = glideRequestManager;
    }

    @Override
    public void load(ImageView imageView, String URL) {
        glideRequestManager
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .override(600,400)
                .into(imageView);

    }
}
