package com.example.afinal;

import android.app.Application;
import android.widget.ListView;
import android.widget.SearchView;

public class GlobalClass extends Application {
    private String username;
    private SearchView searchView;
    private ListView listView;

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }
}
