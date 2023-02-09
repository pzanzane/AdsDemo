package com.jio.sample;

import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jio.sample.util.Dialog;
import com.jio.sample.util.VideoPlayer;
import java.util.function.Function;

public class BaseActivity extends AppCompatActivity {
    protected VideoPlayer videoPlayer = null;
    protected Handler handler = null;

    final protected Dialog dialog = new Dialog(BaseActivity.this);
    final long SHOW_AD_AFTER_MS = 5000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
    }

    protected void startVideo(VideoView videoView) {
        videoPlayer = new VideoPlayer(this, videoView);
        videoPlayer.start();
    }

    protected void resumeVideo() {
        videoPlayer.start();
    }

    protected void pauseVideo() {
        videoPlayer.pause();
    }

    protected void stopVideo() {
        videoPlayer.stop();
    }

    protected void delayed(Runnable runnable) {
        handler.postDelayed(runnable, SHOW_AD_AFTER_MS);
    }
}
