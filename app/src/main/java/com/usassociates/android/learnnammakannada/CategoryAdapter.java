package com.usassociates.android.learnnammakannada;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Sapna G on 09-04-2017.
 */

    public class CategoryAdapter extends FragmentPagerAdapter {
    /**
     * Context of the app
     */
    private Context mContext;


    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_colors);
        } else if (position == 1) {
            return mContext.getString(R.string.category_names);
        } else if (position == 2) {
            return mContext.getString(R.string.category_numbers);
        } else if(position == 3){
            return  mContext.getString(R.string.category_fruits);
        } else if(position == 4){
            return mContext.getString(R.string.category_vegetables);
        } else if(position == 5){
            return mContext.getString(R.string.category_animals);
        }
        else if(position == 6){
            return mContext.getString(R.string.category_phrases);
        }
        else {
            return mContext.getString(R.string.category_days);
        }

    }


    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ColorsFragment();
        } else if (position == 1){
            return new NamesFragment();
        } else if(position == 2){
            return new NumbersFragment();
        } else if(position == 3){
            return new FruitsFragment();
        }else if(position == 4){
            return new VegetablesFragment();
        }else if(position == 5){
            return new AnimalsFragment();
        }else if(position == 6){
            return new PhrasesFragment();
        }else{
            return new DaysFragment();
        }
    }

    /**
     * Return the total number of pages.
     */

    @Override
    public int getCount() {
        return 8;
    }
}
