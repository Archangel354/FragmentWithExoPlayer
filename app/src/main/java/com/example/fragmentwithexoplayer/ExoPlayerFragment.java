package com.example.fragmentwithexoplayer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * create an instance of this fragment.
 */
public class ExoPlayerFragment extends Fragment {
    @BindView(R.id.imgInstructionVideo)
    PlayerView mPlayerView;
    private SimpleExoPlayer mPlayer;
    private Unbinder unbinder;

    // URL of the video to stream
    public static String urlString = "https://d17h27t6h515a5.cloudfront.net/topher/2017/April/58ffd974_-intro-creampie/-intro-creampie.mp4";

    public ExoPlayerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String urlString = "https://d17h27t6h515a5.cloudfront.net/topher/2017/April/58ffd974_-intro-creampie/-intro-creampie.mp4";

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_exo_player, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        Uri anyUri = Uri.parse(urlString);
        Log.i("StepDetailActivity", "urlString: " + urlString + ".");
        if (urlString.isEmpty()) {
            mPlayerView.setVisibility(View.GONE);
            //imgNoVideo.setVisibility(View.VISIBLE);
        }
        else {
            // Initialize the player view
            mPlayerView.setVisibility(View.VISIBLE);
            mPlayer = ExoPlayerFactory.newSimpleInstance(getContext(), new DefaultTrackSelector());
            mPlayerView.setPlayer(mPlayer);
            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(
                    getContext(),
                    Util.getUserAgent(getContext(), getString(R.string.app_name)));
            ExtractorMediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(anyUri);
            mPlayer.prepare(mediaSource);
            mPlayer.setPlayWhenReady(true);
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

        // Release the player when it is not needed
        mPlayer.release();
    }
}
