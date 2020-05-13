package com.example.android.musiccloud;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    Context context;
    ArrayList<Song> songs;

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
        this.context = context;
        this.songs = songs;
    }

    @Nullable
    @Override
    public Song getItem(int position) {
        return songs.get(position);
    }

    public View getView(final int position, View convertView, final ViewGroup parent) {
        View songs_view = convertView;
        if (songs_view == null) {
            songs_view = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentSongView = getItem(position);

        ImageView singerImageView = (ImageView) songs_view.findViewById(R.id.singer_img);
        singerImageView.setImageResource(currentSongView.getSingerImg());

        TextView singer_nameTextView = (TextView) songs_view.findViewById(R.id.singer_name);
        singer_nameTextView.setText(currentSongView.getSingerName());

        TextView song_nameTextView = (TextView) songs_view.findViewById(R.id.song_name);
        song_nameTextView.setText(currentSongView.getSongName());

        ImageButton play_buttonImageButton = (ImageButton) songs_view.findViewById(R.id.play_button);
        play_buttonImageButton.setImageResource(currentSongView.getPlayButtonImg());
        play_buttonImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView) parent).performItemClick(v, position, 0);
            }
        });
        return songs_view;

    }
}
