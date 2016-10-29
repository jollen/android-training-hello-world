package org.jollen.myandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer mMediaPlayer;
    MusicControl mMusicControl;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        mMusicControl = new MusicControl(this);
        mMediaPlayer = MediaPlayer.create(this, R.raw.test);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMusicControl;
    }

    void playMusic() {
        mMediaPlayer.start();
    }
}
