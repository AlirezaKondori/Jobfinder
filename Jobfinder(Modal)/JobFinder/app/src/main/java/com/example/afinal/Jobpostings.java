package com.example.afinal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.app.Dialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Jobpostings extends Fragment {
    Dialog mydialog;
    ListView listView;
    String[] names = {"Bobby", "Sam", "Bill", "Dickenson", "Mohamad", "Ben"};

    public Jobpostings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mydialog = new Dialog(getActivity());
        View view = inflater.inflate(R.layout.fragment_jobpostings,container, false);
        listView = view.findViewById(R.id.list);

        Myadapter adapter = new Myadapter(getContext(), names);
        listView.setAdapter(adapter);
        // Inflate the layout for this fragment
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showpopup(view);
            }
        });

        return view;
    }
    class Myadapter extends ArrayAdapter<String> {
        Context context;
        String rnames[];

        Myadapter(Context c, String[] rnames) {
            super(c, R.layout.row2, R.id.name, names);
            this.context = c;
            this.rnames= names;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row2, parent, false);
            TextView Title = row.findViewById(R.id.name);
            Title.setText(names[position]);
            return row;
        }
    }
    public void showpopup(View v) {
        Button close;
        mydialog.setContentView(R.layout.custompopup2);
        close = (Button) mydialog.findViewById(R.id.close2);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
}
