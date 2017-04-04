package com.usassociates.android.learnnammakannada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an ArrayList of Word object
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("Father", "Appa",R.drawable.family_father));
        words.add(new Word("Mother", "Amma",R.drawable.family_mother));
        words.add(new Word("Older Brother", "Anna",R.drawable.family_older_brother));
        words.add(new Word("Younger Brother", "Tamma",R.drawable.family_younger_brother));
        words.add(new Word("Older Sister", "Akka",R.drawable.family_older_sister));
        words.add(new Word("Younger Sister", "Tangi",R.drawable.family_younger_sister));
        words.add(new Word("Grandmother", "Ajji",R.drawable.family_grandmother));
        words.add(new Word("GrandFather", "Taata",R.drawable.family_grandfather));
        words.add(new Word("Daughter", "Magalu",R.drawable.family_daughter));
        words.add(new Word("Son", "Maga",R.drawable.family_son));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this,words,R.color.category_names);

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
