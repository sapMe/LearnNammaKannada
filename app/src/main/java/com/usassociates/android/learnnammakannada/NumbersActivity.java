package com.usassociates.android.learnnammakannada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an ArrayList of Word object
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("One", "Ondu",R.drawable.number_one));
        words.add(new Word("Two", "Eradu",R.drawable.number_two));
        words.add(new Word("Three", "Mooru",R.drawable.number_three));
        words.add(new Word("Four", "Naalakku",R.drawable.number_four));
        words.add(new Word("Five", "Eidu",R.drawable.number_five));
        words.add(new Word("Six", "Aaru",R.drawable.number_six));
        words.add(new Word("Seven", "Elu",R.drawable.number_seven));
        words.add(new Word("Eight", "Entu",R.drawable.number_eight));
        words.add(new Word("Nine", "Ombattu",R.drawable.number_nine));
        words.add(new Word("Ten", "Hattu",R.drawable.number_ten));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

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
