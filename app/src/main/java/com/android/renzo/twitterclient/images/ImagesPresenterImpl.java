package com.android.renzo.twitterclient.images;

import com.android.renzo.twitterclient.images.events.ImagesEvent;
import com.android.renzo.twitterclient.images.ui.ImagesView;
import com.android.renzo.twitterclient.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by HOME on 19/06/2016.
 */
public class ImagesPresenterImpl implements ImagesPresenter {
    private EventBus eventBus;
    private ImagesView view;
    private ImagesInteractor interactor;

    public ImagesPresenterImpl(EventBus eventBus, ImagesView view, ImagesInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getImageTweets() {
        if(view != null){
            view.hideImages();
            view.showProgress();
        }
        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(ImagesEvent event) {
        String errorMsg = event.getError();
        if(view != null){
            view.showImages();
            view.hideProgress();
            if(errorMsg != null){
                view.onError(errorMsg);
            }else{
                view.setContent(event.getImages());
            }
        }

    }
}
