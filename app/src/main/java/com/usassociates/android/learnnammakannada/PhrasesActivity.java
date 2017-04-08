package com.usassociates.android.learnnammakannada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an ArrayList of Word object
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "Ellige hoguttiddira?",R.raw.whr_r_u_goin));
        words.add(new Word("What is your name?", "Nimma hesarenu?",R.raw.ur_name));
        words.add(new Word("My name is...", "Nanna hesaru...",R.raw.my_name));
        words.add(new Word("How are you?", "Hegiddira?",R.raw.hw_r_u));
        words.add(new Word("Are you coming?", "Neevu baruttira?",R.raw.r_u_coming));
        words.add(new Word("Yes, I’m coming.", "Howdu baruttini",R.raw.s_coming));
        words.add(new Word("I’m coming.", "Baruttini.",R.raw.coming));
        words.add(new Word("Let’s go.", "Hogona",R.raw.lets_go));
        words.add(new Word("Come here.", "Illi banni",R.raw.come_here));
        words.add(new Word("Come.", "Banni",R.raw.come));
        words.add(new Word("Go.", "Hogi",R.raw.go));
        words.add(new Word("Who are you?.", "Neevu yaaru?",R.raw.who_r_u));



        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this,words,R.color.category_phrases);

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
