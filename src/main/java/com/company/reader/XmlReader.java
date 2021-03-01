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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

public class XmlReader extends Reader {
    public XmlReader() {
        songs = new ArrayList<>();
    }
    @Override
    public ArrayList<Song> Read(String filename) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("playlist.xml"));
        Element element =  document.getDocumentElement();
        NodeList songs = element.getChildNodes();

        for (int i = 0; i < songs.getLength(); i++){
            if (songs.item(i).hasChildNodes()){

                String name  = songs.item(i).getChildNodes().item(1).getTextContent();
                String singer = songs.item(i).getChildNodes().item(3).getTextContent();
                Integer duration  = Integer.parseInt(songs.item(i).getChildNodes().item(5).getTextContent());
                Integer placeInChart = Integer.parseInt(songs.item(i).getChildNodes().item(7).getTextContent());

                Song songItem = new Song(name, singer, duration, placeInChart);
                //System.out.println(songItem.Log());
                this.songs.add(songItem);
                //System.out.println(this.songs.get(0).Log());
            }

        }

        return this.songs;
    }

}
