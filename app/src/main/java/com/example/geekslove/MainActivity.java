package com.example.geekslove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
    ImageView img;
    Spinner spinner;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arr = new ArrayList<List<String>>();

        spinner = findViewById(R.id.input_dropdown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        output = (TextView) findViewById(R.id.output_number);
        name = findViewById(R.id.input_name);
        tb = (TableLayout) findViewById(R.id.table);
        img = (ImageView) findViewById(R.id.image);

        count = 0;

    }

    public void Calculate(View view){
        Random rand = new Random();
        int rand_number = rand.nextInt(100);

        output.setText(rand_number + "%");

        List<String> temp = new ArrayList<String>();

        temp.add(spinner.getSelectedItem().toString());
        temp.add((Integer.toString(rand_number)) + "%");

        arr.add(temp);


        if (spinner.getSelectedItem().toString().equalsIgnoreCase("java"))
            img.setImageResource(R.drawable.java);
        else if (spinner.getSelectedItem().toString().equalsIgnoreCase("html and css"))
            img.setImageResource(R.drawable.htmlandcss);
        else if (spinner.getSelectedItem().toString().equalsIgnoreCase("c++"))
            img.setImageResource(R.drawable.cplusplus);
        else if (spinner.getSelectedItem().toString().equalsIgnoreCase("c"))
            img.setImageResource(R.drawable.c);
        else if (spinner.getSelectedItem().toString().equalsIgnoreCase("c#"))
            img.setImageResource(R.drawable.csharp);
        else if (spinner.getSelectedItem().toString().equalsIgnoreCase("swift"))
            img.setImageResource(R.drawable.swift);
        else if (spinner.getSelectedItem().toString().equalsIgnoreCase("javascript"))
            img.setImageResource(R.drawable.javascript);
        else
            img.setImageResource(R.drawable.python);

        img.setTranslationY(2000);

         updateTable();

    }

    public void updateTable(){
        for (int i = count; i < arr.size(); i++){
            TableRow r = new TableRow(this);
            for (int j = 0 ; j < arr.get(i).size(); j++){
                TextView tv = new TextView(this);
                tv.setText(arr.get(i).get(j).toString());
                tv.setPadding(50, 20, 20 , 20);
                tv.setTextSize(18);
                tv.setWidth(200);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                r.addView(tv);
            }
            tb.addView(r);
        }
        count++;
        img.animate().translationYBy(-2000).rotation(3600).setDuration(500);
    }
}