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
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class WordsFragment extends Fragment {
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;


    public WordsFragment() {
        // Required empty public constructor
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView  =  inflater.inflate(R.layout.grid_list, container, false);


        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //Create an ArrayList of words
        final List<Word> words = new ArrayList<Word>();

        words.add(new Word("Come", "Banni",R.raw.come));
        words.add(new Word("Go", "Hogi",R.raw.go));
        words.add(new Word("Door", "Baagilu",R.raw.door));
        words.add(new Word("Evening", "Sanje",R.raw.evening));
        words.add(new Word("Fast", "Bega",R.raw.fast));
        words.add(new Word("Give", "Kodi",R.raw.give));
        words.add(new Word("He", "Avanu",R.raw.he));
        words.add(new Word("Here", "Illi",R.raw.here));
        words.add(new Word("House", "Mane",R.raw.house));
        words.add(new Word("How", "Hege",R.raw.how));
        words.add(new Word("I", "Naanu",R.raw.i));
        words.add(new Word("Inside", "Olage",R.raw.inside));
        words.add(new Word("It", "Adu",R.raw.it));
        words.add(new Word("Like", "Ishta",R.raw.like));
        words.add(new Word("Listen", "Keli",R.raw.listen));
        words.add(new Word("Name", "Hesaru",R.raw.name));
        words.add(new Word("No", "Illa",R.raw.no));
        words.add(new Word("Now", "Eega",R.raw.now));
        words.add(new Word("Ours", "Namma",R.raw.ours));
        words.add(new Word("Outside", "Horage",R.raw.outside));
        words.add(new Word("Please", "Dayavittu",R.raw.please));
        words.add(new Word("She", "Avalu",R.raw.she));
        words.add(new Word("Slow", "Nidhaana",R.raw.slow));
        words.add(new Word("Sorry", "Kshamisi",R.raw.sorry));
        words.add(new Word("Stop", "Nillisi",R.raw.stop));
        words.add(new Word("Take", "Tegedu kolli",R.raw.take));
        words.add(new Word("Tell", "Heli",R.raw.tell));
        words.add(new Word("That", "Adu",R.raw.that));
        words.add(new Word("There", "Alli",R.raw.there));
        words.add(new Word("This", "Idu",R.raw.thiss));
        words.add(new Word("Tomorrow", "Naale",R.raw.tomorrow));
        words.add(new Word("Water", "Neeru",R.raw.water));
        words.add(new Word("What", "Enu",R.raw.what));
        words.add(new Word("When", "Yaavaaga",R.raw.when));
        words.add(new Word("Where", "Elli",R.raw.where));
        words.add(new Word("Who", "Yaaru",R.raw.who));
        words.add(new Word("Why", "Yaake",R.raw.why));
        words.add(new Word("Yes", "Houdu",R.raw.yes));
        words.add(new Word("You", "Neenu",R.raw.you));
        words.add(new Word("Your", "Ninna",R.raw.your));




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


    @Override
    public void onStop() {
        super.onStop();
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
