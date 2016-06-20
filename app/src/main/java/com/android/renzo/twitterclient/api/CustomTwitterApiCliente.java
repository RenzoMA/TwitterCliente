package com.android.renzo.twitterclient.api;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterApiClient;

/**
 * Created by HOME on 19/06/2016.
 */
public class CustomTwitterApiCliente extends TwitterApiClient {

    public CustomTwitterApiCliente(Session session) {
        super(session);
    }
    public TimelineService getTimelineService(){
        return getService(TimelineService.class);
    }
}
