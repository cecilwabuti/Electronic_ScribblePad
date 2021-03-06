package com.cec.doctor.Gallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.cec.doctor.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ImageMainActivity extends Activity implements MediaScannerConnection.MediaScannerConnectionClient {
    public String[] allFiles;
    private String SCAN_PATH ;
    private static final String FILE_TYPE = "*/*";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_grid_layout);



        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startScan();
            }
        });

//        variable declaration

        GridView gridViewP = findViewById(R.id.gridViewP);
        GridView gridViewE = findViewById(R.id.gridViewE);

        // Instance of ImageAdapter Class
        gridViewP.setAdapter(new ImageAdapter(this));
        gridViewE.setAdapter(new ImageAdapter(this));


        /*
          On Click event for Single Grid_view Item
          */
        gridViewE.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent,View v,
                                    int position,long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(),FullImageActivity.class);
                // passing array index
                i.putExtra("id",position);
                startActivity(i);
            }
        });
        gridViewP.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent,View v,
                                    int position,long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(),FullImageActivity.class);
                // passing array index
                i.putExtra("id",position);
                startActivity(i);
            }
        });

    }
    private void startScan() {

    }


    @Override
    public void onMediaScannerConnected() {
//        Log.d("onMediaScannerConnected","success" + conn);
//        conn.scanFile(SCAN_PATH,FILE_TYPE);
    }

    @Override
    public void onScanCompleted(String path,Uri uri) {


    }
}

