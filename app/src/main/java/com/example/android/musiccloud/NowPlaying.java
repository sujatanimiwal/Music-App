package com.example.android.musiccloud;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("picture");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView img= (ImageView)findViewById(R.id.singer_picture);
        img.setImageBitmap(bmp);//setting the image of the NowPlaying activity as the image got from the bundle

        //setting the textview in NowPlaying activity as song's name
        TextView mdetails1= (TextView)findViewById(R.id.song_name);
        String vdetails1= extras.getString("key1");
        if(vdetails1==null)
        {
            mdetails1.setText("Unknown");
        }
        else {
            mdetails1.setText(vdetails1);
        }

        //setting the textview in NowPlaying activity as singer's name
        TextView mdetails2= (TextView)findViewById(R.id.singer_name);
        String vdetails2= extras.getString("key2");
        if(vdetails2==null)
        {
            mdetails2.setText("Unknown");
        }
        else {
            mdetails2.setText(vdetails2);
        }

        //OnClickListener for the Back button in NowPlaying activity to go to the MainActivity which displays list of songs
        Button mBack= (Button)findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(NowPlaying.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }
}
