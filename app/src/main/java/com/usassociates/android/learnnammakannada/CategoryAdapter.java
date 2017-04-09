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
            return mContext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.category_names);
        } else if (position == 2) {
            return mContext.getString(R.string.category_colors);
        } else {
            return mContext.getString(R.string.category_phrases);
        }

    }


    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1){
            return new NamesFragment();
        } else if(position == 2){
            return new ColorsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    /**
     * Return the total number of pages.
     */

    @Override
    public int getCount() {
        return 4;
    }
}
