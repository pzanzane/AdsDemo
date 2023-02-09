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
package com.jio.sample.util;

import android.content.Context;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;
import com.jio.sample.R;

public class VideoPlayer {

 private VideoView videoView;

 public VideoPlayer(Context context, VideoView videoView) {
  this.videoView = videoView;
  MediaController mediaController = new MediaController(context);
  mediaController.setAnchorView(videoView);
  videoView.setMediaController(mediaController);
  videoView.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" +
      R.raw.big_buck_bunny));
 }

 public void start() {
  videoView.start();
 }

 public void stop() {
  videoView.stopPlayback();
 }

 public void pause() {
  videoView.pause();
 }

 public void resume() {
  videoView.resume();
 }
}
