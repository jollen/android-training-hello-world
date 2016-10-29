package org.jollen.myandroid;

import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.ServiceConnection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button btn;
    IMusicControl myMusicControl;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            // 1. Proxy object: instance of IMyAidlInterface
            // 2. Download casting
            // 3. Stub: asInterface()
            myMusicControl = IMusicControl.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.myButton);
        btn.setOnClickListener(this);

        startService(new Intent("org.jollen.myandroid.Start"));
    }

    @Override
    public void onClick(View view) {
        bindService(new Intent("org.jollen.myandroid.Start"), mConnection, BIND_AUTO_CREATE);

        // IPC method invoke
        try {
            myMusicControl.playMusic();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
