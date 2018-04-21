package com.rdevlab.tupresidentesoundboard.model;

/**
 * @author rms
 * @date 25/02/2018
 */

public class Phrase {

    private String mPhraseName;
    private int mAudioResourceId;
    private int mImageResourceId;

    public Phrase(String phraseName, int audioResourceId, int imageResourceId) {
        mPhraseName = phraseName;
        mAudioResourceId = audioResourceId;
        mImageResourceId = imageResourceId;
    }

    public String getPhraseName() {
        return mPhraseName;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImageResourceId() {
        return mImageResourceId != -1;
    }
}
