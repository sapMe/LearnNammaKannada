package com.usassociates.android.learnnammakannada;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sapna G on 11-04-2017.
 */

public class AnimalsFragment extends Fragment {
    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;


    public AnimalsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grid_list, container, false);
        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //Create an ArrayList of Word object
        final List<Word> words = new ArrayList<Word>();
        words.add(new Word("Dog", "Naayi",R.drawable.ani_dog,R.raw.dog));
        words.add(new Word("Cat", "Bekku",R.drawable.ani_cat,R.raw.cat));
        words.add(new Word("Monkey", "Manga",R.drawable.ani_monkey,R.raw.monkey));
        words.add(new Word("Pig", "Handi",R.drawable.ani_pig,R.raw.pig));
        words.add(new Word("Cow", "Hasu",R.drawable.ani_cow,R.raw.cow));
        words.add(new Word("Camel", "Onte",R.drawable.ani_camel,R.raw.camel));
        words.add(new Word("Tiger", "Huli",R.drawable.ani_tiger,R.raw.tiger));
        words.add(new Word("Lion", "Simha",R.drawable.ani_lion,R.raw.lion));
        words.add(new Word("Mouse", "Ili",R.drawable.ani_mouse,R.raw.mouse));
        words.add(new Word("Turtle", "Aame",R.drawable.ani_turtle,R.raw.turtle));
        words.add(new Word("Elephant", "Aane",R.drawable.ani_elephant,R.raw.elephant));
        words.add(new Word("Horse", "Kudure",R.drawable.ani_horse,R.raw.horse));
        words.add(new Word("Snake", "Haavu",R.drawable.ani_snake,R.raw.snake));
        words.add(new Word("Fish", "Meenu",R.drawable.ani_fish,R.raw.fish));
        words.add(new Word("Bear", "Karadi",R.drawable.ani_bear,R.raw.bear));
        words.add(new Word("Deer", "Jinke",R.drawable.ani_deer,R.raw.deer));
        words.add(new Word("Rabbit", "Mola",R.drawable.ani_rabbit,R.raw.rabbit));
        words.add(new Word("Crocodile", "Mosale",R.drawable.ani_croc,R.raw.crocs));
        words.add(new Word("Bird", "Hakki",R.drawable.ani_bird,R.raw.bird));
        words.add(new Word("Crab", "Edi",R.drawable.ani_crab,R.raw.crab));
        words.add(new Word("Owl", "Gube",R.drawable.ani_owl,R.raw.owl));
        words.add(new Word("Pigeon", "Paariwaala",R.drawable.ani_pigeon,R.raw.pigeon));
        words.add(new Word("Chicken", "Koli",R.drawable.ani_chicken,R.raw.chicken));
        words.add(new Word("Sheep", "Kuri",R.drawable.ani_goat,R.raw.sheep));
        words.add(new Word("Frog", "Kappe",R.drawable.ani_frog,R.raw.frog));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(),words,R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        GridView listView = (GridView) rootView.findViewById(R.id.gridList);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = mMediaPlayer.create(getActivity(), word.getAudioResorceId());

                    // Start the audio file
                    mMediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }


    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override

        public void onAudioFocusChange(int focusChange) {

            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.
                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }

        }
    };


    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    public void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();

    }

    /**
     * Clean up the media player by releasing its resources.
     */

    private void releaseMediaPlayer() {

        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {

            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
