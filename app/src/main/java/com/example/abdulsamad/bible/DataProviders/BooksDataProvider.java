package com.example.abdulsamad.bible.DataProviders;

/**
 * Created by ABDUL Samad on 6/6/2017.
 */

public class BooksDataProvider {
    String id,name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BooksDataProvider(String id, String name) {

        this.id = id;
        this.name = name;
    }
}
