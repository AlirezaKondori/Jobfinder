package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    boolean emp;

    Intent intent;

    private Button button;

    GlobalClass globalClass;

    //String username;
    int password;

    EditText nameInput;
    EditText passwordInput;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        globalClass = (GlobalClass) getApplicationContext();

        final SwitchCompat switchCompat = findViewById(R.id.switch1);

        nameInput = (EditText) findViewById(R.id.editText);
        passwordInput = (EditText) findViewById(R.id.editText2);

        button = (Button) findViewById(R.id.puss);
        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchCompat.isChecked()) {
                    emp = true;
                }
                else {
                    emp = false;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    private void openActivity() {
        globalClass.setName(nameInput.getText().toString());
        password = Integer.parseInt(passwordInput.getText().toString());
        if (emp) {
            intent = new Intent(this, Main3Activity.class);
        }
        else {
            intent = new Intent(this, Main2Activity.class);
        }
        startActivity(intent);
    }
}
