package com.usassociates.android.learnnammakannada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an ArrayList of Word object
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("Red", "Kempu",R.drawable.color_red));
        words.add(new Word("Blue", "Neeli",R.drawable.color_black));
        words.add(new Word("Green", "Hasiru",R.drawable.color_green));
        words.add(new Word("Yellow", "Haladi",R.drawable.color_mustard_yellow));
        words.add(new Word("Black", "Kappu",R.drawable.color_black));
        words.add(new Word("White", "Bili",R.drawable.color_white));
        words.add(new Word("Brown", "Kandu",R.drawable.color_brown));
        words.add(new Word("Orange", "Kesari",R.drawable.color_dusty_yellow));
        words.add(new Word("Gray", "Boodu",R.drawable.color_gray));



        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this,words,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
    }
}
