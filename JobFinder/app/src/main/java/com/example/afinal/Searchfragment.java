package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class Searchfragment extends Fragment {

//    private SearchView searchView;
//    private ListView listView;

    String[] joblist = {"computer programmer", "Ea gamer", "professional simp", "purple alien", "green alien", "men in black"};
    ArrayAdapter<String> arrayAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.searchfragment,container, false);
        ListView listView = view.findViewById(R.id.list_item);
        SearchView searchView = view.findViewById(R.id.search_bar);

        arrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,joblist);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(Searchfragment.this, "You clicked -" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Searchfragment.this.arrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Searchfragment.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;

    }
}
