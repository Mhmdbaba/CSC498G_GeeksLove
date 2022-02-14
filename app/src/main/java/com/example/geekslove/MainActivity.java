package com.example.geekslove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ArrayList<List<String>> arr;
    TextView output;
    TextView name;

    TableLayout tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arr = new ArrayList<List<String>>();

        Spinner spinner = findViewById(R.id.input_dropdown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        output = (TextView) findViewById(R.id.output_number);

        name = findViewById(R.id.input_name);

        tb = (TableLayout) findViewById(R.id.table);
    }

    public void Calculate(View view){
        Random rand = new Random();
        int rand_number = rand.nextInt(100);

        output.setText(Integer.toString(rand_number) + "/100");

        List<String> temp = new ArrayList<String>();

        temp.add(name.getText().toString());
        temp.add((Integer.toString(rand_number)));

        arr.add(temp);


        // updateTable();


    }

    public void updateTable(){
        for (int i = 0; i < arr.size(); i++){
            TableRow r = new TableRow(this);
            TextView tv = new TextView(this);
            for (int j = 0 ; j < arr.get(i).size(); j++){
                tv.setText(arr.get(i).get(j).toString());
                r.addView(tv);
            }
        }
    }
}