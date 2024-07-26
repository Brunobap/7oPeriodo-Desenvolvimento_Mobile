package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView list;
    private String[] vet = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list = findViewById(R.id.listView);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, vet
        );
        list.setAdapter(adaptador);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String x = "";
        x = String.valueOf(list.getItemAtPosition(position).toString());
        Toast.makeText(getApplicationContext(), x, Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, MainActivity3.class));
    }
}