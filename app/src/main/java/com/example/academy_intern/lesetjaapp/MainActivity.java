package com.example.academy_intern.lesetjaapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String SHARED_PREF_NAME = "mysharedpref";
    private static final String KEY_NAME = "keyname";
    private static final String KEY_SURNAME = "keysurname";

    EditText editText,editText1;
    TextView textView,textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextName);
        editText1=findViewById(R.id.editTextSurname);
        textView1=findViewById(R.id.textViewSurname);
        textView = findViewById(R.id.textViewName);

        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveName();
                displayName();
            }
        });
    }

    private void saveName() {
        String name = editText.getText().toString();
        String surname=editText1.getText().toString();

        if (name.isEmpty()) {
            editText.setError("Name required");
            editText.requestFocus();
            return;
        }
        if (surname.isEmpty()) {
            editText1.setError("Surname required");
            editText1.requestFocus();
            return;
        }
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(KEY_NAME, name);
        editor.putString(KEY_SURNAME,surname);

        editor.apply();

        editText.setText("");
        editText1.setText("");
    }

    private void displayName() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sp.getString(KEY_NAME, null);
        String surname=sp.getString(KEY_SURNAME,null);

        if (name != null) {
            textView.setText( name);
        }
        if (surname != null) {
            textView1.setText( surname);
        }
    }




}

