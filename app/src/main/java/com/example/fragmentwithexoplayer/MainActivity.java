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
        FragmentManager fragmentManager = getSupportFragmentManager();
        ExoPlayerFragment exoPlayerFragment = new ExoPlayerFragment();
        fragmentManager.beginTransaction()
                .add(R.id.video_container, exoPlayerFragment)
                .commit();
    }
    {

    }
}
