package com.android.renzo.twitterclient.lib.base;

/**
 * Created by HOME on 19/06/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
