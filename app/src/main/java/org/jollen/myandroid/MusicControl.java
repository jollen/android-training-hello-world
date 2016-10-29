package org.jollen.myandroid;

import android.os.RemoteException;
import android.content.Context;

public class MusicControl implements IMusicControl.Stub {

    MyService mContext;

    public MusicControl(Context context) {
        mContext = (MyService) context;
    }

    @Override
    public void playMusic() throws RemoteException {
        mContext.playMusic();
    }

    @Override
    public void stopMusic() throws RemoteException {

    }
}
