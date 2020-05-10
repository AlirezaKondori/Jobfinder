package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
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

        nameInput = (EditText) findViewById(R.id.editText);
        passwordInput = (EditText) findViewById(R.id.editText2);

        button = (Button) findViewById(R.id.puss);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    private void openActivity() {
        globalClass.setName(nameInput.getText().toString());
        password = Integer.valueOf(passwordInput.getText().toString());

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
