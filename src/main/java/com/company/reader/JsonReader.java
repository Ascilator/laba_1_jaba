package com.company.reader;

import com.company.song.Song;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader extends Reader {
    public JsonReader() {
        songs = new ArrayList<>();
    }

    @Override
    public ArrayList<Song> Read(String filename) throws IOException, SAXException, ParserConfigurationException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader(filename));

        for (Object o : a) {
            JSONObject songItemJson = (JSONObject) o;

            String name = (String) songItemJson.get("name");
            //System.out.println(name);

            String singer = (String) songItemJson.get("singer");
            //.out.println(singer);

            Integer duration =  Integer.parseInt(String.valueOf(songItemJson.get("duration")));
            //System.out.println(duration);

            Integer place =  Integer.parseInt(String.valueOf(songItemJson.get("placeInChart")));
            //System.out.println(place);

            Song songItem = new Song(name, singer, duration, place);


            //System.out.println(songItem.Log());
            this.songs.add(songItem);

        }
        return this.songs;
    }
}
