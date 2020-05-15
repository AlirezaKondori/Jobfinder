package com.example.afinal;

import android.app.Application;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class GlobalClass extends Application {
    private String username;

    public SearchView getSearchView() {
        return searchView;
    }

    public void setSearchView(SearchView searchView) {
        this.searchView = searchView;
    }

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    public TextView getDescription() {
        return Description;
    }

    public void setDescription(TextView description) {
        Description = description;
    }

    public TextView getWage() {
        return Wage;
    }

    public void setWage(TextView wage) {
        Wage = wage;
    }

    public TextView getRequirements() {
        return Requirements;
    }

    public void setRequirements(TextView requirements) {
        Requirements = requirements;
    }

    public TextView getEmployerN() {
        return EmployerN;
    }

    public void setEmployerN(TextView employerN) {
        EmployerN = employerN;
    }

    private SearchView searchView;
    private ListView listView;
    private TextView Description;
    private TextView Wage;
    private  TextView Requirements;
    private TextView EmployerN;


    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }
}
