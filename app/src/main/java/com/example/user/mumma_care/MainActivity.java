package com.example.user.mumma_care;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends Activity {

    protected static final int PLAY = 0x101;
    protected static final int STOP = 0x102;
    protected static final int PAUSE = 0x103;
    int State;
    private String current;

    private String path ;
    private VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        path = "android.resource://com.example.user.mumma_care/" + R.raw.entrancevideo;
        mVideoView = (VideoView) findViewById(R.id.entrance_video);
        if (path == null || path.length() == 0) {
            Toast.makeText(MainActivity.this, "File URL/path is empty",
                    Toast.LENGTH_LONG).show();

        } else {
            // If the path has not changed, just start the media player
            if (path.equals(current) && mVideoView != null) {
                mVideoView.start();
                mVideoView.requestFocus();
                return;
            }
            current = path;
            mVideoView.setVideoPath(path);
            mVideoView.start();
            mVideoView.requestFocus();
        }
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer arg0) {
                Intent in = new Intent(MainActivity.this, FirstScreen.class);
                startActivity(in);
                finish();
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
