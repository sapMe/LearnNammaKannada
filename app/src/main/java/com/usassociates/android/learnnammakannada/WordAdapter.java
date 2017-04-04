package com.usassociates.android.learnnammakannada;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sapna Umesh on 27-03-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Context context, List<Word> words,int colorResourceId){
        super(context,0,words);
        this.mColorResourceId = colorResourceId;
    }


    /**

     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the {@link AndroidFlavor} object located at this position in the list
        Word words = (Word) getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }
        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView kannadaText  = (TextView)listItemView.findViewById(R.id.kannada_text_view);
        // Get the miwok text from the current AndroidFlavor object and
        // set this text on the miwokTextView
        kannadaText.setText(words.getKannadaTransalation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultText =  (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default text from the current AndroidFlavor object and
        // set this text on the defalutTextView
        defaultText.setText(words.getDefaultTranslation());

        ImageView image  =(ImageView) listItemView.findViewById(R.id.image_view);

        if(words.getImageResourceId() != 0){
            image.setImageResource(words.getImageResourceId());
        }else{
            image.setVisibility(View.GONE);
        }

        View textContainerView   = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainerView.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews )
        // so that it can be shown in the ListView
        return listItemView;

    }
}
