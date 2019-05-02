package datastore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Gepjarmu;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class Gepjarmuvek {
    private List<Gepjarmu> gepjarmuvek;

    public Gepjarmuvek(List gepjarmuvek){
        this.gepjarmuvek=gepjarmuvek;
    }/*
    public Gepjarmuvek() {
        this(Gepjarmuvek.class.getResourceAsStream("alien.json"));
    }*/
    public Gepjarmuvek(){}
    private Gepjarmuvek(InputStream is) {
        Gson gson = new GsonBuilder().create();
        //Gson gson = new GsonBuilder().registerTypeAdapter(ZoneId.class, new ZoneIdAdapter()).create();
//        Country[] arrayOfCountries = gson.fromJson(new InputStreamReader(is), Country[].class);
//        countries = java.util.Arrays.asList(arrayOfCountries);
        Type type = new TypeToken<List<Gepjarmu>>(){}.getType();
        gepjarmuvek = gson.fromJson(new InputStreamReader(is), type);
    }

    public List<Gepjarmu> getGepjarmuvek() {
        return gepjarmuvek;
    }

    public void setGepjarmuvek(List<Gepjarmu> gepjarmuvek) {
        this.gepjarmuvek = gepjarmuvek;
    }
}
