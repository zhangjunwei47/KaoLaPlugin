package com.didi.virtualapk.demo.player;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.didi.virtualapk.demo.R;
import com.kaolafm.opensdk.player.core.MediaPlayerService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author zhangchao on 2019-05-30.
 */

public class PlayerActivity extends AppCompatActivity {
    private MediaPlayerService.MediaPlayerServiceBind mediaPlayerServiceBind;

    @BindView(R.id.play_btn)
    Button playBtn;
    @BindView(R.id.init_btn)
    Button initBtn;
    @BindView(R.id.start_btn)
    Button startBtn;
    @BindView(R.id.pause_btn)
    Button pauseBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.pause_btn, R.id.init_btn, R.id.start_btn, R.id.play_btn})
    public void onViewClicked(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.play_btn:
                play();
                break;
            case R.id.pause_btn:
                pause();
                break;
            case R.id.init_btn:
                init();
                break;
            case R.id.start_btn:
                start();
                break;
            default:
                break;
        }
    }


    private void init() {
        Intent playServiceIntent = new Intent(PlayerActivity.this, MediaPlayerService.class);
        PlayerActivity.this.bindService(playServiceIntent,
                mPlayerServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mPlayerServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName,
                                       IBinder iBinder) {
            if (iBinder instanceof MediaPlayerService.MediaPlayerServiceBind) {
                mediaPlayerServiceBind = (MediaPlayerService.MediaPlayerServiceBind) iBinder;
            }

            try {
//                mediaPlayerServiceBind.addPlayerStateListener(mPlayerStateListener);
                //              mediaPlayerServiceBind.addDownloadProgressListener(onDownloadProgressListener);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            if (mediaPlayerServiceBind != null) {
                try {
                    mediaPlayerServiceBind.removePlayerStateListener();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                mediaPlayerServiceBind = null;
            }
        }
    };


    private void pause() {
        if (mediaPlayerServiceBind != null) {
            mediaPlayerServiceBind.pause();
        }
    }

    private void start() {
        if (mediaPlayerServiceBind != null) {
            mediaPlayerServiceBind.start("http://image.kaolafm.net/mz/aac_128/201905/a74c9293-494c-43d9-a94f-63b5024de485.aac?auth=860b3da564ac4ff0d0afa8718e0a7d64&deviceId=ba48c1d2ee524b0cf4fdc36c29b3f799&audioId=1000024670602&timestamp=1558939569033");
        }
    }

    private void play() {
        if (mediaPlayerServiceBind != null) {
            mediaPlayerServiceBind.play();
        }
    }
}
