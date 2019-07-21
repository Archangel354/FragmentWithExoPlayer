package com.example.fragmentwithexoplayer;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    private Button btnExoplayer;

    @BindView(R.id.btnExoPlayer) Button BtnExoplayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnExoPlayer)

    public void sayHi(Button btnExoplayer){
        btnExoplayer.setText("Hello!");
        FragmentManager fragmentManager = getSupportFragmentManager();
        //Log.i("StepDetailActivity", "mDescription: " + mDescription + ".");

        //String step = getIntent().getStringExtra(EXTRA_STEP);
        //Bundle arguments = new Bundle();
        //arguments.putString(EXTRA_STEP, sDescription);
        //arguments.putString(EXTRA_VIDEO, sUrlString);
        ExoPlayerFragment exoPlayerFragment = new ExoPlayerFragment();
        //descriptionFragment.setArguments(arguments);
        fragmentManager.beginTransaction()
                .add(R.id.video_container, exoPlayerFragment)
                .commit();
    }
    {

    }
}
