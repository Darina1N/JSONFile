package sk.kosickaakademia.kolesarova.jsonfile;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class City {
    public static void main(String[] args) {

        JSONParser parser=new JSONParser();

        try{
            Reader reader= new FileReader("resource/city.json");

            JSONObject jsonObject=(JSONObject) parser.parse(reader);
            JSONArray jsonArray=(JSONArray) jsonObject.get("data");
            Iterator<String> iterator= jsonArray.iterator();

            while (iterator.hasNext()) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject object = (JSONObject) jsonArray.get(i);
                    String name = (String) object.get("name");
                    String region = (String) object.get("region");
                    String wikiDataId = (String) object.get("wikiDataId");
                    Double latitude = (Double) object.get("latitude");
                    Double longitude = (Double) object.get("longitude");
                    System.out.println("Name: " + name+ "\nRegion: " + region + "\nWikiDataId: " + wikiDataId + "\nzem.šírka: " + latitude + "\nzem.dĺžka: " + longitude);
                    System.out.println();
                }
            }
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }
}
