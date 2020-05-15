package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;


public class Searchfragment extends Fragment  {
    int d;
    public interface OnInputListener{
        void sendInput(int input);
    }
    public OnInputListener onInputListener;

//    private SearchView searchView;
//    private ListView listView;
    myCustomPopup myDialog = new myCustomPopup();
    String[] joblist = {"computer programmer", "Ea gamer", "professional simp", "purple alien", "green alien", "men in black"};
    String[] wage = {"$13 an hour", "$35000 - $60,000 a year", "$23 an hour", "voulenteer", "$11 an hour", "$15 an hour" };
    String[] Requirementss = {"Highschool diploma", "Highschool diploma", "Highschool diploma", "Highschool diploma", "Highschool diploma", "Highschool diploma" };
    String[] note = {"none", "none", "none", "none", "none", "none" };
    MyAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchfragment,container, false);
        ListView listView = view.findViewById(R.id.list_view);

        adapter = new MyAdapter(getContext(), joblist, wage);
        SearchView searchView = view.findViewById(R.id.search_bar);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                d = position;
                Log.d("CREATION", String.valueOf(position));
                switch (position){
                    case 0:
                        showPopup(view);
                        break;
                    case 1:
                        showPopup(view);
                        break;
                    case 2:
                        showPopup(view);
                        break;
                    case 3:
                        showPopup(view);
                        break;
                    case 4:
                        showPopup(view);
                        break;
                    case 5:
                        showPopup(view);
                        break;
                }
            }
        });
//        arrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,joblist);
//        listView.setAdapter(arrayAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               showPopup(view);
//            }
//        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Searchfragment.this.adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Searchfragment.this.adapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }
    public void showPopup(View v) {


        onInputListener.sendInput(d);

        myDialog.show(getFragmentManager(), "MyCustomPopup");

    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rWage[];

        MyAdapter(Context c, String title[], String Wage[]) {
            super(c, R.layout.row, R.id.title, title);
            this.context = c;
            this.rTitle = title;
            this.rWage = Wage;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle = row.findViewById(R.id.title);
            TextView myWage = row.findViewById(R.id.wage);
            myTitle.setText(joblist[position]);
            myWage.setText((wage[position]));

            return row;
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            onInputListener = (OnInputListener) getActivity();
        }catch (ClassCastException e) {

        }
    }
}
