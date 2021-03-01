package com.company.song;

public class Song {
    private String songName;
    private String singer;
    private int duration;
    private int placeInChart;

    public Song(String songName, String singer, int duration, int placeInChart) {
        this.songName = songName;
        this.singer = singer;
        this.duration = duration;
        this.placeInChart = placeInChart;
    }

    public String getSongName() {
        return songName;
    }

    public String getSinger() {
        return singer;
    }

    public int getDuration() {
        return duration;
    }

    public int getPlaceInChart() {
        return placeInChart;
    }

    public String Log() {
        String secs;
        if (this.duration % 60 < 10) {
            secs = "0" + this.duration % 60;
        } else {
            secs = String.valueOf(this.duration % 60);
        }
        String pos;
        if (this.placeInChart == 1000) {
            pos = "не входит в топ.";
        } else {
            pos = "place in chart #" + String.valueOf(this.placeInChart);
        }
        return (this.singer + " - " + this.songName + "\n\t" + this.duration / 60 + ":" + secs + ", " + pos);
    }
    public String Log_2() {


        String pos;
        if (this.placeInChart == 1000) {
            pos = "не входит в топ.";
        } else {
            pos = "place in chart #" + String.valueOf(this.placeInChart);
        }
        return (this.singer + " - " + this.songName + "\t--\t" +  " " + pos);
    }
}
