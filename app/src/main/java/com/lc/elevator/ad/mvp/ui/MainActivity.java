package com.lc.elevator.ad.mvp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.source.VidSts;
import com.lc.elevator.ad.R;

class MainActivity extends BaseActivity{
    SurfaceView surfaceView;
    AliPlayer aliPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aliPlayer = AliPlayerFactory.createAliPlayer(getApplicationContext());

        VidSts aliyunVidSts = new VidSts();
        aliyunVidSts.setVid("111111");
        aliyunVidSts.setAccessKeyId("111111");
        aliyunVidSts.setAccessKeySecret("111111");
        aliyunVidSts.setSecurityToken("11111");
        aliyunVidSts.setRegion("11111");

        aliPlayer.setDataSource(aliyunVidSts);
        aliPlayer.prepare();

        surfaceView = findViewById(R.id.surface_view);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                aliPlayer.setDisplay(holder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
                aliPlayer.redraw();
            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
                aliPlayer.setDisplay(null);
            }
        });
    }
}
