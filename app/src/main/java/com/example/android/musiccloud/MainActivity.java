package com.example.android.musiccloud;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Defining an arraylist song_list
        ArrayList<Song> song_list = new ArrayList<Song>();

        //adding elements to the arraylist by passing an object of class Song
        song_list.add(new Song(getString(R.string.singer_1), getString(R.string.song_1), R.drawable.snoopdog, R.drawable.play));
        song_list.add(new Song(getString(R.string.singer_2), getString(R.string.song_2), R.drawable.nicole, R.drawable.play));
        song_list.add(new Song(getString(R.string.singer_3), getString(R.string.song_3), R.drawable.pitbull, R.drawable.play));
        song_list.add(new Song(getString(R.string.singer_4), getString(R.string.song_4), R.drawable.shakira, R.drawable.play));
        song_list.add(new Song(getString(R.string.singer_5), getString(R.string.song_5), R.drawable.alejandro, R.drawable.play));
        song_list.add(new Song(getString(R.string.singer_6), getString(R.string.song_6), R.drawable.maluma, R.drawable.play));
        song_list.add(new Song(getString(R.string.singer_7), getString(R.string.song_7), R.drawable.liam, R.drawable.play));
        song_list.add(new Song(getString(R.string.singer_4), getString(R.string.song_8), R.drawable.shakira, R.drawable.play));
        song_list.add(new Song(getString(R.string.singer_6), getString(R.string.song_9), R.drawable.maluma, R.drawable.play));
        song_list.add(new Song(getString(R.string.singer_8), getString(R.string.song_10), R.drawable.jbalvin, R.drawable.play));

        SongAdapter items_adapter = new SongAdapter(this, song_list);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(items_adapter);

        //OnItemClickListener for the play button in the list's item layout which will open the NowPlaying activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //getting the image of the song of which the play button is clicked
                Song current_singer = (Song) parent.getItemAtPosition(position);
                int res = current_singer.getSingerImg();

                //creating a bytearray of the respective image
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), res);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                //creating a bundle to send the image and details about the song like song name and artist' name
                Bundle extras = new Bundle();
                String details1 = current_singer.getSongName();// getting the name of the song
                String details2 = current_singer.getSingerName();// getting the name of singer

                Intent intent = new Intent(MainActivity.this, NowPlaying.class);
                extras.putByteArray("picture", byteArray);// passing the image
                extras.putString("key1", details1);//passing name of song
                extras.putString("key2", details2);// passing name of singer
                intent.putExtras(extras);//sending the bundle which contains an image and song's details
                startActivity(intent);// starting the NowPlaying activity
            }
        });
    }
}
