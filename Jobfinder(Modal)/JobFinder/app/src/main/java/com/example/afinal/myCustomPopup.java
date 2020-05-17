package com.example.afinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class myCustomPopup extends DialogFragment implements Searchfragment.OnInputListener {

    int pos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] joblist = {"Accountant", "Cashier", "Waiter/waitress", "Image labeling", "Janitor", "office clerk"};
        String[] wage = {"$13 an hour", "$35000 - $60,000 a year", "$23 an hour", "voulenteer", "$11 an hour", "$14.62 an hour" };
        String[] Requirementss = {"Highschool diploma", "Highschool diploma", "Highschool diploma", "Highschool diploma", "Highschool diploma", "Highschool diploma," };
        String[] note = {"none", "none", "none", "none", "none", "none"};

        View view = inflater.inflate(R.layout.custompopup, container, false);
        TextView Description = view.findViewById(R.id.Description);
        TextView Wage = view.findViewById(R.id.Wage);
        TextView Requirements = view.findViewById(R.id.Require);
        TextView EmployerN = view.findViewById(R.id.EmployerN);

        Description.setText(joblist[pos]);
        Wage.setText(wage[pos]);
        Requirements.setText(Requirementss[pos]);
        EmployerN.setText(note[pos]);

        Button close = view.findViewById(R.id.close);
        Button apply = view.findViewById(R.id.apply);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Toast.makeText(getActivity(), "You have applied to this job", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });
        return view;
    }


    @Override
    public void sendInput(int input) {
        pos = input;
    }
}
