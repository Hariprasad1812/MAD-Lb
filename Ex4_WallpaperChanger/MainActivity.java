package com.example.wallpaperchanger;


import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.io.IOException;


public class MainActivity extends AppCompatActivity {


    Button btnChangeWallpaper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        btnChangeWallpaper = findViewById(R.id.btnChangeWallpaper);



        btnChangeWallpaper.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                changeWallpaper();


            }
        });


    }



    private void changeWallpaper() {


        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);


        Bitmap bitmap = BitmapFactory.decodeResource(
                getResources(),
                R.drawable.wallpaper
        );


        try {


            wallpaperManager.setBitmap(bitmap);


            Toast.makeText(
                    MainActivity.this,
                    "Wallpaper Changed Successfully",
                    Toast.LENGTH_SHORT
            ).show();



        } catch (IOException e) {


            Toast.makeText(
                    MainActivity.this,
                    "Failed to Change Wallpaper",
                    Toast.LENGTH_SHORT
            ).show();


        }


    }

}
