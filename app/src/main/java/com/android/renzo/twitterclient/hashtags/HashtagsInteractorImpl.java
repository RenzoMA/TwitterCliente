package com.android.renzo.twitterclient.hashtags;

/**
 * Created by HOME on 19/06/2016.
 */
public class HashtagsInteractorImpl implements  HashtagsInteractor {

    private HashtagsRepository repository;

    public HashtagsInteractorImpl(HashtagsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getHashtagItemsList() {
        repository.getHashtags();
    }
}
