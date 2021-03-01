package com.company.reader;

import com.company.song.Song;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import au.com.bytecode.opencsv.CSVReader;

public class CsvReader extends Reader{
    public CsvReader() {
        songs = new ArrayList<>();
    }

    @Override
    public ArrayList<Song> Read(String filename) throws IOException, SAXException, ParserConfigurationException, ParseException {
        CSVReader reader = new CSVReader(new FileReader(filename), ',' , '"' , 0);


        //Read CSV line by line and use the string array as you want
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {

            //System.out.println(Arrays.toString(nextLine));

            String name = (String) nextLine[0];
            //System.out.println(name);

            String singer = (String) nextLine[1];
            //System.out.println(singer);

            Integer duration =  Integer.parseInt(nextLine[2]);
            //System.out.println(duration);

            Integer place =  Integer.parseInt(nextLine[3]);
            //System.out.println(place);

            Song songItem = new Song(name, singer, duration, place);

            //System.out.println(songItem.Log());
            this.songs.add(songItem);


        }
        return this.songs;
    }
}
