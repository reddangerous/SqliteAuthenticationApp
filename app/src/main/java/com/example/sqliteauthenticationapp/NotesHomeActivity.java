package com.example.sqliteauthenticationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NotesHomeActivity extends AppCompatActivity {
    DbHelper db;
    FloatingActionButton Add;
    RecyclerView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_home);
        list = findViewById(R.id.notes);
        db = new DbHelper(this);
        Add = findViewById(R.id.AddNew);

       list.setLayoutManager(new LinearLayoutManager(this));


    }
}