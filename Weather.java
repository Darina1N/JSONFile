package sk.kosickaakademia.kolesarova.jsonfile;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Weather {
    public static void main(String[] args) {

        JSONParser parser=new JSONParser();
        try{
            Reader reader=new FileReader("resource/weather.json");

            JSONObject object= (JSONObject) parser.parse(reader);

            JSONObject main=(JSONObject) object.get("main");
            Double temperature= (Double) main.get("temp");
            System.out.println("Temperature: "+(temperature-273.15)+ " °C");

            Long pressure=(Long) main.get("pressure");
            System.out.println("Pressure (tlak): "+pressure+" hPA");

            Long visibility= (Long) object.get("visibility");
            System.out.println("Visibility: "+visibility+" m");

            Long humidity=(Long)main.get("humidity");
            System.out.println("Humidity (vlhkosť): "+humidity+" %");


        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }
}
