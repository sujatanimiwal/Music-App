package com.example.android.musiccloud;

public class Song {
    private String msingerName, msongName;
    private int msingerImage, mplayButtonImg;

    public Song(String vsingerName, String vsongName, int vsingerImage, int vplayButtonImg) {
        msingerName = vsingerName;
        msongName = vsongName;
        msingerImage = vsingerImage;
        mplayButtonImg = vplayButtonImg;
    }

    public String getSingerName() {
        return msingerName;
    }

    public String getSongName() {
        return msongName;
    }

    public int getSingerImg() {
        return msingerImage;
    }

    public int getPlayButtonImg() {
        return mplayButtonImg;
    }
}
