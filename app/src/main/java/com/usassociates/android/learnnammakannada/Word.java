package com.usassociates.android.learnnammakannada;

/**
 * Created by Sapna Umesh on 27-03-2017.
 */

public class Word {

    private String mkannadaTranslation;
    private String mdefaultTransalation;
    private int mImageResourceId;
    //Audio resource id to be loaded
    private int mAudioResorceId;

    public Word(String defaultTransalation, String kannadaTransalation,int audioResorceId){
        this.mkannadaTranslation = kannadaTransalation;
        this.mdefaultTransalation = defaultTransalation;
        this.mAudioResorceId = audioResorceId;
    }

    public Word(String defaultTransalation, String kannadaTransalation, int imageResourceId, int audioResorceId){
        this.mkannadaTranslation = kannadaTransalation;
        this.mdefaultTransalation = defaultTransalation;
        this.mImageResourceId = imageResourceId;
        this.mAudioResorceId = audioResorceId;
    }

    public String  getKannadaTransalation(){
        return mkannadaTranslation;
    }

    public String getDefaultTranslation(){
        return mdefaultTransalation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public int getAudioResorceId(){
        return mAudioResorceId;
    }

}
