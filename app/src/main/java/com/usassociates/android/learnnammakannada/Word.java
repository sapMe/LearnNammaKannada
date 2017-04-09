package com.usassociates.android.learnnammakannada;

/**
 * Created by Sapna G on 27-03-2017.
 */

public class Word {

    private String mKannadaTranslation;
    private String mDefaultTransalation;
    private int mImageResourceId;
    //Audio resource id to be loaded
    private int mAudioResorceId;

    public Word(String defaultTransalation, String kannadaTransalation,int audioResorceId){
        this.mKannadaTranslation = kannadaTransalation;
        this.mDefaultTransalation = defaultTransalation;
        this.mAudioResorceId = audioResorceId;
    }

    public Word(String defaultTransalation, String kannadaTransalation, int imageResourceId, int audioResorceId){
        this.mKannadaTranslation = kannadaTransalation;
        this.mDefaultTransalation = defaultTransalation;
        this.mImageResourceId = imageResourceId;
        this.mAudioResorceId = audioResorceId;
    }

    public String  getKannadaTransalation(){
        return mKannadaTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTransalation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public int getAudioResorceId(){
        return mAudioResorceId;
    }


    @Override
    public String toString() {
        return "Word{" +
                "mDefaulTranslation='" + mDefaultTransalation + '\'' +
                ", mKannadaTranslation='" + mKannadaTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResorceId=" + mAudioResorceId +
                '}';
    }

}
