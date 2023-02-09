/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jio.sample;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import com.jio.sample.util.VideoPlayer;

public class PlayVideoActivity extends BaseActivity{

  VideoPlayer videoPlayer;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player_video);
    videoPlayer = new VideoPlayer(this, findViewById(R.id.videoView));
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    // VideoView videoView = findViewById(R.id.videoView);
    // MediaController mediaController = new MediaController(this);
    // mediaController.setAnchorView(videoView);
    // videoView.setMediaController(mediaController);
    // videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
    //     R.raw.big_buck_bunny));
    // videoView.start();
    videoPlayer.start();
  }

  @Override
  protected void onStop() {
    super.onStop();
    videoPlayer.stop();
  }
}
