package com.company;

import com.company.reader.CsvReader;
import com.company.reader.JsonReader;
import com.company.reader.XmlReader;
import com.company.song.Song;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public App() throws ParserConfigurationException, SAXException, IOException, ParseException {
        XmlReader readerXml = new XmlReader();
        JsonReader readerJson = new JsonReader();
        CsvReader readerCsv = new CsvReader();

        //ArrayList<Song> songs = readerXml.Read("playlist.xml");
        //ArrayList<Song> songs = readerJson.Read("playlist.json");
        ArrayList<Song> songs = readerCsv.Read("playlist.csv");


        System.out.println("Наше русское православное меню:");
        System.out.println("1. Вывести список песен");
        System.out.println("2. Вывести по убыванию позиции в чарте");
        System.out.println("3. Вывести среднюю длину композиции");
        System.out.println("4. Узнать длину плейлиста");
        System.out.println("5. Выбрать песни по исполнителю");
        System.out.println("6. Сказать спасибо автору");
        System.out.println("======================================");
        System.out.println("7. Выйти");
        Scanner scanner = new Scanner(System.in);
        int menuItem = -1;
        while(true) {
            menuItem = scanner.nextInt();
            if(menuItem == 1) {
                System.out.println("==============Плейлист=================");
                for (int i = 0; i < songs.size(); i++) {
                    System.out.println(songs.get(i).Log());
                }
                System.out.println("=======================================");
            } else
            if (menuItem == 2) {
                //readerXml.sortByChart();
                readerJson.sortByChart();
                //readerCsv.sortByChart();
            }
            if (menuItem == 3) {
                //readerXml.averageDur();
                readerJson.averageDur();
                //readerCsv.averageDur();
            }
            if (menuItem == 4) {
                //readerXml.allDur();
                //readerJson.allDur();
                readerCsv.allDur();
            }
            if(menuItem == 5) {
                //readerXml.soutSinger();
                readerJson.soutSinger();
                //readerCsv.soutSinger();
            }
            if(menuItem == 6) {
                //readerXml.thanks();
                readerJson.thanks();
                //readerCsv.thanks();
            }
            if(menuItem == 7) {
                break;
            }
        }



    }
}
