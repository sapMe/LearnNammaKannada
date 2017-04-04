package com.usassociates.android.learnnammakannada;

/**
 * Created by Sapna Umesh on 27-03-2017.
 */

public class Word {

    private String mkannadaTranslation;
    private String mdefaultTransalation;
    private int mImageResourceId;

    public Word(String defaultTransalation, String kannadaTransalation){
        this.mkannadaTranslation = kannadaTransalation;
        this.mdefaultTransalation = defaultTransalation;
    }

    public Word(String defaultTransalation, String kannadaTransalation, int imageResourceId){
        this.mkannadaTranslation = kannadaTransalation;
        this.mdefaultTransalation = defaultTransalation;
        this.mImageResourceId = imageResourceId;
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

}
