package com.example.afinal;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Jobpostings extends Fragment {
    ListView listView;
    String names[] = {"Bobby", "Sam", "Bill", "Dickenson", "Mohamad", "Ben"};

    public Jobpostings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jobpostings,container, false);
        listView = view.findViewById(R.id.list);

        // Inflate the layout for this fragment
        return view;
    }
    class Myadapter extends ArrayAdapter<String> {
        Context context;
        String rnames[];

        MyAdapter(Context c, String rnames[]) {
            super(c, R.layout.row2, R.id.name);
            this.context = c;
            this.rnames= names;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row2);
            TextView Title;
            return super.getView(position, convertView, parent);
        }
    }
}
